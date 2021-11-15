package com.coredge.hospitalmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hosptal_info")
public class HospitalInfo {

	@Id
	@Column(name = "hospital_id")
	private String hospitalId;

	@Column(name = "hospital_name")
	private String hospitalName;

	@Column(name = "state_code")
	private Integer stateCode;

	@Column(name = "state")
	private String state;

	@Column(name = "district_id")
	private Integer districtId;

	@Column(name = "district")
	private String district;

	@Column(name = "hospital_contact_number")
	private String hospitalContactNumber;

	@Column(name = "hospital_address")
	private String hospitalAddress;

	@Column(name = "hospital_type")
	private EHospitalType hospitalType;

	public String getHospitalId() {
		return hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getHospitalContactNumber() {
		return hospitalContactNumber;
	}

	public void setHospitalContactNumber(String hospitalContactNumber) {
		this.hospitalContactNumber = hospitalContactNumber;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public EHospitalType getHospitalType() {
		return hospitalType;
	}

	public void setHospitalType(EHospitalType hospitalType) {
		this.hospitalType = hospitalType;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
}
