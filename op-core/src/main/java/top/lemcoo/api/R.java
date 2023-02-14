package top.lemcoo.api;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

/**
 * 统一API响应结果封装
 *
 * @author xiying
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     * @mock 200
     */
    private int code;
    /**
     * 成功标志
     * @mock true
     */
    private boolean success;
    /**
     * 数据
     */
    private T data;
    /**
     * 消息
     */
    private String message;

    private R(IResultCode resultCode) {
        this(resultCode, null, resultCode.getMessage());
    }

    private R(IResultCode resultCode, String message) {
        this(resultCode, null, message);
    }

    private R(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMessage());
    }

    private R(IResultCode resultCode, T data, String message) {
        this(resultCode.getCode(), data, message);
    }

    private R(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.success = ResultCode.SUCCESS.code == code;
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isSuccess(@Nullable R<?> result) {
        return Optional.ofNullable(result).map(x -> Objects.equals(ResultCode.SUCCESS.code, x.code)).orElse(Boolean.FALSE);
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isNotSuccess(@Nullable R<?> result) {
        return !R.isSuccess(result);
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> data(T data) {
        return data(data, "操作成功");
    }

    /**
     * 返回R
     *
     * @param data    数据
     * @param message 消息
     * @param <T>     T 泛型标记
     * @return R
     */
    public static <T> R<T> data(T data, String message) {
        return data(HttpServletResponse.SC_OK, data, message);
    }

    /**
     * 返回R
     *
     * @param code    状态码
     * @param data    数据
     * @param message 消息
     * @param <T>     T 泛型标记
     * @return R
     */
    public static <T> R<T> data(int code, T data, String message) {
        return new R<>(code, data, data == null ? "暂无承载数据" : message);
    }

    /**
     * 返回R
     *
     * @param message 消息
     * @param <T>     T 泛型标记
     * @return R
     */
    public static <T> R<T> success(String message) {
        return new R<>(ResultCode.SUCCESS, message);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> success(IResultCode resultCode) {
        return new R<>(resultCode);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param message    消息
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> success(IResultCode resultCode, String message) {
        return new R<>(resultCode, message);
    }

    /**
     * 返回R
     *
     * @param message 消息
     * @param <T>     T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(String message) {
        return new R<>(ResultCode.FAILURE, message);
    }


    /**
     * 返回R
     *
     * @param code    状态码
     * @param message 消息
     * @param <T>     T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(int code, String message) {
        return new R<>(code, null, message);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(IResultCode resultCode) {
        return new R<>(resultCode);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param message    消息
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(IResultCode resultCode, String message) {
        return new R<>(resultCode, message);
    }

    /**
     * 返回R
     *
     * @param flag 成功状态
     * @return R
     */
    public static <T> R<T> status(Boolean flag) {
        return flag ? success("操作成功") : fail("操作失败");
    }

}
