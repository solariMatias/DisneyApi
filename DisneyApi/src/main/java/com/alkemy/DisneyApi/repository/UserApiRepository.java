package com.alkemy.DisneyApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.DisneyApi.entity.UserApi;

@Repository
public interface UserApiRepository extends CrudRepository<UserApi, Long>{

	public UserApi findByUsername(String username);
	
	public UserApi findByEmail(String email);
	
	public UserApi findByUsernameOrEmail(String username, String email);
	
	public boolean existsByUsername(String username);
	
	public boolean existsByEmail(String email);
}
