package top.lemcoo.chainresponsibility.filter;

import cn.hutool.core.collection.CollUtil;
import com.zczy.common.exception.ServiceException;
import com.zczy.invoice.service.InvoiceAskDeptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 判断企业索取发票
 *
 * @author zhaowx
 * @date 2023-02-28 14:58
 */
@Slf4j
@Order(10)
@Component
@AllArgsConstructor
public class DeptAskForFilterChain extends AbstractInvoiceFilterChain{

    private final InvoiceAskDeptService askDeptService;

    @Override
    protected InvoiceContextData doFilter(InvoiceContextData context) {
        log.info("判断企业是否有索取资格");
        if (CollUtil.isNotEmpty(context.getTransIds())) {
            // 判断企业是否可以索取发票
            Boolean askDept = askDeptService.isAskDept(context.getTransIds().get(0));
            if (!askDept) {
                throw new ServiceException("当前企业暂不支持发票索取，请联系管理员");
            }
        }
        return doNext(context);
    }
}
