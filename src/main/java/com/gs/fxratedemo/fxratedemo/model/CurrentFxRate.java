package com.gs.fxratedemo.fxratedemo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrentFxRate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long lakeOutId;
	private String baseCurrencyCd;
	private String targetCurrencyCd;
	private Double exchangeRate;
	private Date businessDt;
	private String activeInd;
	private String bankId;
	
	
	public CurrentFxRate() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLakeOutId() {
		return lakeOutId;
	}
	public void setLakeOutId(Long lakeOutId) {
		this.lakeOutId = lakeOutId;
	}
	public String getBaseCurrencyCd() {
		return baseCurrencyCd;
	}
	public void setBaseCurrencyCd(String baseCurrencyCd) {
		this.baseCurrencyCd = baseCurrencyCd;
	}
	public String getTargetCurrencyCd() {
		return targetCurrencyCd;
	}
	public void setTargetCurrencyCd(String targetCurrencyCd) {
		this.targetCurrencyCd = targetCurrencyCd;
	}
	public Double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public Date getBusinessDt() {
		return businessDt;
	}
	public void setBusinessDt(Date businessDt) {
		this.businessDt = businessDt;
	}
	public String getActiveInd() {
		return activeInd;
	}
	public void setActiveInd(String activeInd) {
		this.activeInd = activeInd;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	
	

}
