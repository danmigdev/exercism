import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.LinkedList;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.util.stream.Collectors;

class GrepTool {

    private static final String FLAG_N = "-n";
    private static final String FLAG_L = "-l";
    private static final String FLAG_I = "-i";
    private static final String FLAG_V = "-v";
    private static final String FLAG_X = "-x";

//    private ListStringBuilder result = new StringBuilder();

    private List<String> result = new LinkedList<String>();

    String grep(String pattern, List<String> flags, List<String> files) {
        if (!checkFlags(flags)) {
            return "";
        }

        boolean prepend = false;
        boolean onlyNames = false;
        boolean caseInsensitive = false;
        boolean invert = false;
        boolean fullLine = false;
        boolean multipleFiles = false;

        for (String flag : flags) {
            switch (flag) {
                case FLAG_N:
                    prepend = true;
                    break;

                case FLAG_L:
                    onlyNames = true;
                    break;

                case FLAG_I:
                    caseInsensitive = true;
                    break;

                case FLAG_V:
                    invert = true;
                    break;

                case FLAG_X:
                    fullLine = true;
                    break;

                default:
            }
        }

        for (String file : files) {
            BufferedReader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get(file));
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

            String line = "";
            int lineNumber = 0;

            while (true) {
                try {
                    if ((line = reader.readLine()) == null) break;
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }

                lineNumber++;
                multipleFiles = files.size() > 1;

                manageFlags(lineNumber, result, pattern, line, file, prepend, onlyNames, caseInsensitive, invert, fullLine, multipleFiles);
            }

            try {
                reader.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result.stream().collect(Collectors.joining()).replaceAll("\n$", "");
    }

    private void manageFlags(int lineNumber, List<String> result, String pattern, String line, String file, boolean prepend, boolean onlyNames, boolean caseInsensitive, boolean invert, boolean fullLine, boolean multipleFiles) {
        String originalLine = line;

        if (caseInsensitive) {
            line = line.toLowerCase();
            pattern = pattern.toLowerCase();
        }

        if (fullLine) {
            if (line.equals(pattern) ^ invert) {
                String builtLine = getLine(prepend, onlyNames, file, lineNumber, originalLine, multipleFiles);
                
                if (!result.contains(builtLine)) {
                    result.add(builtLine);
                }
            }
        }
        else {
            if (line.contains(pattern) ^ invert) {
                String builtLine = getLine(prepend, onlyNames, file, lineNumber, originalLine, multipleFiles);
                
                if (!result.contains(builtLine)) {
                    result.add(builtLine);
                }
            }
        }
    }

    private String getLine(boolean prepend, boolean onlyNames, String file, int lineNumber, String line, boolean multipleFiles) {
        String prefix = "";

        if (multipleFiles) {
            prefix = file + ":" + line + "\n";
            
            if (prepend) {
                prefix = file + ":" + lineNumber + ":" + line + "\n";
            }

            if (onlyNames) {
                prefix = file + "\n";
            }
        }
        else {
            prefix = line + "\n";
            
            if (prepend) {
                prefix = lineNumber + ":" + line + "\n";
            }

            if (onlyNames) {
                prefix = file + "\n";
            }
        }

        return prefix;
    }

    private boolean checkFlags(List<String> flags) {
        boolean valid = false;

        for (String flag : flags) {
            switch (flag) {
                case FLAG_N: case FLAG_L: case FLAG_I: case FLAG_V: case FLAG_X:
                    valid = true;
                    break;

                default:
                    valid = false;
            }

            if (!valid) {
                break;
            }
        }

        return valid || flags.isEmpty();
    }

}