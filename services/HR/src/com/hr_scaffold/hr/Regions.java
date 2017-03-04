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
 * Regions generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Regions`")
public class Regions implements Serializable {

    private Integer regionid;
    private String name;
    private List<Employees> employeeses = new ArrayList<>();
    private List<Users> userses = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`REGIONID`", nullable = false, scale = 0, precision = 10)
    public Integer getRegionid() {
        return this.regionid;
    }

    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

    @Column(name = "`NAME`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "regions")
    public List<Employees> getEmployeeses() {
        return this.employeeses;
    }

    public void setEmployeeses(List<Employees> employeeses) {
        this.employeeses = employeeses;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "regions")
    public List<Users> getUserses() {
        return this.userses;
    }

    public void setUserses(List<Users> userses) {
        this.userses = userses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Regions)) return false;
        final Regions regions = (Regions) o;
        return Objects.equals(getRegionid(), regions.getRegionid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegionid());
    }
}
