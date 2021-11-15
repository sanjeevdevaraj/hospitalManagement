package com.coredge.hospitalmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coredge.hospitalmanagement.dao.HosptalManagementBo;
import com.coredge.hospitalmanagement.entity.EHospitalType;
import com.coredge.hospitalmanagement.utils.constants.HospitalConstants;
import com.coredge.hospitalmanagement.utils.dto.HospitalInfoDTO;

@RestController
@RequestMapping("api/v1")
public class HospitalManagementController implements HospitalConstants {

	@Autowired
	private HosptalManagementBo hosptalManagementBo;

	@PostMapping(value = HOSPITALS_PATH)
	public ResponseEntity<?> loadAllHospital(@RequestBody List<HospitalInfoDTO> hospitalInfoList) {
		hosptalManagementBo.saveHospitalInfo(hospitalInfoList);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = HOSPITALS_PATH)
	public ResponseEntity<List<HospitalInfoDTO>> getAllHospital() {
		return new ResponseEntity<List<HospitalInfoDTO>>(hosptalManagementBo.getHospitalInfo(), HttpStatus.OK);
	}

	@PostMapping(value = HOSPITAL_PATH + SEARCH_PATH)
	public ResponseEntity<HospitalInfoDTO> searchHospitals(@RequestBody HospitalInfoDTO hospitalInfo) {
		return new ResponseEntity<HospitalInfoDTO>(hosptalManagementBo.searchHospitals(hospitalInfo), HttpStatus.OK);
	}

	@GetMapping(value = HOSPITAL_PATH + TYPE_PATH)
	ResponseEntity<Object> getHospitalByType(@PathVariable(TYPE) EHospitalType hospitalType) {
		return new ResponseEntity<>(hosptalManagementBo.getHospitalByType(hospitalType), HttpStatus.OK);
	}

	@GetMapping(value = HOSPITAL_PATH + TYPE_PATH + NAME_PATH)
	ResponseEntity<Object> getHospitalByTypeAndName(@PathVariable(TYPE) EHospitalType hospitalType,
			@PathVariable(NAME) String hospitalName) {
		return new ResponseEntity<>(hosptalManagementBo.getHospitalByTypeAndName(hospitalType, hospitalName),
				HttpStatus.OK);

	}
}
