package com.residencia.atividadeAPI.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.atividadeAPI.entities.Role;
import com.residencia.atividadeAPI.entities.RoleEnum;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(RoleEnum name);
}