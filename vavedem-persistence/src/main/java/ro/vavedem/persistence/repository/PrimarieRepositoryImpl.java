package ro.vavedem.persistence.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.vavedem.interfaces.IPersistenceConnection;
import ro.vavedem.interfaces.IRepository;

/**
 *
 * @author CoruptiaUcide
 */
@Repository
public class PrimarieRepositoryImpl implements IRepository {

    private static final Logger logger = Logger.getLogger(PrimarieRepositoryImpl.class);

    @Autowired
    private IPersistenceConnection persistenceConnection;

}
