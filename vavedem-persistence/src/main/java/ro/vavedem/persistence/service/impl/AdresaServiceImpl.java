package ro.vavedem.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.vavedem.persistence.entities.Adresa;
import ro.vavedem.persistence.repository.AdresaCRUDRepository;
import ro.vavedem.persistence.service.AdresaService;

import java.util.List;

@Service
public class AdresaServiceImpl implements AdresaService {

    @Autowired
    private AdresaCRUDRepository repository;

    @Override
    public Adresa findOne(Long id) {
        return repository.findOne(id);
    }

    // TODO this should be restricted to just 50 or 100
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
