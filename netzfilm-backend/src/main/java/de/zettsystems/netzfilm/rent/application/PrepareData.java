package de.zettsystems.netzfilm.rent.application;

import de.zettsystems.netzfilm.customer.domain.LoadCustomerData;
import de.zettsystems.netzfilm.movie.domain.CopyRepository;
import de.zettsystems.netzfilm.movie.domain.LoadCopyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Service
public class PrepareData {
    private static final Logger LOG = LoggerFactory.getLogger(PrepareData.class);
    private final LoadCopyData loadCopyData;
    private final LoadCustomerData loadCustomerData;
    private final RentService rentService;
    private final CopyRepository copyRepository;

    public PrepareData(LoadCopyData loadCopyData, LoadCustomerData loadCustomerData, RentService rentService, CopyRepository copyRepository) {
        this.loadCopyData = loadCopyData;
        this.loadCustomerData = loadCustomerData;
        this.rentService = rentService;
        this.copyRepository = copyRepository;
    }

    @PostConstruct
    @Transactional(readOnly = true)
    public void createCopies() {
        LOG.info("Preparing data...");
        loadCustomerData.createCustomer();
        loadCopyData.createCopies();
        copyRepository.findAllByLentFalse().forEach(
                c -> rentService.rentAMovie(1L, c.getId(), LocalDate.now(), 5L)
        );

        LOG.info("...finished.");
    }

}
