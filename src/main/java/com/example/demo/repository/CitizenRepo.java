package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Center;
import com.example.demo.entity.Citizen;

@Repository
public interface CitizenRepo extends CrudRepository<Citizen,Integer>{
	List<Citizen> findAllByCenter_Id(int centerId);
	@Transactional
	 @Modifying
	    @Query("UPDATE Citizen c SET c.center = :center WHERE c.id = :citizenId")
	    void updateCitizenCenter(@Param("citizenId") int citizenId, @Param("center") Center center);
}
