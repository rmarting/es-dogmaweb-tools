package es.dogmaweb.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * Clase base para la definición de las unidades de pruebas de Liberty.<br/>
 * Todas las unidades de pruebas heredan de esta clase.
 * 
 * @author J. Roman Martin (jromanmartin@gmail.com)
 */
public abstract class BaseTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    /** Watch for timing */
    protected StopWatch watch = null;

    /**
     * Inicio de tiempos de ejecuci�n
     */
    protected void startTimer() {
        this.watch = new StopWatch();
        this.watch.start();

        LOGGER.info("Test Timer started");
    }

    /**
     * Fin de tiempos de ejecuci�n.<br/>
     * Registra en el log el tiempo ejecuci�n. Si el tiempo es superior a 5 sg (5000ms) se registra como mensaje de
     * emergencia.
     */
    protected void stopTimer() {
        this.watch.stop();

        LOGGER.info("Test Timer finished in {} millisecons", this.watch.getTotalTimeMillis());
    }

}
