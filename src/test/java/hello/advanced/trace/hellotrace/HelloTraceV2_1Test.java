package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus_1;
import org.junit.jupiter.api.Test;

class HelloTraceV2_1Test {
    @Test
    void begin_end_level2() {
        HelloTraceV2_1 trace = new HelloTraceV2_1();
        TraceStatus_1 status1 = trace.begin("hello1");
        TraceStatus_1 status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        HelloTraceV2_1 trace = new HelloTraceV2_1();
        TraceStatus_1 status1 = trace.begin("hello1");
        TraceStatus_1 status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}