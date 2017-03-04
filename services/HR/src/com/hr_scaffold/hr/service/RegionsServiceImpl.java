/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.hr_scaffold.hr.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.hr_scaffold.hr.Employees;
import com.hr_scaffold.hr.Regions;
import com.hr_scaffold.hr.Users;


/**
 * ServiceImpl object for domain model class Regions.
 *
 * @see Regions
 */
@Service("HR.RegionsService")
public class RegionsServiceImpl implements RegionsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegionsServiceImpl.class);

    @Autowired
	@Qualifier("HR.EmployeesService")
	private EmployeesService employeesService;

    @Autowired
	@Qualifier("HR.UsersService")
	private UsersService usersService;

    @Autowired
    @Qualifier("HR.RegionsDao")
    private WMGenericDao<Regions, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Regions, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "HRTransactionManager")
    @Override
	public Regions create(Regions regions) {
        LOGGER.debug("Creating a new Regions with information: {}", regions);
        Regions regionsCreated = this.wmGenericDao.create(regions);
        if(regionsCreated.getEmployeeses() != null) {
            for(Employees employeese : regionsCreated.getEmployeeses()) {
                employeese.setRegions(regionsCreated);
                LOGGER.debug("Creating a new child Employees with information: {}", employeese);
                employeesService.create(employeese);
            }
        }

        if(regionsCreated.getUserses() != null) {
            for(Users userse : regionsCreated.getUserses()) {
                userse.setRegions(regionsCreated);
                LOGGER.debug("Creating a new child Users with information: {}", userse);
                usersService.create(userse);
            }
        }
        return regionsCreated;
    }

	@Transactional(readOnly = true, value = "HRTransactionManager")
	@Override
	public Regions getById(Integer regionsId) throws EntityNotFoundException {
        LOGGER.debug("Finding Regions by id: {}", regionsId);
        Regions regions = this.wmGenericDao.findById(regionsId);
        if (regions == null){
            LOGGER.debug("No Regions found with id: {}", regionsId);
            throw new EntityNotFoundException(String.valueOf(regionsId));
        }
        return regions;
    }

    @Transactional(readOnly = true, value = "HRTransactionManager")
	@Override
	public Regions findById(Integer regionsId) {
        LOGGER.debug("Finding Regions by id: {}", regionsId);
        return this.wmGenericDao.findById(regionsId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "HRTransactionManager")
	@Override
	public Regions update(Regions regions) throws EntityNotFoundException {
        LOGGER.debug("Updating Regions with information: {}", regions);
        this.wmGenericDao.update(regions);

        Integer regionsId = regions.getRegionid();

        return this.wmGenericDao.findById(regionsId);
    }

    @Transactional(value = "HRTransactionManager")
	@Override
	public Regions delete(Integer regionsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Regions with id: {}", regionsId);
        Regions deleted = this.wmGenericDao.findById(regionsId);
        if (deleted == null) {
            LOGGER.debug("No Regions found with id: {}", regionsId);
            throw new EntityNotFoundException(String.valueOf(regionsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "HRTransactionManager")
	@Override
	public Page<Regions> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Regions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "HRTransactionManager")
    @Override
    public Page<Regions> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Regions");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "HRTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service HR for table Regions to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "HRTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "HRTransactionManager")
    @Override
    public Page<Employees> findAssociatedEmployeeses(Integer regionid, Pageable pageable) {
        LOGGER.debug("Fetching all associated employeeses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("regions.regionid = '" + regionid + "'");

        return employeesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "HRTransactionManager")
    @Override
    public Page<Users> findAssociatedUserses(Integer regionid, Pageable pageable) {
        LOGGER.debug("Fetching all associated userses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("regions.regionid = '" + regionid + "'");

        return usersService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeesService instance
	 */
	protected void setEmployeesService(EmployeesService service) {
        this.employeesService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UsersService instance
	 */
	protected void setUsersService(UsersService service) {
        this.usersService = service;
    }

}

