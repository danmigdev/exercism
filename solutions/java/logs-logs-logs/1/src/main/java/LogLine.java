import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLine {

    private final String logLine;
    private final Matcher matcher;

    public LogLine(String logLine) {
        this.logLine = logLine;

        matcher = Pattern.compile("\\[(.*?)]").matcher(logLine);
    }

    public LogLevel getLogLevel() {
        return matcher.find() ? LogLevel.fromString(matcher.group(1)) : null;
    }

    public String getOutputForShortLog() {
        return matcher.find()
                ? LogLevel.fromString(matcher.group(1)).value + ":" + logLine.split(":")[1].replaceAll("^\\s+", "")
                : null;
    }

}
