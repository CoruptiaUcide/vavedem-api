package ro.vavedem.persistence;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ro.vavedem.persistence.properties.MongoPropertiesBean;

/**
 * @author bvolosincu
 *
 */
@Component
@Configuration
public class PersistenceConnectionImpl {

    private static final Logger logger = Logger.getLogger(PersistenceConnectionImpl.class);

    @Autowired
    private MongoPropertiesBean config;

    public PersistenceConnectionImpl(MongoPropertiesBean config) {

        this.config = config;
    }

}
