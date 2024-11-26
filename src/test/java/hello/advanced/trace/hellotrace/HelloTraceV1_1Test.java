package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus_1;
import org.junit.jupiter.api.Test;

public class HelloTraceV1_1Test {

    @Test
    void begin_end() {
        HelloTraceV1_1 helloTrace = new HelloTraceV1_1();
        TraceStatus_1 status = helloTrace.begin("hello");
        helloTrace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTraceV1_1 helloTrace = new HelloTraceV1_1();
        TraceStatus_1 status = helloTrace.begin("hello");
        helloTrace.exception(status, new IllegalStateException("test"));
    }

}
