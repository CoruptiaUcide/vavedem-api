package ro.vavedem.persistence.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ro.vavedem.persistence.entities.Primarie;

import java.util.List;

public interface PrimarieRepository extends CrudRepository<Primarie, Long> {

    Primarie findOne(Long id);

    List<Primarie> findAll();

    List<Primarie> findAll(Pageable pageable);

    Primarie save(Primarie primarie);

    void delete(Primarie primarie);

    List<Primarie> findByNume(String nume);

}
