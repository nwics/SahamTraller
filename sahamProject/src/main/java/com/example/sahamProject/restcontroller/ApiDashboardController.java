package com.example.sahamProject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sahamProject.dto.DashboardResponseDTO;
import com.example.sahamProject.model.MCompany;
import com.example.sahamProject.model.TStockPrices;
import com.example.sahamProject.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class ApiDashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/all")
    public ResponseEntity<DashboardResponseDTO> getAllData() {
        List<MCompany> companies = dashboardService.getAllCompany();
        List<TStockPrices> storkcPrices = dashboardService.getAllStockPrices();

        if (companies.isEmpty() && storkcPrices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DashboardResponseDTO responseDTO = new DashboardResponseDTO(companies, storkcPrices);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
