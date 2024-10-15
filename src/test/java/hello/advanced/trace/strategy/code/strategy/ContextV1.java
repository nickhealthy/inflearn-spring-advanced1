package hello.advanced.trace.strategy.code.strategy;

import hello.advanced.trace.strategy.code.Strategy;
import lombok.extern.slf4j.Slf4j;

/**
 * 전략패턴 적용
 * 필드에 전략을 보관하는 방식
 * 전략 패턴의 핵심은 context는 strategy 인터페이스에만 의존한다는 점이다.
 * 따라서 strategy의 구현체를 변경하거나 새로 만들어도 Context 코드에는 영향을 주지 않는다.
 *
 * - ContextV1 클래스는 변하지 않는 로직을 가지고 있는 템플릿 역할을 하는 코드이다. 전략 패턴에서는 이것을 컨텍스트(문맥)이라고 한다.
 * - 쉽게 말해, 컨텍스트(문맥)은 크게 변하지 않지만, 그 문맥 속에서 strategy를 통해 일부 전략이 변경되는 것이다.
 *
 * 스프링에서 의존관계 주입에서 사용하는 방식이 전략패턴이다.
 */
@Slf4j
public class ContextV1 {

    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        strategy.call();        // 위임
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
