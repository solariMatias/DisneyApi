package com.alkemy.DisneyApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.DisneyApi.entity.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	public Role findByName(String name);
}
