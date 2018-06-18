package top.mcwebsite.eventinaction.mclistener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import top.mcwebsite.eventinaction.mcevent.McEvent;

import static junit.framework.TestCase.assertNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class McListenerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testMcListener() {
        McEvent event = new McEvent("Hello World");
        event.setMessage("hello");
        webApplicationContext.publishEvent(event);
    }

}
