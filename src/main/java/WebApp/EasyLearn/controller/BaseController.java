package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.model.response.ErrorResponse;
import WebApp.EasyLearn.service.ExamStatsService;
import WebApp.EasyLearn.service.SpeechStatsService;
import WebApp.EasyLearn.util.JwtUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class BaseController {


    protected AuthenticationManager authenticationManager;

    @Autowired
    protected SpeechStatsService speechStatsService;

    protected JwtUtil jwtTokenUtil = new JwtUtil();

    protected PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    protected ErrorResponse response = new ErrorResponse();
}
