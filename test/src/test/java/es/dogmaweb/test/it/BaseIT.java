package es.dogmaweb.test.it;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.dogmaweb.service.MessageService;
import es.dogmaweb.test.BaseTest;
import es.dogmaweb.test.ConfigurationTestApplication;

/**
 * Clase base para la definición de las unidades de pruebas de Liberty.<br/>
 * Todas las unidades de pruebas heredan de esta clase.
 * 
 * @author J. Roman Martin (jromanmartin@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = { "classpath:/config/test-application-context.xml" })
@ContextConfiguration(classes = { ConfigurationTestApplication.class })
public class BaseIT extends BaseTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseIT.class);

    /** Message service for testing */
    @Autowired
    private MessageService messageService = null;

    @Test
    public void testIT() {
        startTimer();

        LOGGER.info("Invoking to Message Service");

        Assert.assertEquals("Hello World!", "Hello World!", this.messageService.getMessage());

        stopTimer();
    }

}
