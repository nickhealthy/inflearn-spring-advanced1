package hello.advanced.trace.template;

import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 템플릿 메서드 패턴 적용에 적합한 상황을 알아보기 위한 테스트코드 예시
 *  - 변하는 부분: 비즈니스 로직(logic1();, logic2(); 메서드는 비즈니스 로직을 제외하고 모두 동일한 코드)
 *  - 변하지 않는 부분: 시간 측정
 *  - 템플릿 메서드 패턴은 '변하지 않는 부분을 모두 한 곳에 모아두고, 변하는 곳만 비즈니스 로직에 넣는다.'
 *
 */
@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    /**
     * 템플릿 메서드 적용
     * - template1.execute(); 호출 시 템플릿 로직인 AbstractTemplate.execute() 이 호출되며,
     * - 중간에 call() 메서드를 호출하게 된다. call() 메서드는 오버라이딩 되어 있다.
     * 템플릿 메서드 패턴은 이렇게 다형성을 사용해서 변하는 부분과 변하지 않는 부분을 분리하는 방법이다.
     */
    @Test
    void templateMethodV1() {
        SubClassLogic1 template1 = new SubClassLogic1();
        template1.execute();

        SubClassLogic2 template2 = new SubClassLogic2();
        template2.execute();
    }

}
