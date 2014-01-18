package es.dogmaweb.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import es.dogmaweb.service.MessageService;

@Configuration
@ComponentScan("es.dogmaweb")
public class ConfigurationTestApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConfigurationTestApplication.class);

    public ConfigurationTestApplication() {
        LOGGER.info("Configuration for Test Application created");
    }

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

}
