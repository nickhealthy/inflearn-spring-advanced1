package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;

/**
 * 로그 추적기를 위한 인터페이스
 * 향후 다양한 구현체로 변경 가능하도록 인터페이스로 정의
 */
public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
