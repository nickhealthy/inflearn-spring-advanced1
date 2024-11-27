package hello.advanced.app.v3;

import hello.advanced.trace.TraceId_1;
import hello.advanced.trace.TraceStatus_1;
import hello.advanced.trace.hellotrace.HelloTraceV2_1;
import hello.advanced.trace.logtrace.LogTrace_1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3_1 {

    private final LogTrace_1 trace;

    public void save(String itemId) {

        TraceStatus_1 status = null;
        try {
            status = trace.begin("OrderRepositoryV3_1.save()");
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
