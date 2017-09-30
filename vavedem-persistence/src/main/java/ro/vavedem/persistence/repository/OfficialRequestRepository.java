package ro.vavedem.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ro.vavedem.persistence.entities.OfficialRequest;
import ro.vavedem.persistence.entities.Primarie;
import ro.vavedem.persistence.entities.UserAccount;


public interface OfficialRequestRepository extends CrudRepository<OfficialRequest, Long> {

    Page<OfficialRequest> findAll(Pageable pageable);

    Page<OfficialRequest> findByInstitutionAndUserAccount(Primarie institution, UserAccount userAccount, Pageable pageable);

    Page<OfficialRequest> findByInstitution(Primarie institution, Pageable pageable);
}
