package ro.vavedem.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.vavedem.persistence.entities.Localitate;
import ro.vavedem.persistence.repository.LocalitateCRUDRepository;
import ro.vavedem.persistence.service.LocalityService;

import java.util.List;

@Service
public class LocalityServiceImpl implements LocalityService {

    @Autowired
    private LocalitateCRUDRepository repository;

    @Override
    public Localitate findOne(Long id) {
        return repository.findOne(id);
    }

    // TODO this should be restricted to just 50 or 100
    @Override
    public List<Localitate> findAll() {
        return repository.findAll();
    }

    @Override
    public Localitate save(Localitate primarie) {
        return repository.save(primarie);
    }
}
