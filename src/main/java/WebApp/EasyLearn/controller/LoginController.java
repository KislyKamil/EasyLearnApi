package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.model.LoginForm;
import WebApp.EasyLearn.model.RegisterForm;
import WebApp.EasyLearn.model.User;
import WebApp.EasyLearn.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;


@RestController
public class LoginController extends BaseController {

    final private UserService userService;

    public LoginController(UserService userService) {

        this.userService = userService;
    }

    @RequestMapping(path = "/api/loginUser", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody LoginForm data) throws Exception {

        List<User> userDetails = userService.findUsersByName(data.getLogin());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(data.getLogin(), encoder.encode(data.getPassword()))
//            );
//
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }


        if (userDetails.equals(Collections.emptyList())) {
            return ResponseEntity.ok("user not found");
        }

        final String jwt = jwtTokenUtil.generateToken(userDetails.get(0));

        return ResponseEntity.ok(jwt);

    }
}
