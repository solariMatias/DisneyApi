package com.alkemy.DisneyApi.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alkemy.DisneyApi.entity.Role;
import com.alkemy.DisneyApi.entity.UserApi;
import com.alkemy.DisneyApi.repository.UserApiRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserApiRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		UserApi user = this.userRepo.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
		return new User(user.getEmail(),user.getPassword(),mappRoles(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mappRoles(Set<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	public boolean verifyEmailAndUsername(String email, String username) {
		return this.userRepo.existsByEmail(email) && this.userRepo.existsByUsername(username);
	}
	
	public UserApi save(UserApi user) {
		return this.userRepo.save(user);
	}
}
