package ro.vavedem.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.vavedem.interfaces.IRepository;
import ro.vavedem.persistence.entities.Adresa;

/**
 *
 * @author CoruptiaUcide
 */
@Repository
@Transactional
public class PrimarieRepositoryImpl implements IRepository {

    private static final Logger logger = Logger.getLogger(PrimarieRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void save() {

        /**
         * TODO sterge ! doar pentru testare conexiune
         */
        Adresa a = new Adresa();
        a.setStrada("Strada Soarelui");
        a.setLocalitatea("Dreamland");
        a.setCodPostal("10101010");

        this.entityManager.persist(a);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
