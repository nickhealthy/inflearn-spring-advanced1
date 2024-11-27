package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceId_1;
import hello.advanced.trace.TraceStatus_1;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldLogTrace_1 implements LogTrace_1 {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    private TraceId_1 traceIdHolder;  // traceId 동기화, 동시성 이슈 발생

    @Override
    public TraceStatus_1 begin(String message) {
        syncTraceId();
        long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceIdHolder.getId(), addSpace(START_PREFIX, traceIdHolder.getLevel()), message);

        return new TraceStatus_1(traceIdHolder, startTimeMs, message);
    }

    @Override
    public void end(TraceStatus_1 traceStatus) {
        complete(traceStatus, null);
    }

    @Override
    public void exception(TraceStatus_1 traceStatus, Exception e) {
        complete(traceStatus, e);
    }

    private void complete(TraceStatus_1 traceStatus, Exception e) {
        long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - traceStatus.getStartTimeMs();
        TraceId_1 traceId = traceStatus.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms",
                    traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), traceStatus.getMessage(), resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}",
                    traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), traceStatus.getMessage(), resultTimeMs, e.toString());
        }

        releaseTraceId();
    }

    private String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= level; i++) {
            sb.append((i == level) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }

    private void syncTraceId() {
        if (traceIdHolder == null) {
            traceIdHolder = new TraceId_1();
        } else {
            traceIdHolder = traceIdHolder.createNextId();
        }
    }

    private void releaseTraceId() {
        if (traceIdHolder.isFirstLevel()) {
            traceIdHolder = null;   // destroy
        } else {
            traceIdHolder = traceIdHolder.createPreviousId();
        }
    }
}
