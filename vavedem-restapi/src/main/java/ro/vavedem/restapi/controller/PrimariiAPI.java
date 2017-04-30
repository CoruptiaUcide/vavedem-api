package ro.vavedem.restapi.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.vavedem.models.AdresaModel;
import ro.vavedem.models.PrimarieModel;
import ro.vavedem.persistence.entities.Adresa;
import ro.vavedem.persistence.entities.Primarie;
import ro.vavedem.interfaces.Service;

import java.util.List;

@Controller
public class PrimariiAPI {

    private static final Logger logger = Logger.getLogger(PrimariiAPI.class);

    @Autowired
    private Service<PrimarieModel> primarieService;


    @ApiOperation(value = "Intoarce lista cu toate primariile.", tags = {"primarie"})
    @RequestMapping(value = {"/primarii"}, method = {RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<List<PrimarieModel>> getPrimarii() {
        logger.info("get lista primarii");
        List<PrimarieModel> primaries = primarieService.findAll();

        return new ResponseEntity<List<PrimarieModel>>(primaries, HttpStatus.OK);
    }

    @ApiOperation(value = "Creaza o noua intrare in baza de date.", tags = {"primarie"})
    @RequestMapping(value = {"/primarii"}, method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PrimarieModel> createPrimarie(@RequestBody PrimarieModel model) {
        logger.info("post primarie: JSON: " + model.toString());
        PrimarieModel saved = primarieService.save(model);

        return new ResponseEntity<PrimarieModel>(saved, HttpStatus.OK);
    }

    @ApiOperation(value = "Intoarce detaliile primarii cu id-ul dat.", tags = {"primarie"})
    @RequestMapping(value = {"/primarii/{id}"}, method = {RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<PrimarieModel> getDetaliiPrimarie(@PathVariable("id") Long id) {
        logger.info("get detalii primarie: " + id);
        PrimarieModel model = primarieService.findOne(id);

        return new ResponseEntity<PrimarieModel>(model, HttpStatus.OK);
    }
}
