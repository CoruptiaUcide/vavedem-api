package ro.vavedem.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ro.vavedem.exceptions.VaVedemApiException;
import ro.vavedem.exceptions.VaVedemNotFoundException;
import ro.vavedem.exceptions.VaVedemPersistenceException;
import ro.vavedem.interfaces.Service;
import ro.vavedem.models.LocalitateModel;
import ro.vavedem.persistence.entities.Localitate;
import ro.vavedem.persistence.repository.LocalitateRepository;
import ro.vavedem.services.util.LocalitateServUtil;

import javax.transaction.NotSupportedException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class LocalitateService implements Service<LocalitateModel> {

    private static final Logger logger = Logger.getLogger(LocalitateService.class);

    @Autowired
    private LocalitateRepository repository;

    @Override
    public LocalitateModel findOne(Long id) throws VaVedemApiException {
        final Localitate entity = repository.findOne(id);
        if(null == entity){
            throw new VaVedemNotFoundException("Not found any record with id: " + id);
        }
        return LocalitateServUtil.convertToModel(entity);
    }

    @Override
    public List<LocalitateModel> findAll() throws VaVedemApiException{
        final List<LocalitateModel> models = new ArrayList<LocalitateModel>();
        final List<Localitate> entities = repository.findAll();

        for(Localitate e : entities){
            models.add(LocalitateServUtil.convertToModel(e));
        }
        return models;

    }

    @Override
    public LocalitateModel save(final LocalitateModel model) throws VaVedemApiException{
        final Localitate p = LocalitateServUtil.convertToEntity(model);
        final Localitate saved = repository.save(p);

        if(null == saved){
            throw new VaVedemPersistenceException("Fail to save the entity.");
        }
        LocalitateModel result = LocalitateServUtil.convertToModel(saved);
        return result;

    }

    @Override
    public void delete(LocalitateModel model) throws NotSupportedException{
        throw new NotSupportedException("not implemented");
    }

    @Override
    public List<LocalitateModel> findByNume(String nume) throws NotSupportedException {
        throw new NotSupportedException("not implemented");
    }
}


