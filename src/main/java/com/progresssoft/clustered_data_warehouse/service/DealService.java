package com.progresssoft.clustered_data_warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.progresssoft.clustered_data_warehouse.model.Deal;
import com.progresssoft.clustered_data_warehouse.repository.DealRepository;

@Service
public class DealService {

    @Autowired
    private DealRepository dealRepository;

    public void importDeal(Deal deal) throws Exception {
        validateDeal(deal);
        if (dealRepository.existsById(deal.getDealUniqueId())) {
            throw new Exception("Duplicate deal id");
        }
        dealRepository.save(deal);
    }

    private void validateDeal(Deal deal) throws Exception {
        if (deal.getDealUniqueId() == null || deal.getFromCurrency() == null ||
                deal.getToCurrency() == null || deal.getDealTimestamp() == null ||
                deal.getDealAmount() == null) {
            throw new Exception("Invalid deal data");
        }
    }
}
