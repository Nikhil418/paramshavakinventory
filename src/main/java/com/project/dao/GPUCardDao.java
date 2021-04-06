package com.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.google.gson.JsonElement;
import com.project.model.GPUCard;

@Repository
public interface GPUCardDao extends JpaRepository<GPUCard, Integer> {
	
	@Query("SELECT Distinct g.gpuCard from GPUCard g where g.status = 'Available'")
	List<String> getAvailableGpuCard();
	
	@Query("SELECT DISTINCT g.gpuCardSerialNumber from GPUCard g where g.gpuCard= :gpuCard and g.status = 'Available'")
	List<String> findGpuCardSerialNumberByCard(String gpuCard);

	@Query("SELECT g from GPUCard g WHERE g.gpuCardSerialNumber= :gpucardsrno and g.status = 'Available'")
	List<GPUCard> findByGPUSerialno(String gpucardsrno);
}
