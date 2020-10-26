package WebApp.EasyLearn.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {

    private String login;
    private String password;
    private String email;

}
