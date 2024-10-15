package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

/**
 * 템플릿 메서드 패턴 적용
 * - 템플릿에 변하지 않는 부분은 부모인 현재 클래스에 몰아넣고,
 * - 변하는 부분은 상속을 통해 별도로 구현한다.
 * @param <T>
 */
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;

        try {
            status = trace.begin(message);

            // 로직 호출
            T result = call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;    // 기존 로직에서 영향이 없도록 예외를 꼭 다시 던져야한다.
        }
    }

    protected abstract T call();
}
