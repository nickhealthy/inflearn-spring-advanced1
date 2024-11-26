package hello.advanced.app.v2;

import hello.advanced.trace.TraceId_1;
import hello.advanced.trace.TraceStatus_1;
import hello.advanced.trace.hellotrace.HelloTraceV2_1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2_1 {

    private final HelloTraceV2_1 trace;

    public void save(TraceId_1 traceId, String itemId) {

        TraceStatus_1 status = null;
        try {
            status = trace.beginSync(traceId, "OrderRepositoryV2_1.save()");
            // 저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
