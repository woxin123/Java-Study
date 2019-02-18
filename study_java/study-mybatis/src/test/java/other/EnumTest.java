package other;

import org.junit.Test;
import top.mcwebsite.study_mybatis.type.Enabled;

/**
 * @author mengchen
 * @time 18-12-30 下午1:39
 */
public class EnumTest {
    @Test
    public void testGetEnumValueOf() {
        Enabled e = Enabled.valueOf("disabled");
        Enabled disabled = Enum.valueOf(Enabled.class, "disabled");
        System.out.println(e);
        System.out.println(disabled);
    }
}
