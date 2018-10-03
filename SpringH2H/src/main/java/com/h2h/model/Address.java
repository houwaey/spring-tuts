package com.h2h.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "barangay")
	private String barangay;
	
	@Column(name = "towncity")
	private String towncity;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "country")
	private String country;

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getTowncity() {
		return towncity;
	}

	public void setTowncity(String towncity) {
		this.towncity = towncity;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [barangay=" + barangay + ", towncity=" + towncity + ", province=" + province + ", region="
				+ region + ", country=" + country + "]";
	}

}
