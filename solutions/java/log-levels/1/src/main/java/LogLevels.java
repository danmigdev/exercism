public class LogLevels {
    
    private static String parse(String logLine, String separator, int side) {
        if (side < 0 || side > 1) {
            throw new RuntimeException("Invalid side");
        }
        
        String message = "";

        if (logLine != null) {
            String[] parsed = logLine.split(separator);
            int messageLen = parsed.length;

            if (messageLen == 2) {
                message = parsed[side].trim();
            }
        }

        return message;
    }

    public static String message(String logLine) {
        return parse(logLine, "]:", 1);
    }

    public static String logLevel(String logLine) {
        String message = parse(logLine, "]:", 0);
        
        message = parse(message, "\\[", 1).toLowerCase();
        
        return message;
    }

    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
    
}
