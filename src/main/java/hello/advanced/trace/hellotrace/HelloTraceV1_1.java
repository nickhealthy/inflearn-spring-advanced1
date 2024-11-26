package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceId_1;
import hello.advanced.trace.TraceStatus_1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 실제 로그를 생성하고, 처리하는 클래스
 */
@Slf4j
@Component
public class HelloTraceV1_1 {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    public TraceStatus_1 begin(String message) {
        TraceId_1 traceId = new TraceId_1();
        long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);

        return new TraceStatus_1(traceId, startTimeMs, message);
    }

    public void end(TraceStatus_1 traceStatus) {
        complete(traceStatus, null);
    }

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
    }

    private String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= level; i++) {
            sb.append((i == level) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }


}
