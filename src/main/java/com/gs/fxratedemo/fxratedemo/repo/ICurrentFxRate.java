package com.gs.fxratedemo.fxratedemo.repo;

import org.springframework.data.repository.CrudRepository;

import com.gs.fxratedemo.fxratedemo.model.CurrentFxRate;

public interface ICurrentFxRate extends CrudRepository<CurrentFxRate, Long> {

}
