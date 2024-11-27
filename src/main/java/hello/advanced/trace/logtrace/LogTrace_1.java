package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus_1;

public interface LogTrace_1 {

    TraceStatus_1 begin(String message);

    void end(TraceStatus_1 status);
    void exception(TraceStatus_1 status, Exception e);

}

