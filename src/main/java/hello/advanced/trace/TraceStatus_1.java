package hello.advanced.trace;

public class TraceStatus_1 {

    private TraceId_1 traceId;
    private Long startTimeMs;
    private String message;

    public TraceStatus_1(TraceId_1 traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }

    public TraceId_1 getTraceId() {
        return traceId;
    }
}
