package top.mcwebsite.webflux2.exception;

import lombok.Data;

/**
 * @author mengchen
 * @time 18-8-24 下午9:02
 */
@Data
public class CheckException extends RuntimeException {

    public CheckException() {
    }

    /**
     * 出错字段的名字
     */
    private String fieldName;

    /**
     * 出错字段的值
     */
    private String fieldValue;

    public CheckException(String fieldName, String fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
