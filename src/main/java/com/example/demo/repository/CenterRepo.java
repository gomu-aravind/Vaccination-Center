package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Center;

@Repository
public interface CenterRepo extends CrudRepository<Center,Integer>{
	@Query("SELECT c.id FROM Center c WHERE c.centername = :centerName")
    int findIdByCentername(@Param("centerName") String centerName);
	@Query("SELECT DISTINCT c.city FROM Center c")
	List<String> findDistinctCity();
	 @Query("SELECT c.centername FROM Center c")
	List<String> findAllByCentername();
}
