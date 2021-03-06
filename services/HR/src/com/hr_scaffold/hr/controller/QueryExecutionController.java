/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.hr_scaffold.hr.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.hr_scaffold.hr.service.HRQueryExecutorService;
import com.hr_scaffold.hr.models.query.*;

@RestController(value = "HR.QueryExecutionController")
@RequestMapping("/HR/queryExecutor")
@Api(value = "QueryExecutionController", description = "controller class for query execution")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private HRQueryExecutorService queryService;

    @RequestMapping(value = "/queries/countInRegion", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Counts in employees in logged in users region")
    public Page<CountInRegionResponse> executeCountInRegion(@RequestParam(value = "region") Integer region, Pageable pageable) {
        LOGGER.debug("Executing named query: countInRegion");
        Page<CountInRegionResponse> _result = queryService.executeCountInRegion(region, pageable);
        LOGGER.debug("got the result for named query: countInRegion, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query countInRegion")
    @RequestMapping(value = "/queries/countInRegion/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCountInRegion(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "region") Integer region, Pageable pageable) {
        LOGGER.debug("Exporting named query: countInRegion");

        return queryService.exportCountInRegion(exportType, region, pageable);
    }

    @RequestMapping(value = "/queries/EmployeesByDepartment", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns Employees given specific department")
    public Page<EmployeesByDepartmentResponse> executeEmployeesByDepartment(@RequestParam(value = "deptid") String deptid, Pageable pageable) {
        LOGGER.debug("Executing named query: EmployeesByDepartment");
        Page<EmployeesByDepartmentResponse> _result = queryService.executeEmployeesByDepartment(deptid, pageable);
        LOGGER.debug("got the result for named query: EmployeesByDepartment, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query EmployeesByDepartment")
    @RequestMapping(value = "/queries/EmployeesByDepartment/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportEmployeesByDepartment(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "deptid") String deptid, Pageable pageable) {
        LOGGER.debug("Exporting named query: EmployeesByDepartment");

        return queryService.exportEmployeesByDepartment(exportType, deptid, pageable);
    }

    @RequestMapping(value = "/queries/getRegion", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Get users region vie username")
    public GetRegionResponse executeGetRegion(@RequestParam(value = "username") String username) {
        LOGGER.debug("Executing named query: getRegion");
        GetRegionResponse _result = queryService.executeGetRegion(username);
        LOGGER.debug("got the result for named query: getRegion, result:{}", _result);
        return _result;
    }

    @RequestMapping(value = "/queries/EmployeesByRegion", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns all employees by tenantID")
    public Page<EmployeesByRegionResponse> executeEmployeesByRegion(@RequestParam(value = "regionid") Integer regionid, Pageable pageable) {
        LOGGER.debug("Executing named query: EmployeesByRegion");
        Page<EmployeesByRegionResponse> _result = queryService.executeEmployeesByRegion(regionid, pageable);
        LOGGER.debug("got the result for named query: EmployeesByRegion, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query EmployeesByRegion")
    @RequestMapping(value = "/queries/EmployeesByRegion/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportEmployeesByRegion(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "regionid") Integer regionid, Pageable pageable) {
        LOGGER.debug("Exporting named query: EmployeesByRegion");

        return queryService.exportEmployeesByRegion(exportType, regionid, pageable);
    }

    @RequestMapping(value = "/queries/getEmployeesByStatus", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "returns employees with given status")
    public Page<GetEmployeesByStatusResponse> executeGetEmployeesByStatus(@RequestParam(value = "status") String status, Pageable pageable) {
        LOGGER.debug("Executing named query: getEmployeesByStatus");
        Page<GetEmployeesByStatusResponse> _result = queryService.executeGetEmployeesByStatus(status, pageable);
        LOGGER.debug("got the result for named query: getEmployeesByStatus, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query getEmployeesByStatus")
    @RequestMapping(value = "/queries/getEmployeesByStatus/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportGetEmployeesByStatus(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "status") String status, Pageable pageable) {
        LOGGER.debug("Exporting named query: getEmployeesByStatus");

        return queryService.exportGetEmployeesByStatus(exportType, status, pageable);
    }

}


