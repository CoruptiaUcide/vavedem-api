package ro.vavedem.persistence;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ro.vavedem.interfaces.IPersistenceConnection;
import ro.vavedem.persistence.properties.MongoPropertiesBean;

/**
 * @author bvolosincu
 *
 */
@Component
public class PersistenceConnectionImpl implements IPersistenceConnection {

    private static final Logger logger = Logger.getLogger(PersistenceConnectionImpl.class);

    private MongoPropertiesBean config;

    /**
     *
     */
    public PersistenceConnectionImpl(MongoPropertiesBean config) {

        this.config = config;
    }

}
