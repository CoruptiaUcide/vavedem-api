/**
 * @author CoruptiaUcide
 */
package ro.vavedem.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import ro.vavedem.persistence.entities.EmailAudit;

import java.util.List;

public interface EmailRepository extends CrudRepository<EmailAudit, Long> {

    List<EmailAudit> findAll();

    EmailAudit save(EmailAudit mail);

}
