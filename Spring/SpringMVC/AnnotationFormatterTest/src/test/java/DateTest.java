import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    @Test
    public void testDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        System.out.println(simpleDateFormat.format(date));
    }
}
