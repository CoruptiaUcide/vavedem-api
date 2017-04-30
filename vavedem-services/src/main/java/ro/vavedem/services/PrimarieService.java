package ro.vavedem.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ro.vavedem.interfaces.Service;
import ro.vavedem.models.PrimarieModel;
import ro.vavedem.persistence.entities.Primarie;
import ro.vavedem.persistence.repository.PrimarieRepository;
import ro.vavedem.services.util.ServiceUtil;

import javax.transaction.NotSupportedException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class PrimarieService implements Service<PrimarieModel> {

    private static final Logger logger = Logger.getLogger(PrimarieService.class);

    @Autowired
    private PrimarieRepository repository;

    @Override
    public PrimarieModel findOne(Long id) {
        Primarie entity = repository.findOne(id);
        return ServiceUtil.convertToModel(entity);
    }

    @Override
    public List<PrimarieModel> findAll() {
        List<PrimarieModel> models = new ArrayList<PrimarieModel>();
        List<Primarie> entities = repository.findAll();

        for(Primarie e : entities){
            models.add(ServiceUtil.convertToModel(e));
        }
        return models;

    }

    @Override
    public PrimarieModel save(PrimarieModel model) {
        Primarie p = ServiceUtil.convertToEntity(model);
        return ServiceUtil.convertToModel(repository.save(p));
    }

    @Override
    public void delete(PrimarieModel model) throws NotSupportedException{
        throw new NotSupportedException("not implemented");
    }

    @Override
    public List<PrimarieModel> findByNume(String nume) throws NotSupportedException {
        throw new NotSupportedException("not implemented");
    }
}


