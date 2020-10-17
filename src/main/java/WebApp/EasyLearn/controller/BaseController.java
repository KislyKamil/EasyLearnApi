package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.model.response.ErrorResponse;
import WebApp.EasyLearn.util.JwtUtil;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class BaseController {


    protected AuthenticationManager authenticationManager;


    protected JwtUtil jwtTokenUtil = new JwtUtil();

    protected PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    protected ErrorResponse response = new ErrorResponse();
}
