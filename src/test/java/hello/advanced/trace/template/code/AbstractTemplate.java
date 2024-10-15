package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 템플릿 메서드 패턴을 적용한 템플릿
 * 1. 템플릿이라는 틀에 변하지 않는 부분을 몰아둔다.
 * 2. 변하는 부분(call() 메서드)은 별도로 호출해서 해결한다.
 */
@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        call(); // 상속으로 구현
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime: {} ms", resultTime);
    }

    protected abstract void call();


}
