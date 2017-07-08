package ro.vavedem.services.util;

import org.apache.log4j.Logger;
import ro.vavedem.exceptions.VaVedemConversionException;
import ro.vavedem.models.LocalitateModel;
import ro.vavedem.models.PrimarieModel;
import ro.vavedem.persistence.entities.Localitate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CoruptiaUcide
 *         <p/>
 *         Converts Localitate entities to its model and vice versa
 */
public final class LocalitateServUtil {

    private LocalitateServUtil() {
    }

    private static final Logger logger = Logger.getLogger(LocalitateServUtil.class);

    public static List<Localitate> convertToEntities(List<LocalitateModel> models) throws VaVedemConversionException {
        List<Localitate> localities = new ArrayList<>();

        for (LocalitateModel model : models) {
            localities.add(convertToEntity(model));
        }

        return localities;
    }

    public static Localitate convertToEntity(LocalitateModel model) throws VaVedemConversionException {
        Localitate locality = new Localitate();

        try {
            locality.setNume(model.getNume());
            locality.setTip(model.getTip());
        } catch (NullPointerException npe) {
            throw new VaVedemConversionException("Null field when convertToEntity.", npe);
        }

        return locality;
    }

    public static List<LocalitateModel> convertToModels(List<Localitate> localitates) throws VaVedemConversionException {
        List<LocalitateModel> models = new ArrayList<>();

        for (Localitate locality : localitates) {
            models.add(convertToModel(locality));
        }

        return models;
    }

    public static LocalitateModel convertToModel(Localitate entity) throws VaVedemConversionException {
        LocalitateModel model = new LocalitateModel();

        try {
            model.setId(entity.getId());
            model.setNume(entity.getNume());
            model.setTip(entity.getTip());

            // at least the id
            PrimarieModel unitateAdministrativa = new PrimarieModel();
            unitateAdministrativa.setId(entity.getUnitateAdministrativa().getId());
            model.setUnitateAdministrativa(unitateAdministrativa);

        } catch (NullPointerException npe) {
            throw new VaVedemConversionException("Null field when convertToModel.", npe);
        }

        return model;
    }
}
