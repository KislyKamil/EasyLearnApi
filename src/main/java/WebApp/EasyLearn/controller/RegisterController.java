package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.model.request.RegisterForm;
import WebApp.EasyLearn.model.User;
import WebApp.EasyLearn.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping(path = "/api/registerUser")
    public ResponseEntity registerUser(@RequestBody RegisterForm body) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!userService.findUsersByName(body.getLogin()).isEmpty()) {

            return ResponseEntity.ok("this name has been already taken");
        }


        User user = new User();

        user.setUsername(body.getLogin());
        user.setPassword(encoder.encode(body.getPassword()));
        user.setMail(body.getEmail());


        userService.addUser(user);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
