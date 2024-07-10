package com.progresssoft.clustered_data_warehouse.controller;

import com.progresssoft.clustered_data_warehouse.model.Deal;
import com.progresssoft.clustered_data_warehouse.repository.DealRepository;
import com.progresssoft.clustered_data_warehouse.service.DealValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deals")
public class DealController {

    @Autowired
    private DealValidationService dealValidationService;

    @Autowired
    private DealRepository dealRepository;

    @PostMapping
    public ResponseEntity<?> importDeal(@RequestBody Deal deal) {
        try {
            dealValidationService.validateDeal(deal);
            dealRepository.save(deal);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok("Deal imported successfully");
    }
}
