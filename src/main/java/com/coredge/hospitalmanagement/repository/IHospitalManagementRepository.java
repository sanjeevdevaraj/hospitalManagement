package com.coredge.hospitalmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coredge.hospitalmanagement.entity.EHospitalType;
import com.coredge.hospitalmanagement.entity.HospitalInfo;

@Repository
public interface IHospitalManagementRepository extends CrudRepository<HospitalInfo, String> {

	Optional<HospitalInfo> findByHospitalId(String hospitalId);

	Optional<HospitalInfo> findByHospitalNameAndState(String hospitalName, String state);
	
	List<HospitalInfo> findByHospitalType(EHospitalType hospitalType);

	Optional<HospitalInfo> findByHospitalTypeAndHospitalName(EHospitalType hospitalType, String hospitalName);

}
