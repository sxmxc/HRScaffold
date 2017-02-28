/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.hr_scaffold.hr;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Department generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Department`")
public class Department implements Serializable {

    private Integer depid;
    private String name;
    private List<Employees> employeeses = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`DEPID`", nullable = false, scale = 0, precision = 10)
    public Integer getDepid() {
        return this.depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    @Column(name = "`NAME`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "departmentByDepartment")
    public List<Employees> getEmployeeses() {
        return this.employeeses;
    }

    public void setEmployeeses(List<Employees> employeeses) {
        this.employeeses = employeeses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        final Department department = (Department) o;
        return Objects.equals(getDepid(), department.getDepid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepid());
    }
}
