package ro.vavedem.persistence.service;

import ro.vavedem.persistence.entities.Adresa;

import java.util.List;

public interface AdresaService {

    Adresa findOne(Long id);

    List<Adresa> findAll();

    // save or update
    Adresa save(Adresa adresa);

    void delete(Adresa adresa);
}
