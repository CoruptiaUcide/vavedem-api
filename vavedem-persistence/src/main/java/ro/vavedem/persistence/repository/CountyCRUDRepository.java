package ro.vavedem.persistence.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ro.vavedem.models.CountyCode;
import ro.vavedem.persistence.entities.Judet;

import java.util.List;

public interface CountyCRUDRepository extends CrudRepository<Judet, Long> {

    List<Judet> findAll();

    Judet findOne(Long id);

    List<Judet> findByCode(String code);

    Judet findFirstByCode(String code);

    List<Judet> findByCode(String code, Pageable pageable);

    List<CountyCode> findByOrderByCodeAsc();
}
