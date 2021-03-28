package WebApp.EasyLearn.controller;


import WebApp.EasyLearn.model.User;
import WebApp.EasyLearn.model.examModel.Exam;
import WebApp.EasyLearn.model.request.EditUser;
import WebApp.EasyLearn.model.request.ExamRequest;
import WebApp.EasyLearn.model.response.ExamResponse;
import WebApp.EasyLearn.model.response.JwtResponse;
import WebApp.EasyLearn.service.ExamStatsService;
import WebApp.EasyLearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPanelController extends BaseController {

    @Autowired
    private UserService userService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @PostMapping(path = "/api/EditUser")
    public ResponseEntity<?> editUserPanel(@RequestBody EditUser request) {

        User user = userService.findById(request.getId());

        User newUser = modifyUser(user, request);
        userService.addUser(newUser);

        final String jwt = jwtTokenUtil.generateToken(newUser);

        JwtResponse responseObject = new JwtResponse();

        responseObject.username = newUser.getUsername();
        responseObject.token = jwt;
        responseObject.email= newUser.getMail();

        return ResponseEntity.ok(responseObject);
    }


    private User modifyUser(User user, EditUser request) {

        User mdUser = new User();
        mdUser.setId(user.getId());
        mdUser.setUsername(user.getUsername());
        mdUser.setPassword(user.getPassword());
        mdUser.setMail(user.getMail());

        if (!request.getUsername().equals("")) {
            mdUser.setUsername(request.getUsername());
        }
        if (!request.getPassword().equals("")) {
            mdUser.setPassword(encoder.encode(request.getPassword()));
        }
        if (!request.getEmail().equals("")) {
            mdUser.setMail(request.getEmail());
        }

        return mdUser;

    }
}

