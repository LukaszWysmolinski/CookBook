package model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    public static int id;
    private int  user_id;
    private String login;
    private String password;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.user_id = id;
        id++;
    }
}
