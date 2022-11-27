package com.ankita.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankita.ems.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
