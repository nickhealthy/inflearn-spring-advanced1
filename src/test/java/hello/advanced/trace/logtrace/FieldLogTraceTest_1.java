package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus_1;
import org.junit.jupiter.api.Test;

public class FieldLogTraceTest_1 {

    FieldLogTrace_1 trace = new FieldLogTrace_1();

    @Test
    void begin_end_level2() {
        TraceStatus_1 status1 = trace.begin("hello1");
        TraceStatus_1 status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus_1 status1 = trace.begin("hello1");
        TraceStatus_1 status2 = trace.begin("hello2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());

    }
}
