package com.tecsup.RegisterReserva.Service;

import com.tecsup.RegisterReserva.Dto.LoginDTO;
import com.tecsup.RegisterReserva.Dto.UserDTO;
import com.tecsup.RegisterReserva.Response.LoginResponse;

public interface UserService {
	
	void addUser(UserDTO userDTO);
	
	LoginResponse loginUser(LoginDTO loginDTO);
	

}
