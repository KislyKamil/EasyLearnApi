package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.model.response.JwtResponse;
import WebApp.EasyLearn.model.request.LoginForm;
import WebApp.EasyLearn.model.User;
import WebApp.EasyLearn.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

        List<User> users = userService.findUsersByName(data.getLogin());

        if (users.equals(Collections.emptyList())) {


            response.setMsg("user not found");
            return ResponseEntity.ok(response);
        }
        User currentUser = users.get(0);

        if (!passwordEncoder.matches(data.getPassword(), currentUser.getPassword())) {

            response.setMsg("wrong password");
            return ResponseEntity.ok(response);
        }

        final String jwt = jwtTokenUtil.generateToken(currentUser);

        JwtResponse responseObject = new JwtResponse();

        responseObject.id = currentUser.getId();
        responseObject.username = currentUser.getUsername();
        responseObject.token = jwt;

        return ResponseEntity.ok(responseObject);
    }
}
