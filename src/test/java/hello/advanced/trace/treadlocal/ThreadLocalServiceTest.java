package hello.advanced.trace.treadlocal;

import hello.advanced.trace.treadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * ThreadLocal 사용
 *  - 멀티스레드가 동시에 같은 인스턴스의 필드에 접근해서 값을 변경하더라도 동시성 문제가 발생하지 않음
 *  - ThreadLocal 은 쓰레드마다 별도의 저장소에 값을 저장하고, 가져오기 때문에 동시성 문제가 발생하지 않는다.
 */
@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> {
            threadLocalService.logic("userA");
        };

        Runnable userB = () -> {
            threadLocalService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();        // A 실행
//        sleep(2000);        // 동시성 문제 발생X
        sleep(100);         // 동시성 문제 발생X
        threadB.start();        // B 실행

        sleep(3000);    // 테스트 사전 종료를 방지하기 위한 sleep
        log.info("main end");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
