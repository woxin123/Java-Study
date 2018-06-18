package top.mcwebsite.framework.base.entiry;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BaseEntiry implements Serializable {

    private static final long serialVersionUID = 8801139907230981900L;

    @Getter @Setter private Long id;
    @Getter @Setter private String routerCall;
}
