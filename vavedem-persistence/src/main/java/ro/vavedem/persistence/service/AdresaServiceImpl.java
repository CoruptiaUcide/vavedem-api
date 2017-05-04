package ro.vavedem.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.vavedem.persistence.entities.Adresa;
import ro.vavedem.persistence.repository.AdresaCRUDRepository;

import java.util.List;
// TODO to be moved to services module
@Service
public class AdresaServiceImpl implements AdresaService {

    @Autowired
    private AdresaCRUDRepository repository;

    @Override
    public Adresa findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Adresa> findAll() {
        return repository.findAll();
    }

    @Override
    public Adresa save(Adresa adresa) {
        return repository.save(adresa);
    }

    @Override
    public void delete(Adresa adresa) {
        repository.delete(adresa);
    }
}
