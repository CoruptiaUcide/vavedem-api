package ro.vavedem.restapi;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.vavedem.interfaces.PrimarieService;

@CrossOrigin(origins = {"http://localhost:8080"})
@Controller
@RequestMapping({"/primarii"})
public class PrimariiAPI {

    private static final Logger logger = Logger.getLogger(PrimariiAPI.class);
    @Autowired
    private PrimarieService primarieService;

    @RequestMapping(value = {"/adrese"}, method = {RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<List<String>> getAdresePrimarii() {

        logger.info("get adrese primarie  test");

        List<String> l = new ArrayList();
        l.add("contact@primaria-alba.ro");
        l.add("contact@primaria-sibiu.ro");
        l.add("contact@primaria-neamt.ro");
        return new ResponseEntity(l, HttpStatus.OK);
    }

    @RequestMapping(value = {"/{cod}"}, method = {RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<String> getDetaliiPrimarie(@PathVariable("cod") String cod) {
        logger.info(" detalii primarie  " + cod);

        return new ResponseEntity("{bt: \"botosani\"}", HttpStatus.OK);
    }
}
