package ro.vavedem.persistence.service;

import ro.vavedem.persistence.entities.Localitate;

import java.util.List;

public interface LocalityService {

    Localitate findOne(Long id);

    List<Localitate> findAll();

    Localitate save(Localitate primarie);
}
