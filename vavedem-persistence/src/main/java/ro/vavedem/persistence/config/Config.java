package ro.vavedem.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.vavedem.persistence.properties.MongoPropertiesBean;

@Configuration
public class Config {

    // todo this will be put in application.yml and the datasource will be
    // created automatically and injected as a bean in the entire app
    @Bean
    public MongoPropertiesBean getMongoPropertiesBean() {
        return new MongoPropertiesBean();
    }
}
