package WebApp.EasyLearn.model.response;

import lombok.Data;

@Data
public class JwtResponse {

    public String username;
    public int id;
    public String token;
    public String msg = null;
    public int testAmount;
}
