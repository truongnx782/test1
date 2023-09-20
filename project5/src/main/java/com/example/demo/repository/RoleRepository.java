package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Role;

public interface RoleRepository extends CrudRepository<Role, String> {

}
