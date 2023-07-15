package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.Hotel;
import com.example.PetPlanner.model.VetStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByHostId(Long id);
    @Query("SELECT v FROM Hotel v INNER JOIN v.address a WHERE LOWER(v.name) like %:name% AND LOWER(a.city) like %:city% AND LOWER(a.country) like %:country% AND LOWER(a.street) like %:street%")
    List<Hotel> searchByNameAndCity(@Param("name") String name, @Param("city") String city, @Param("country") String country,@Param("street") String steet);
}

