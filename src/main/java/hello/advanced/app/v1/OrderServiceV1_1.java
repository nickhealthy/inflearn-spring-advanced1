package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus_1;
import hello.advanced.trace.hellotrace.HelloTraceV1_1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1_1 {

    private final OrderRepositoryV1_1 orderRepository;
    private final HelloTraceV1_1 trace;

    public void orderItem(String itemId) {

        TraceStatus_1 status = null;
        try {
            status = trace.begin("OrderServiceV1_1.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
