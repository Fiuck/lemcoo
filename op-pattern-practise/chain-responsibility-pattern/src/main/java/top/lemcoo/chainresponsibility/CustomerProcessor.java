package top.lemcoo.chainresponsibility;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import top.lemcoo.chainresponsibility.annotations.Zhao;

@Data
public class CustomerProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(">>> before");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(">>> after");
        Zhao zhao = bean.getClass().getAnnotation(Zhao.class);
        if (zhao != null) {
            System.out.println(">>>> " + zhao.value());
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
