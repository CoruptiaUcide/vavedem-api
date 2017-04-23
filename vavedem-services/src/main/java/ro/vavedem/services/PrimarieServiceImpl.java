package ro.vavedem.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.vavedem.interfaces.IRepository;
import ro.vavedem.interfaces.PrimarieService;

@Component
public class PrimarieServiceImpl
        extends AbstractService
        implements PrimarieService {

    private static final Logger logger = Logger.getLogger(PrimarieServiceImpl.class);
    @Autowired
    IRepository primarieRepository;
}
