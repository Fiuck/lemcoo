package top.lemcoo.chainresponsibility.filter;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 发票责任链上下文数据
 *
 * @author zhaowx
 * @date 2023-02-28 14:26
 */
@Data
@Accessors(chain = true)
public class InvoiceContextData implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long invoiceId;

    /**
     * 运单列表
     */
    private List<String> transIds;

}
