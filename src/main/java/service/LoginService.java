package service;

import Utility.InMemoryDB;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;


import java.util.Optional;

public class LoginService {
    public boolean login(Label lbl_error, final TextField tf_login, final PasswordField pf_password){
        lbl_error.setVisible(true);


        Optional<User> loggedUser = InMemoryDB.users.stream().filter(user -> user.getLogin().equals(tf_login.getText()) && user.getPassword().equals(pf_password.getText())).findAny();

        if (loggedUser.isPresent()) {
            lbl_error.setText(">  zalogowano  <");
            lbl_error.setStyle("-fx-text-fill: blue");
            return true;
        } else {
            lbl_error.setText(">  błąd logowania  <");
            lbl_error.setStyle("-fx-text-fill: red");
            return false;
        }
    }

    public void setButtonColor(Button button, String color){
        button.setStyle("-fx-background-color: "+color);

    }
}
