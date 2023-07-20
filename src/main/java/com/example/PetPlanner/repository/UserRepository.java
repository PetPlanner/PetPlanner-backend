package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.Role;
import com.example.PetPlanner.model.User;
import com.example.PetPlanner.model.VetStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    @Query("SELECT v FROM User v INNER JOIN v.address a WHERE LOWER(a.city) like %:city% AND v.role = 'WALKER'")
    List<User> findWalkerByCity(@Param("city") String city);

    List<User> findByRole(Role role);
}
