package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.util.JwtUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;

@Data
public class BaseController {


    protected AuthenticationManager authenticationManager;


    protected JwtUtil jwtTokenUtil = new JwtUtil();


}
