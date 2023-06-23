package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.VetStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VetStationRepository extends JpaRepository<VetStation,Long> {

    List<VetStation> findByHostId(Long id);

//    @Query(value = "SELECT v.id AS vet_id, a.id AS address_id FROM vet_station v INNER JOIN address a ON v.id = a.id WHERE v.name LIKE %:name%", nativeQuery = true)
//    List<VetStation> search(@Param("name") String name);

    @Query("SELECT v FROM VetStation v INNER JOIN v.address a WHERE LOWER(v.name) like %:name% AND LOWER(a.city) like %:city% AND LOWER(a.country) like %:country% AND LOWER(a.street) like %:street%")
    List<VetStation> searchByNameAndCity(@Param("name") String name, @Param("city") String city, @Param("country") String country,@Param("street") String steet);
}
