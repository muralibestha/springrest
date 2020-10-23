package com.gs.fxratedemo.fxratedemo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs.fxratedemo.fxratedemo.model.CurrencyFxRate;
import com.gs.fxratedemo.fxratedemo.model.CurrentFxRate;
import com.gs.fxratedemo.fxratedemo.repo.ICurrencyFxRate;
import com.gs.fxratedemo.fxratedemo.repo.ICurrentFxRate;

@RestController
public class RefinerController {
	
	@Autowired
	ICurrencyFxRate currencyFxRepo;
	
	@Autowired
	ICurrentFxRate currentFxRepo;
	
	@RequestMapping("/refine/fxRate")
	public List<CurrentFxRate> refine() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(new Date());
		List<CurrentFxRate> currentFxRates = new ArrayList<>();
		for (CurrencyFxRate currencyFxRate : currencyFxRepo.findAll()) {
			CurrentFxRate currentFxRate = new CurrentFxRate();
			if((sdf.format(currencyFxRate.getBusinessDt()).compareTo(sdf.format(new Date())))==0) {
				currentFxRate.setActiveInd("A");
				
			}else {
				currentFxRate.setActiveInd("I");
			}
			currentFxRate.setLakeOutId(currencyFxRate.getLakeOutId());
			currentFxRate.setBaseCurrencyCd(currencyFxRate.getBaseCurrencyCd());
			currentFxRate.setTargetCurrencyCd(currencyFxRate.getTargetCurrencyCd());
			currentFxRate.setExchangeRate(currencyFxRate.getExchangeRate());
			currentFxRate.setBusinessDt(currencyFxRate.getBusinessDt());
			currentFxRate.setBankId("GS");
			currentFxRates.add(currentFxRate);
			
		}
		
		currentFxRepo.saveAll(currentFxRates);
		Iterable<CurrentFxRate> iterable = currentFxRepo.findAll();
		List<CurrentFxRate> result = 
				  StreamSupport.stream(iterable.spliterator(), false)
				    .collect(Collectors.toList());
		return result;
		
	}

}
