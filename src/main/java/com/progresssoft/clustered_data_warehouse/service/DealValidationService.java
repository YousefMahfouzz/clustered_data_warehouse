package com.progresssoft.clustered_data_warehouse.service;

import com.progresssoft.clustered_data_warehouse.model.Deal;
import com.progresssoft.clustered_data_warehouse.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealValidationService {

    @Autowired
    private DealRepository dealRepository;

    public void validateDeal(Deal deal) {
        if (deal.getDealUniqueId() == null || deal.getDealUniqueId().isEmpty()) {
            throw new IllegalArgumentException("Deal Unique ID is missing");
        }
        if (deal.getFromCurrency() == null || deal.getFromCurrency().isEmpty()) {
            throw new IllegalArgumentException("From Currency is missing");
        }
        if (deal.getToCurrency() == null || deal.getToCurrency().isEmpty()) {
            throw new IllegalArgumentException("To Currency is missing");
        }
        if (deal.getDealTimestamp() == null) {
            throw new IllegalArgumentException("Deal Timestamp is missing");
        }
        if (deal.getDealAmount() == null) {
            throw new IllegalArgumentException("Deal Amount is missing");
        }
        if (dealRepository.existsByDealUniqueId(deal.getDealUniqueId())) {
            throw new IllegalArgumentException("Deal with the same unique ID already exists");
        }
    }
}
