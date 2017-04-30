package ro.vavedem.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import ro.vavedem.persistence.entities.Adresa;

import java.util.List;


public interface AdresaCRUDRepository extends CrudRepository<Adresa, Long> {

    Adresa findOne(Long id);

    List<Adresa> findAll();

    // save or update
    Adresa save(Adresa adresa);

    void delete(Adresa adresa);
}
