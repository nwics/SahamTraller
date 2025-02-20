package com.example.sahamProject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sahamProject.dto.DashboardResponseDTO;
import com.example.sahamProject.model.MBiodata;
import com.example.sahamProject.model.MCompany;
import com.example.sahamProject.model.MStockNews;
import com.example.sahamProject.model.MUser;
import com.example.sahamProject.model.TStockPrices;
import com.example.sahamProject.service.DashboardService;
import com.example.sahamProject.service.StockNewsService;
import com.example.sahamProject.service.UserService;

@RestController
@RequestMapping("/api/dashboard")
public class ApiDashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private UserService userService;

    @Autowired
    private StockNewsService stockNewsService;

    @GetMapping("/all")
    public ResponseEntity<DashboardResponseDTO> getAllData() {
        List<MCompany> companies = dashboardService.getAllCompany();
        List<TStockPrices> storkcPrices = dashboardService.getAllStockPrices();
        List<MBiodata> users = userService.getUsers();
        List<MStockNews> news = stockNewsService.getAllNews();

        if (companies.isEmpty() && storkcPrices.isEmpty() && users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DashboardResponseDTO responseDTO = new DashboardResponseDTO(companies, storkcPrices, users, news);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> getById(@PathVariable("id") Long id) {
    // try {
    // MCompany mCompany = this.dashboardService.getById(id);
    // return new ResponseEntity<>(mCompany, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    // }
    // }

}
