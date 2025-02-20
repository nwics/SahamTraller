package com.example.sahamProject.dto;

import java.util.List;

import com.example.sahamProject.model.MBiodata;
import com.example.sahamProject.model.MCompany;
import com.example.sahamProject.model.MStockNews;
import com.example.sahamProject.model.MUser;
import com.example.sahamProject.model.TStockPrices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponseDTO {
    private List<MCompany> companies;
    private List<TStockPrices> stockPrices;
    private List<MBiodata> users;
    private List<MStockNews> news;

}
