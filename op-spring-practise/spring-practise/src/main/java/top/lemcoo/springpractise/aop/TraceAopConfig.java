package top.lemcoo.springpractise.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Aspect
@Configuration
public class TraceAopConfig {

    @Pointcut("execution(* top.lemcoo.springpractise.controller..*.*(..))")
    public void monitor() {}

    /**
     * 监控追踪
     *
     * @return {@code Advisor}
     */
    @Bean
    public Advisor traceAdvisor() {
        CustomizableTraceInterceptor interceptor = new CustomizableTraceInterceptor();
        interceptor.setEnterMessage("方法进入, 类名: $[targetClassName]: $[methodName] ($[arguments])");
        interceptor.setExitMessage("方法返回, $[methodName](): $[returnValue]");
        interceptor.setUseDynamicLogger(true);
        interceptor.setExceptionMessage("发生了异常");
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("top.lemcoo.springpractise.aop.TraceAopConfig.monitor()");
        return new DefaultPointcutAdvisor(pointcut, interceptor);
    }
}
