package com.coredge.hospitalmanagement.utils.dto;

import com.coredge.hospitalmanagement.entity.EHospitalType;

public class HospitalInfoDTO {

	private String hospid;

	private String hospname;

	private String statecode;

	private String state;

	private String districtid;

	private String district;

	private String hospcontactno;

	private String hospaddress;

	private EHospitalType hosptype;
	
	private String link;

	public String getHospid() {
		return hospid;
	}

	public void setHospid(String hospid) {
		this.hospid = hospid;
	}

	public String getHospname() {
		return hospname;
	}

	public void setHospname(String hospname) {
		this.hospname = hospname;
	}

	public String getStatecode() {
		return statecode;
	}

	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrictid() {
		return districtid;
	}

	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getHospcontactno() {
		return hospcontactno;
	}

	public void setHospcontactno(String hospcontactno) {
		this.hospcontactno = hospcontactno;
	}

	public String getHospaddress() {
		return hospaddress;
	}

	public void setHospaddress(String hospaddress) {
		this.hospaddress = hospaddress;
	}

	public EHospitalType getHosptype() {
		return hosptype;
	}

	public void setHosptype(EHospitalType hosptype) {
		this.hosptype = hosptype;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
