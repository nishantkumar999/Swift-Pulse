package com.accioshoppingbackend.Shopping_Backend.repository;

import com.accioshoppingbackend.Shopping_Backend.model.ApplicationOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<ApplicationOrder, UUID> {

}
