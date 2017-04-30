package ro.vavedem.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.vavedem.persistence.entities.Primarie;
import ro.vavedem.persistence.repository.PrimarieCRUDRepository;

import java.util.List;

@Service
public class PrimarieV2ServiceImpl implements PrimarieV2Service {

    @Autowired
    private PrimarieCRUDRepository repository;

    @Override
    public Primarie findOne(Long id) {
        return repository.findOne(id);
    }

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
