package ro.vavedem.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ro.vavedem.exceptions.VaVedemApiException;
import ro.vavedem.exceptions.VaVedemNotFoundException;
import ro.vavedem.exceptions.VaVedemPersistenceException;
import ro.vavedem.interfaces.database.Service;
import ro.vavedem.models.PrimarieModel;
import ro.vavedem.persistence.entities.Primarie;
import ro.vavedem.persistence.service.PrimarieService;
import ro.vavedem.services.util.PrimarieServUtil;

import javax.transaction.NotSupportedException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class PrimarieConversionService implements Service<PrimarieModel> {

    private static final Logger logger = Logger.getLogger(PrimarieConversionService.class);

    @Autowired
    private PrimarieService primarieService;

    @Override
    public PrimarieModel findOne(Long id) throws VaVedemApiException {
        final Primarie entity = primarieService.findOne(id);

        if (null == entity) {
            throw new VaVedemNotFoundException("Not found any record with id: " + id);
        }

        return PrimarieServUtil.convertToModel(entity);
    }

    @Override
    public List<PrimarieModel> findAll() throws VaVedemApiException {
        final List<PrimarieModel> models = new ArrayList<>();
        final List<Primarie> entities = primarieService.findAll();

        for (Primarie e : entities) {
            models.add(PrimarieServUtil.convertToModel(e));
        }

        return models;

    }

    @Override
    public PrimarieModel save(final PrimarieModel model) throws VaVedemApiException {
        final Primarie p = PrimarieServUtil.convertToEntity(model);
        final Primarie saved = primarieService.save(p);

        if (null == saved) {
            throw new VaVedemPersistenceException("Fail to save the entity.");
        }

        PrimarieModel result = PrimarieServUtil.convertToModel(saved);

        return result;

    }

    @Override
    public void delete(PrimarieModel model) throws NotSupportedException {
        throw new NotSupportedException("not implemented");
    }

    @Override
    public List<PrimarieModel> findByNume(String nume) throws NotSupportedException {
        throw new NotSupportedException("not implemented");
    }
}


