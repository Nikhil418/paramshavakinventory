package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.Delivery;
import com.project.model.DeliveryCount;
@Repository
public interface DeliveryDao extends JpaRepository<Delivery, Integer> {
  
	@Query("select paramShavakVersion, count(did) from Delivery group by (paramShavakVersion)")
	List<Object> getCountByParamShavakVersion();
	
	@Query("select new com.project.model.DeliveryCount(d.paramShavakVersion, count(d.did)) from Delivery d group by (d.paramShavakVersion)")
	List<DeliveryCount> getCountByParamShavakVersion1();
}
