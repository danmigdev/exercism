public enum LogLevel {
    UNKNOWN(0),
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    FATAL(42);

    public final int value;

    LogLevel(int value) {
        this.value = value;
    }

    public static LogLevel fromString(String logLevel) {
        switch (logLevel) {
            case "TRC":
                return LogLevel.TRACE;

            case "DBG":
                return LogLevel.DEBUG;

            case "INF":
                return LogLevel.INFO;

            case "WRN":
                return LogLevel.WARNING;

            case "ERR":
                return LogLevel.ERROR;

            case "FTL":
                return LogLevel.FATAL;

            default:
                return LogLevel.UNKNOWN;
        }
    }

}
