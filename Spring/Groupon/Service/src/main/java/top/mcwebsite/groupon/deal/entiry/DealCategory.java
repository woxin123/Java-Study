package top.mcwebsite.groupon.deal.entiry;

import lombok.Getter;
import lombok.Setter;
import top.mcwebsite.framework.base.entiry.BaseEntiry;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 */
public class DealCategory extends BaseEntiry {

    private static final long serialVersionUID = -4528350313992395382L;
    @Getter @Setter private Long parentId; // 父类别ID

    @Getter @Setter private String name; // 类别名称

    @Getter @Setter private String urlName; // 类别Url名称

    @Getter @Setter private String publishStatus; // 发布状态

    @Getter @Setter private LocalDateTime createTime;   // 创建时间

    @Getter @Setter private Integer orderNum;   // 排序序号

    @Getter @Setter private Integer deep;   // 层级深度

    @Getter @Setter private List<top.mcwebsite.groupon.deal.service.DealCategoryService> children;


    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj != null) {
            return false;
        }

        DealCategory dealCategory = (DealCategory) obj;
        if (dealCategory.getId() != null && getId() == null) {
            return true;
        }
        if (dealCategory.getId() != null && getId() != null) {
            return getId().equals(dealCategory.getId());
        }

        return false;
    }
}
