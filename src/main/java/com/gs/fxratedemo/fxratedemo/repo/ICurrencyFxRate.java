package com.gs.fxratedemo.fxratedemo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gs.fxratedemo.fxratedemo.model.CurrencyFxRate;

@RepositoryRestResource(collectionResourceRel = "fxRate", path = "fxRate")
public interface ICurrencyFxRate extends CrudRepository<CurrencyFxRate, Long> {
	 List<CurrencyFxRate> findByBusinessDtLessThan(java.sql.Date sqlDate);

}
