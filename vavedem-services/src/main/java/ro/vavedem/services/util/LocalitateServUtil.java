package ro.vavedem.services.util;

import org.apache.log4j.Logger;
import ro.vavedem.exceptions.VaVedemConversionException;
import ro.vavedem.models.LocalitateModel;
import ro.vavedem.persistence.entities.Localitate;

/**
 *
 * @author CoruptiaUcide
 */
public final class LocalitateServUtil {

    private LocalitateServUtil() {}

    private static final Logger logger = Logger.getLogger(LocalitateServUtil.class);


    public static Localitate convertToEntity(LocalitateModel model) throws VaVedemConversionException {

        Localitate p = new Localitate();

        try {
            p.setNume(model.getNume());
            p.setTip(model.getTip());
        }catch (NullPointerException npe){
            throw new VaVedemConversionException("Null field when convertToEntity.", npe);
        }
        return p;
    }

    public static LocalitateModel convertToModel(Localitate entity) throws VaVedemConversionException{

        LocalitateModel model = new LocalitateModel();

        try {
            model.setId(entity.getId());
            model.setNume(entity.getNume());
            model.setTip(entity.getTip());

        }catch (NullPointerException npe){
            throw new VaVedemConversionException("Null field when convertToModel.", npe);
        }

        return model;

    }

}
