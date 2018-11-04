package top.mcwebsite.common;

import javax.servlet.http.HttpSession;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author mengchen
 * @time 18-10-28 下午8:05
 */
public enum ResponseCodeEnum {
    /**
     * 成功
     */
    SUCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;

    ResponseCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
