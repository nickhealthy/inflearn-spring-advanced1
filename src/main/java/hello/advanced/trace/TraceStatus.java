package hello.advanced.trace;

/**
 * 로그의 상태 정보를 나타낸다.
 */
public class TraceStatus {
    private final TraceId traceId;  // 내부에 트랜잭션 ID와 level 을 가지고 있다.
    private final Long startTimeMs; // 로그 시작시간
    private final String message;   // 시작시 사용한 메시지

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
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

    public TraceId getTraceId() {
        return traceId;
    }
}