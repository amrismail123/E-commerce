package com.example.mooshproject.repository;

import com.example.mooshproject.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<com.example.mooshproject.entity.Address, Long> {
}