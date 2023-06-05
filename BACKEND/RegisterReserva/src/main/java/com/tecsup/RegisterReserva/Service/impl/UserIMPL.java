package com.tecsup.RegisterReserva.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
/////////////////////////////////77
import org.springframework.stereotype.Service;

import com.tecsup.RegisterReserva.Dto.LoginDTO;
///////////////////
import com.tecsup.RegisterReserva.Dto.UserDTO;
import com.tecsup.RegisterReserva.Service.UserService;
import com.tecsup.RegisterReserva.Entity.User;
import com.tecsup.RegisterReserva.Repo.UserRepo;
import com.tecsup.RegisterReserva.Response.LoginResponse;

@Service
public class UserIMPL implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void addUser(UserDTO userDTO) {

	    User user = new User();
	    user.setUser(userDTO.getUserid());
	    user.setNombres(userDTO.getNombres());
	    user.setApellidos(userDTO.getApellidos());
	    user.setDni(userDTO.getDni());
	    user.setCarrera(userDTO.getCarrera());
	    user.setCiclo(userDTO.getCiclo());
	    user.setTelefono(userDTO.getTelefono());
	    user.setEmail(userDTO.getEmail());
	    user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));

	    userRepo.save(user);
	}
	@Override
	public LoginResponse loginUser(LoginDTO loginDTO) {
	    String email = loginDTO.getEmail();
	    String password = loginDTO.getPassword();

	    User user = userRepo.findByEmail(email);

	    if (user != null) {
	        String encodedPassword = user.getPassword();
	        boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);

	        if (isPasswordMatch) {
	            return new LoginResponse("Inicio de sesión exitoso", true);
	        } else {
	            return new LoginResponse("Contraseña incorrecta", false);
	        }
	    } else {
	        return new LoginResponse("Email no existe", false);
	    }
	}
}