package top.mcwebsite.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author mengchen
 * @time 18-11-1 下午10:40
 */
public class Const {
    public static final String CURRENT_USER = "current_user";

    public interface ProductListOrderBy {
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }

    public interface Cart {
        /**
         * 选中状态
         */
        int checked = 1;
        /**
         * 购物车中未选中状态
         */
        int unChecked = 0;

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
    }

    public interface Role {
        /**
         * 普通用户
         */
        int ROLE_CUSTOMER = 0;

        /**
         * 管理员
         */
        int ROLE_ADMIN = 1;
    }

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public enum ProductStatusEnum {
        /**
         * 表示正在出售
         */
        ON_SALE(1, "在线");
        private String value;
        private int code;
        ProductStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


}
