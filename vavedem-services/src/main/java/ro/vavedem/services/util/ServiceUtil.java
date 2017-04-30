package ro.vavedem.services.util;

import org.apache.log4j.Logger;
import ro.vavedem.models.AdresaModel;
import ro.vavedem.models.PrimarieModel;
import ro.vavedem.persistence.entities.Adresa;
import ro.vavedem.persistence.entities.Primarie;

/**
 *
 * @author CoruptiaUcide
 */
public class ServiceUtil {

    private ServiceUtil() {}

    private static final Logger logger = Logger.getLogger(ServiceUtil.class);


    public static Primarie convertToEntity(PrimarieModel model){

        AdresaModel addrModel = model.getAdresa();

        Adresa addrEntity = new Adresa();
        addrEntity.setStrada(addrModel.getStrada());
        addrEntity.setNr(addrModel.getNr());
        addrEntity.setCodPostal(addrModel.getCodPostal());
        addrEntity.setLocalitatea(addrModel.getLocalitatea());

        Primarie p = new Primarie();
        p.setAdresa(addrEntity);
        p.setNume(model.getNume());
        p.setCodFiscal(model.getCodFiscal());
        p.setEmail(model.getEmail());
        p.setTelefon(model.getTelefon());
        p.setPopulatie(model.getPopulatie());

        return p;
    }

    public static PrimarieModel convertToModel(Primarie entity){

        Adresa addrEntity = entity.getAdresa();

        AdresaModel addrModel = new AdresaModel();
        addrModel.setId(addrEntity.getId());
        addrModel.setStrada(addrEntity.getStrada());
        addrModel.setNr(addrEntity.getNr());
        addrModel.setCodPostal(addrEntity.getCodPostal());
        addrModel.setLocalitatea(addrEntity.getLocalitatea());


        PrimarieModel model = new PrimarieModel();
        model.setId(entity.getId());
        model.setAdresa(addrModel);
        model.setNume(entity.getNume());
        model.setCodFiscal(entity.getCodFiscal());
        model.setEmail(entity.getEmail());
        model.setTelefon(entity.getTelefon());
        model.setPopulatie(entity.getPopulatie());

        return model;

    }

}
