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
import ro.vavedem.persistence.entities.Role;
import ro.vavedem.persistence.entities.UserAccount;
import ro.vavedem.persistence.repository.RoleRepository;
import ro.vavedem.persistence.repository.UserRepository;
import ro.vavedem.persistence.service.AdresaService;

import java.security.Principal;
import java.util.List;

@Controller
public class PrimariiAPI {

    private static final Logger logger = Logger.getLogger(PrimariiAPI.class);

    @Autowired
    private AdresaService adresaService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // todo to be moved to services
    @Autowired
    private ro.vavedem.persistence.service.PrimarieV2Service primarieService;

    @RequestMapping(value = {"/adrese"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Adresa>> getAPrimarii(Principal principal) {
        List<Adresa> addresses = adresaService.findAll();

        logger.info("get adrese primarie test. User name:" + principal.getName());
        // todo - to be converted to out model AdresaModel

        return new ResponseEntity<List<Adresa>>(addresses, HttpStatus.OK);
    }

    @RequestMapping(value = {"/primarii"}, method = {RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<List<Primarie>> getAdresePrimarii() {

        logger.info("get primarii test");

        List<Primarie> primaries = primarieService.findAll();

        List<UserAccount> users = userRepository.findAll();
        List<Role> roles = roleRepository.findAll();

        UserAccount uu = userRepository.findByUsername("vavedem");

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
