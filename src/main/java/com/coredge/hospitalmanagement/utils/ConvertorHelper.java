package com.coredge.hospitalmanagement.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.coredge.hospitalmanagement.entity.HospitalInfo;
import com.coredge.hospitalmanagement.utils.dto.HospitalInfoDTO;

@Component
public class ConvertorHelper {

	public List<HospitalInfo> convertToHospital(List<HospitalInfoDTO> hospitalInfoDTOList) {
		List<HospitalInfo> lst = new ArrayList<HospitalInfo>();
		for (HospitalInfoDTO hospitalInfoDTO : hospitalInfoDTOList) {
			lst.add(convertToHospital(hospitalInfoDTO));
		}
		return lst;
	}

	public List<HospitalInfoDTO> convertToHospitalDTO(List<HospitalInfo> hospitalInfoList) {
		List<HospitalInfoDTO> lst = new ArrayList<HospitalInfoDTO>();
		for (HospitalInfo hospitalInfo : hospitalInfoList) {
			lst.add(convertToHospitalDTO(hospitalInfo));
		}
		return lst;
	}

	public HospitalInfo convertToHospital(HospitalInfoDTO hospitalInfo) {
		HospitalInfo info = new HospitalInfo();
		info.setDistrictId((Integer) convert(hospitalInfo.getDistrictid()));
		info.setDistrict(hospitalInfo.getDistrict());
		info.setHospitalAddress(hospitalInfo.getHospaddress());
		info.setHospitalContactNumber(hospitalInfo.getHospcontactno());
		info.setHospitalId(hospitalInfo.getHospid());
		info.setHospitalName(hospitalInfo.getHospname());
		info.setHospitalType(hospitalInfo.getHosptype());
		info.setState(hospitalInfo.getState());
		info.setStateCode((Integer) convert(hospitalInfo.getStatecode()));
		return info;
	}

	private Integer convert(String value) {
		return value != null ? Integer.parseInt(value) : null;
	}

	public HospitalInfoDTO convertToHospitalDTO(HospitalInfo hospitalInfo) {
		HospitalInfoDTO info = new HospitalInfoDTO();
		info.setDistrictid(String.valueOf(hospitalInfo.getDistrictId()));
		info.setDistrict(hospitalInfo.getDistrict());
		info.setHospaddress(hospitalInfo.getHospitalAddress());
		info.setHospcontactno(String.valueOf(hospitalInfo.getHospitalContactNumber()));
		info.setHospid(hospitalInfo.getHospitalId());
		info.setHospname(hospitalInfo.getHospitalName());
		info.setHosptype(hospitalInfo.getHospitalType());
		info.setState(hospitalInfo.getState());
		info.setStatecode(String.valueOf(hospitalInfo.getStateCode()));
		return info;
	}

	public List<HospitalInfoDTO> convertToHospitalDTO(List<HospitalInfo> hospitalInfoList, String link) {
		List<HospitalInfoDTO> lst = new ArrayList<HospitalInfoDTO>();
		for (HospitalInfo hospitalInfo : hospitalInfoList) {
			HospitalInfoDTO hospitalInfoDTO = convertToHospitalDTO(hospitalInfo);
			hospitalInfoDTO.setLink(link + "/name/" + hospitalInfoDTO.getHospname());
			lst.add(hospitalInfoDTO);
		}
		return lst;
	}

}
