package com.coredge.hospitalmanagement.dao;

import java.util.List;

import com.coredge.hospitalmanagement.entity.EHospitalType;
import com.coredge.hospitalmanagement.utils.dto.HospitalInfoDTO;

public interface HosptalManagementBo {

	void saveHospitalInfo(List<HospitalInfoDTO> hospitalInfoList);

	List<HospitalInfoDTO> getHospitalInfo();

	HospitalInfoDTO searchHospitals(HospitalInfoDTO hospitalInfo);

	HospitalInfoDTO getHospitalByCode(String hospitalId);

	List<HospitalInfoDTO> getHospitalByType(EHospitalType hospitalType);
	
	HospitalInfoDTO getHospitalByTypeAndName(EHospitalType hospitalType,String hospitalName);

}
