package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.Strategy;
import hello.advanced.trace.strategy.code.StrategyLogic1;
import hello.advanced.trace.strategy.code.StrategyLogic2;
import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.ContextV2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 전략 패턴 적용
 * 전략을 파라미터로 전달 받는 방식
 *
 * 1. ContextV1 과 다르게 Context 를 실행할 때마다 전략을 인수로 전달하는 방식이다.
 * - ContextV1은 필드에 전략을 보관하는 '선 조립 후 실행' 방식
 * 2. 이 방식을 사용하면 Context 를 실행하는 시점에 원하는 Strategy 를 전달할 수 있다.
 * - 전략을 더욱 유연한 방식으로 변경 가능하며, 전랴긍ㄹ 바꾸더라도 하나의 Context만 생성한다.
 */
@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /**
     * 전략 패턴 익명 내부 클래스2, 람다
     */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직1 실행"));
        context.execute(() -> log.info("비즈니스 로직2 실행"));
    }

}
