package top.lemcoo.chainresponsibility.filter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.lemcoo.chainresponsibility.annotations.Zhao;

/**
 * 判断企业索取发票
 *
 * @author zhaowx
 * @date 2023-02-28 14:58
 */
@Zhao("DeptAskForFilterChain")
@Slf4j
@Order(10)
@Component
@AllArgsConstructor
public class DeptAskForFilterChain extends AbstractInvoiceFilterChain{

    @Override
    protected InvoiceContextData doFilter(InvoiceContextData context) {
        log.info("判断企业是否有索取资格");
        return doNext(context);
    }
}
