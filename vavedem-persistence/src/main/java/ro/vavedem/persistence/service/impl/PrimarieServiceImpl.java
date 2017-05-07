package ro.vavedem.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.vavedem.persistence.entities.Primarie;
import ro.vavedem.persistence.repository.PrimarieCRUDRepository;
import ro.vavedem.persistence.service.PrimarieService;

import java.util.List;

@Service
public class PrimarieServiceImpl implements PrimarieService {

    @Autowired
    private PrimarieCRUDRepository repository;

    @Override
    public Primarie findOne(Long id) {
        return repository.findOne(id);
    }

    // TODO this should be restricted to just 50 or 100
    @Override
    public List<Primarie> findAll() {
        return repository.findAll();
    }

    @Override
    public Primarie save(Primarie primarie) {
        return repository.save(primarie);
    }

    @Override
    public void delete(Primarie primarie) {
        repository.delete(primarie);
    }

    @Override
    public List<Primarie> findByNume(String nume) {
        return repository.findByNume(nume);
    }
}
