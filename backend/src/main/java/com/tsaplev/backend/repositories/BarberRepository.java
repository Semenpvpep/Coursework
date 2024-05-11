package com.tsaplev.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsaplev.backend.entities.Barber;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Long> {
    List<Barber> findAllByDepartmentId(Long departmentId);
}
