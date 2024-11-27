package hello.advanced.app.v3;

import hello.advanced.trace.TraceStatus_1;
import hello.advanced.trace.hellotrace.HelloTraceV2_1;
import hello.advanced.trace.logtrace.LogTrace_1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3_1 {

    private final OrderServiceV3_1 orderService;
    private final LogTrace_1 trace;

    @GetMapping("/v3_1/request")
    public String request(String itemId) {

        TraceStatus_1 status = null;
        try {
            status = trace.begin("OrderControllerV3_1.request()");
            orderService.orderItem(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

        return "success";
    }
}
