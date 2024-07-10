package com.progresssoft.clustered_data_warehouse.service;

import com.progresssoft.clustered_data_warehouse.model.Deal;
import com.progresssoft.clustered_data_warehouse.repository.DealRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DealServiceTest {

    @Mock
    private DealRepository dealRepository;

    @InjectMocks
    private DealService dealService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void importDeal_ValidDeal_Success() throws Exception {
        Deal deal = new Deal();
        deal.setDealUniqueId("12345");
        deal.setFromCurrency("JOD");
        deal.setToCurrency("USD");
        deal.setDealTimestamp(LocalDateTime.now());
        deal.setDealAmount(new BigDecimal("1000.00"));

        when(dealRepository.existsById(deal.getDealUniqueId())).thenReturn(false);

        dealService.importDeal(deal);

        verify(dealRepository).save(deal);
    }

    @Test
    void importDeal_DealAlreadyExists_ThrowsException() {
        Deal deal = new Deal();
        deal.setDealUniqueId("12345");
        deal.setFromCurrency("JOD");
        deal.setToCurrency("USD");
        deal.setDealTimestamp(LocalDateTime.now());
        deal.setDealAmount(new BigDecimal("1000.00"));

        when(dealRepository.existsById(deal.getDealUniqueId())).thenReturn(true);

        Exception exception = assertThrows(Exception.class, () -> {
            dealService.importDeal(deal);
        });

        String expectedMessage = "Duplicate deal id";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
