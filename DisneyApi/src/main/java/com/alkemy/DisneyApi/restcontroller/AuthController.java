package com.alkemy.DisneyApi.restcontroller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.DisneyApi.dtos.JWTAuthResponseDto;
import com.alkemy.DisneyApi.dtos.UserApiLoginDto;
import com.alkemy.DisneyApi.dtos.UserApiSignUpDto;
import com.alkemy.DisneyApi.entity.Role;
import com.alkemy.DisneyApi.entity.UserApi;
import com.alkemy.DisneyApi.repository.RoleRepository;
import com.alkemy.DisneyApi.security.CustomUserDetailsService;
import com.alkemy.DisneyApi.security.JwtTokenProvider;
//import com.alkemy.DisneyApi.service.MailService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userApiSrvc;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private PasswordEncoder pswdEnconder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

//	@Autowired
//	private MailService mailSrvc;
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/login")
	public JWTAuthResponseDto authenticateUser(@RequestBody UserApiLoginDto loginDto) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenProvider.generateNewToken(authentication);
		return new JWTAuthResponseDto(token);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
	public String signUpUserApi(@RequestBody UserApiSignUpDto userDto) {
		if (!this.userApiSrvc.verifyEmailAndUsername(userDto.getEmail(), userDto.getUsername())) {
			UserApi user = new UserApi();
			user.setEmail(userDto.getEmail());
			user.setUsername(userDto.getUsername());
			user.setPassword(this.pswdEnconder.encode(userDto.getPassword()));
			//Todos los users se registran con admin por defecto
			Role role = this.roleRepo.findByName("ROLE_ADMIN");
			user.setRoles(Collections.singleton(role));
			userApiSrvc.save(user);
			/*
			El envio del mail se encuentra desactivado debido a que da error a la hora de autentificar el mail emisor.
			 
			String message = "USUARIO CREADO PARA " + userDto.getEmail() + "\n PASSWORD " + userDto.getPassword();
			mailSrvc.sendMail("adogtameproject@gmail.com", userDto.getEmail(), "SIGNUP FOR DinesyApi USER", message);
			*/
			return "USER CREATED";
		} else {
			return "ERROR";
		}

	}
}
