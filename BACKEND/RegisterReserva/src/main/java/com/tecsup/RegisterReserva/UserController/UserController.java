package com.tecsup.RegisterReserva.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tecsup.RegisterReserva.Dto.LoginDTO;
import com.tecsup.RegisterReserva.Dto.UserDTO;
import com.tecsup.RegisterReserva.Response.LoginResponse;
import com.tecsup.RegisterReserva.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/usuario")

public class UserController {
	
	@Autowired
    private UserService userService;

	@PostMapping("/save")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO); // Llamada al método addUser para guardar el usuario en la base de datos
        return ResponseEntity.ok("Usuario registrado correctamente");
    }
	@PostMapping(path = "/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
	    LoginResponse loginResponse = userService.loginUser(loginDTO);
	    if (loginResponse != null) {
	        if (loginResponse.isLoggedIn()) {
	            return ResponseEntity.ok(loginResponse);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Inicio de sesión inválido");
	        }
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud de inicio de sesión");
	    }
	}
}

