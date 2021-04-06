package com.project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.Delivery;
import com.project.model.DeliveryCount;
@Repository
public interface DeliveryDao extends JpaRepository<Delivery, Integer> {
  
	@Query("select paramshavakversion, count(did) from Delivery group by (paramshavakversion)")
	List<Object> getCountByParamShavakVersion();
	
	@Query("select new com.project.model.DeliveryCount(d.paramshavakversion, count(d.did)) from Delivery d group by (d.paramshavakversion)")
	List<DeliveryCount> getCountByParamShavakVersion1();
}
