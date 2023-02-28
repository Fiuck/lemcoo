package top.lemcoo.chainresponsibility.filter;

import java.util.Objects;

/**
 * 发票责任链
 *
 * @author zhaowx
 * @date 2023-02-28 14:49
 */
public abstract class AbstractInvoiceFilterChain{

    /**
     * 下一个过滤器链
     */
    private AbstractInvoiceFilterChain nextFilterChain;

    /**
     * 执行下一个
     *
     * @param context 上下文
     * @return {@code InvoiceContextData}
     */
    public InvoiceContextData doNext(InvoiceContextData context) {
        if (Objects.isNull(getNext())) {
            return context;
        }
        return getNext().doFilter(context);
    }

    /**
     * 执行过滤器
     *
     * @param context 上下文
     * @return {@code InvoiceContextData}
     */
    protected abstract InvoiceContextData doFilter(InvoiceContextData context);

    public AbstractInvoiceFilterChain getNext() {
        return this.nextFilterChain;
    }

    public void setNext(AbstractInvoiceFilterChain nextFilterChain) {
        this.nextFilterChain = nextFilterChain;
    }
}
