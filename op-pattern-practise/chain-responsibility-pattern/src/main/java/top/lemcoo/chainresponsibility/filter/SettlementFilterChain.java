package top.lemcoo.chainresponsibility.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 判断结算单
 *
 * @author zhaowx
 * @date 2023-02-28 14:59
 */
@Slf4j
@Order(20)
@Component
public class SettlementFilterChain extends AbstractInvoiceFilterChain{

    @Override
    protected InvoiceContextData doFilter(InvoiceContextData context) {
        log.info("判断结算单分区是否相同");
        return doNext(context);
    }
}
