package ro.vavedem.persistence.service;

import ro.vavedem.persistence.entities.Primarie;

import java.util.List;

//todo rename after move to services
public interface PrimarieV2Service {

    Primarie findOne(Long id);

    List<Primarie> findAll();

    Primarie save(Primarie primarie);

    void delete(Primarie primarie);

    List<Primarie> findByNume(String nume);
}
