package ro.vavedem.restapi.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.vavedem.exceptions.VaVedemApiException;
import ro.vavedem.exceptions.VaVedemConversionException;
import ro.vavedem.exceptions.VaVedemNotFoundException;
import ro.vavedem.interfaces.Service;
import ro.vavedem.models.LocalitateModel;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LocalitatiAPI {

    private static final Logger logger = Logger.getLogger(LocalitatiAPI.class);
    public static final String EROARE_INTERNA_INCERCATI_MAI_TARZIU = "Eroare interna! Incercati mai tarziu.";
    public static final String ASIGURATIVA_CA_DATELE_INTRODUSE_SUNT_CORECTE = "Asigurativa ca datele introduse sunt corecte.";

    @Autowired
    private Service<LocalitateModel> localitateService;


    @ApiOperation(value = "Intoarce lista cu toate localitatiile.", tags = {"localitate"})
    @RequestMapping(value = {"/localitati"}, method = {RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<List<LocalitateModel>> getLocalitati() {
        logger.info("get lista localitati");
        List<LocalitateModel> localitati = null;
        try {
            localitati = localitateService.findAll();
        } catch (VaVedemApiException e) {
            if(e instanceof VaVedemConversionException){
                logger.info(e.getMessage());
                return new ResponseEntity(ASIGURATIVA_CA_DATELE_INTRODUSE_SUNT_CORECTE, HttpStatus.BAD_REQUEST);
            }else if(e instanceof VaVedemApiException){
                logger.info(e.getMessage());
                return new ResponseEntity(EROARE_INTERNA_INCERCATI_MAI_TARZIU, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<LocalitateModel>>(localitati, HttpStatus.OK);
    }

    @ApiOperation(value = "Creaza o noua intrare in baza de date.", tags = {"localitate"})
    @RequestMapping(value = {"/localitati"}, method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<LocalitateModel> createLocalitate(@RequestBody @Valid LocalitateModel model) {
        logger.info("post localitate: JSON: " + model.toString());
        LocalitateModel saved = null;
        try {
            saved = localitateService.save(model);
        } catch (VaVedemApiException e) {
            if(e instanceof VaVedemConversionException){
                logger.info(e.getMessage());
                return new ResponseEntity(ASIGURATIVA_CA_DATELE_INTRODUSE_SUNT_CORECTE, HttpStatus.BAD_REQUEST);
            }else if(e instanceof VaVedemApiException){
                logger.info(e.getMessage());
                return new ResponseEntity(EROARE_INTERNA_INCERCATI_MAI_TARZIU, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<LocalitateModel>(saved, HttpStatus.OK);
    }

    @ApiOperation(value = "Intoarce detaliile localitatii cu id-ul dat.", tags = {"localitate"})
    @RequestMapping(value = {"/localitati/{id}"}, method = {RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<LocalitateModel> getDetaliiLocalitate(@PathVariable("id") Long id) {
        logger.info("get detalii localitate: " + id);

        LocalitateModel model = null;
        try {
            model = localitateService.findOne(id);
        } catch (VaVedemApiException e) {
            if(e instanceof VaVedemNotFoundException){
                logger.info(e.getMessage());
                return new ResponseEntity(ASIGURATIVA_CA_DATELE_INTRODUSE_SUNT_CORECTE, HttpStatus.BAD_REQUEST);
            }else if(e instanceof VaVedemConversionException){
                logger.info(e.getMessage());
                return new ResponseEntity(ASIGURATIVA_CA_DATELE_INTRODUSE_SUNT_CORECTE, HttpStatus.BAD_REQUEST);
            }else if(e instanceof VaVedemApiException){
                logger.info(e.getMessage());
                return new ResponseEntity(EROARE_INTERNA_INCERCATI_MAI_TARZIU, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<LocalitateModel>(model, HttpStatus.OK);
    }
}
