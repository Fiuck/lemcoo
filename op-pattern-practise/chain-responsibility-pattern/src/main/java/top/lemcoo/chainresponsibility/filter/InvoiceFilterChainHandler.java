package top.lemcoo.chainresponsibility.filter;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class InvoiceFilterChainHandler {

    private final List<AbstractInvoiceFilterChain> chains;

    @PostConstruct
    public void init() {
        if (CollUtil.isEmpty(chains)) {
            throw new RuntimeException("not found invoice chain handler");
        }
        // 如果没有按照Order注解排序，则手动排序
        chains.sort(AnnotationAwareOrderComparator.INSTANCE);
        for (int i = 0; i < chains.size(); i++) {
            if (i == chains.size() - 1) {
                chains.get(i).setNext(null);
            } else {
                chains.get(i).setNext(chains.get(i + 1));
            }
        }
    }

    public InvoiceContextData doFilter(InvoiceContextData context) {
        context = chains.get(0).doFilter(context);
        return context;
    }

}
