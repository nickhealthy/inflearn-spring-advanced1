package hello.advanced;

import hello.advanced.trace.logtrace.FieldLogTrace_1;
import hello.advanced.trace.logtrace.LogTrace_1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig_1 {

    @Bean
    public LogTrace_1 logTrace_1() {
        return new FieldLogTrace_1();
    }
}
