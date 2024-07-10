package com.progresssoft.clustered_data_warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.progresssoft.clustered_data_warehouse.model.Deal;
import com.progresssoft.clustered_data_warehouse.repository.DealRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class DealService {

    private static final Logger LOGGER = Logger.getLogger(DealService.class.getName());

    @Autowired
    private DealRepository dealRepository;

    public void importDeal(Deal deal) throws Exception {
        validateDeal(deal);
        if (dealRepository.existsById(deal.getDealUniqueId())) {
            LOGGER.log(Level.WARNING, "Duplicate deal id: " + deal.getDealUniqueId());
            throw new Exception("Duplicate deal id");
        }
        dealRepository.save(deal);
        LOGGER.log(Level.INFO, "Deal saved: " + deal.getDealUniqueId());
    }

    private void validateDeal(Deal deal) throws Exception {
        if (deal.getDealUniqueId() == null || deal.getFromCurrency() == null ||
                deal.getToCurrency() == null || deal.getDealTimestamp() == null ||
                deal.getDealAmount() == null) {
            LOGGER.log(Level.SEVERE, "Invalid deal data: " + deal);
            throw new Exception("Invalid deal data");
        }
        LOGGER.log(Level.INFO, "Deal validated: " + deal.getDealUniqueId());
    }
}
