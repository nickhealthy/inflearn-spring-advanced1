package hello.advanced.app.v2;

import hello.advanced.trace.TraceId_1;
import hello.advanced.trace.TraceStatus_1;
import hello.advanced.trace.hellotrace.HelloTraceV2_1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2_1 {

    private final OrderRepositoryV2_1 orderRepository;
    private final HelloTraceV2_1 trace;

    public void orderItem(TraceId_1 traceId, String itemId) {

        TraceStatus_1 status = null;
        try {
            status = trace.beginSync(traceId, "OrderServiceV2_1.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
