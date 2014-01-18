package es.dogmaweb.test.unit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
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
@ContextConfiguration(classes = { ConfigurationTestApplication.class })
public class BaseUnitTest extends BaseTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseUnitTest.class);

    /** Message service for testing */
    @Autowired
    private MessageService messageService = null;

    /**
     * Inicializacion de los atributos para el test
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        LOGGER.info("setUpBeforeClass: DONE");
    }

    /**
     * Destruccion de los atributos necesarios para el test
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        LOGGER.info("tearDownAfterClass: DONE");
    }

    /**
     * Inicializacion de los atributos para el test
     */
    @Before
    public void setUpBeforeTest() throws Exception {
        Assert.assertNotNull("Message Service instanciated", this.messageService);

        LOGGER.info("setUpBeforeTest: DONE");
    }

    /**
     * Destruccion de los atributos necesarios para el test
     */
    @After
    public void tearDownAfterTest() throws Exception {
        LOGGER.info("tearDownAfterTest: DONE");
    }

    /**
     * Implementacion base de test
     */
    @Test
    public void testTest() {
        startTimer();

        Assert.assertEquals("Hello World!", "Hello World!", this.messageService.getMessage());

        stopTimer();
    }

}
