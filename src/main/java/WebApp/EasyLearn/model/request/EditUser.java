package WebApp.EasyLearn.model.request;

import lombok.Data;

@Data
public class EditUser {

    private int id;
    private String password;
    private String email;
    private String username;
}
