package ro.vavedem.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.vavedem.persistence.properties.MongoPropertiesBean;

@Configuration
public class Config {

    @Bean
    public MongoPropertiesBean getMongoPropertiesBean() {
        return new MongoPropertiesBean();
    }
}
