package ro.vavedem.restapi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.vavedem.models.AdresaModel;
import ro.vavedem.models.PrimarieModel;
import ro.vavedem.persistence.entities.Adresa;
import ro.vavedem.persistence.entities.Primarie;
import ro.vavedem.persistence.service.AdresaService;

import java.util.List;

@Controller
public class PrimariiAPI {

    private static final Logger logger = Logger.getLogger(PrimariiAPI.class);

//    @Autowired
//    private PrimarieService primarieService;

    @Autowired
    private AdresaService adresaService;

    // todo to be moved to services
    @Autowired
    private ro.vavedem.persistence.service.PrimarieV2Service primarieService;

    @RequestMapping(value = {"/adrese"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Adresa>> getAPrimarii() {
        List<Adresa> addresses = adresaService.findAll();

        logger.info("get adrese primarie test");
        // todo - to be converted to out model AdresaModel

        return new ResponseEntity<List<Adresa>>(addresses, HttpStatus.OK);
    }

    @RequestMapping(value = {"/primarii"}, method = {RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<List<Primarie>> getAdresePrimarii() {

        logger.info("get primarii test");

//        PrimarieModel p1 = new PrimarieModel();
//        p1.setAdresa(new AdresaModel());
//        p1.setCodFiscal(123L);
//        p1.setEmail("contact@primaria-alba.ro");
//        p1.setNume("Primaria X");
//        p1.setTelefon("254855244");
//        p1.setPopulatie(300000L);
//
//
//        List<PrimarieModel> l = new ArrayList();
//        l.add(p1);
//        l.add(p1);
//        l.add(p1);

        List<Primarie> primaries = primarieService.findAll();

        return new ResponseEntity<List<Primarie>>(primaries, HttpStatus.OK);
    }

    @RequestMapping(value = {"/primarii/{cod}"}, method = {RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<PrimarieModel> getDetaliiPrimarie(@PathVariable("cod") String cod) {
        logger.info(" detalii primarie  " + cod);

        PrimarieModel p1 = new PrimarieModel();
        p1.setAdresa(new AdresaModel());
        p1.setCodFiscal(123L);
        p1.setEmail("contact@primaria-alba.ro");
        p1.setNume("Primaria X");
        p1.setTelefon("254855244");
        p1.setPopulatie(300000L);

        return new ResponseEntity<PrimarieModel>(p1, HttpStatus.OK);
    }
}
