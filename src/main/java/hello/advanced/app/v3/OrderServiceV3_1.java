package hello.advanced.app.v3;

import hello.advanced.trace.TraceId_1;
import hello.advanced.trace.TraceStatus_1;
import hello.advanced.trace.hellotrace.HelloTraceV2_1;
import hello.advanced.trace.logtrace.LogTrace_1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3_1 {

    private final OrderRepositoryV3_1 orderRepository;
    private final LogTrace_1 trace;

    public void orderItem(String itemId) {

        TraceStatus_1 status = null;
        try {
            status = trace.begin("OrderServiceV3_1.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
