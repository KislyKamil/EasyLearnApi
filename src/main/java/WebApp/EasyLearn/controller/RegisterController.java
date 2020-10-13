package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.enums.Role;
import WebApp.EasyLearn.model.RegisterForm;
import WebApp.EasyLearn.model.User;
import WebApp.EasyLearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {

        this.userService = userService;

    }


    @PostMapping(path = "/api/registerUser")
    public ResponseEntity registerUser(@RequestBody RegisterForm body) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = new User();

        user.setUsername(body.getLogin());
        user.setPassword(encoder.encode(body.getPassword()));
        user.setMail(body.getEmail());
        user.setRoleId(1);

        userService.addUser(user);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(path = "/home")
    public String Home() {
        return "HELLLLLOOOO AUTH";
    }
}
