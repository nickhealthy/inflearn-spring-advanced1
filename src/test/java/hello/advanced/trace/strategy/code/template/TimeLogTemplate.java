package hello.advanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 템플릿 콜백 패턴 적용(ContextV2 클래스와 내용은 같다.)
 *
 * - ContextV2 는 변하지 않는 템플릿 역할, 파라미터로 넘어온 Strategy 는 코드를 실행에서 처리(전략)
 * - 이렇게 다른 코드의 인수로서 넘겨주는 실행 가능한 코드를 콜백(callback)이라 한다.
 *
 * 스프링에서 이름에 XxxTemplate 가 있다면 템플릿 콜백 패턴으로 만든 것으로 생각하면 된다.
 */
@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        callback.call();    // 위임

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime: {} ms", resultTime);
    }

}
