package hello.advanced.app.v2;

import hello.advanced.trace.TraceStatus_1;
import hello.advanced.trace.hellotrace.HelloTraceV2_1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2_1 {

    private final OrderServiceV2_1 orderService;
    private final HelloTraceV2_1 trace;

    @GetMapping("/v2_1/request")
    public String request(String itemId) {

        TraceStatus_1 status = null;
        try {
            status = trace.begin("OrderControllerV2_1.request()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

        return "success";
    }
}
