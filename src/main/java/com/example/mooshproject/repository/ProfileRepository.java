package com.example.mooshproject.repository;

import com.example.mooshproject.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}