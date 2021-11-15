package com.coredge.hospitalmanagement.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coredge.hospitalmanagement.dao.HosptalManagementBo;
import com.coredge.hospitalmanagement.entity.EHospitalType;
import com.coredge.hospitalmanagement.entity.HospitalInfo;
import com.coredge.hospitalmanagement.repository.IHospitalManagementRepository;
import com.coredge.hospitalmanagement.utils.ConvertorHelper;
import com.coredge.hospitalmanagement.utils.dto.HospitalInfoDTO;
import com.coredge.hospitalmanagement.utils.exception.DataNotFoundException;

@Service
public class HosptalManagementBoImpl implements HosptalManagementBo {

	@Autowired
	private IHospitalManagementRepository hospitalManagementRepository;

	@Autowired
	private ConvertorHelper convertorHelper;

	@Override
	public void saveHospitalInfo(List<HospitalInfoDTO> hospitalInfoDTOList) {
		hospitalManagementRepository.saveAll(convertorHelper.convertToHospital(hospitalInfoDTOList));
	}

	@Override
	public List<HospitalInfoDTO> getHospitalInfo() {
		return convertorHelper.convertToHospitalDTO((List<HospitalInfo>) hospitalManagementRepository.findAll());
	}

	@Override
	public HospitalInfoDTO getHospitalByCode(String hospitalId) {
		Optional<HospitalInfo> opt = hospitalManagementRepository.findByHospitalId(hospitalId);
		if (opt.isPresent())
			return convertorHelper.convertToHospitalDTO(opt.get());

		throw new DataNotFoundException(hospitalId + " not availabe");
	}

	@Override
	public List<HospitalInfoDTO> getHospitalByType(EHospitalType hospitalType) {
		List<HospitalInfo> opt = hospitalManagementRepository.findByHospitalType(hospitalType);
		if (!opt.isEmpty())
			return convertorHelper.convertToHospitalDTO(opt,ServletUriComponentsBuilder.fromCurrentRequest().toUriString());

		throw new DataNotFoundException("Hospital with " + hospitalType + " not availabe");
	}

	@Override
	public HospitalInfoDTO getHospitalByTypeAndName(EHospitalType hospitalType, String hospitalName) {
		Optional<HospitalInfo> opt = hospitalManagementRepository.findByHospitalTypeAndHospitalName(hospitalType,
				hospitalName);
		if (opt.isPresent())
			return convertorHelper.convertToHospitalDTO(opt.get());

		throw new DataNotFoundException("Hospital with " + hospitalType + " and " + hospitalName + " not availabe");
	}

	@Override
	public HospitalInfoDTO searchHospitals(HospitalInfoDTO hospitalInfoDTO) {
		HospitalInfo hospitalInfo = convertorHelper.convertToHospital(hospitalInfoDTO);
		Optional<HospitalInfo> opt = null;
		if (!StringUtils.isEmpty(hospitalInfo.getHospitalName()) && !StringUtils.isEmpty(hospitalInfo.getState())) {
			opt = hospitalManagementRepository.findByHospitalNameAndState(hospitalInfo.getHospitalName(),
					hospitalInfo.getState());

		} else if (!StringUtils.isEmpty(hospitalInfo.getHospitalId())) {
			opt = hospitalManagementRepository.findByHospitalId(hospitalInfo.getHospitalId());
		} else {
			throw new DataNotFoundException(
					"API Under Construction. Search not Available now for given parameter !!!.");
		}

		if (opt.isPresent())
			return convertorHelper.convertToHospitalDTO(opt.get());
		else
			throw new DataNotFoundException("Data not availabe");
	}

}
