package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.Recipe;
import service.LoginService;
//import service.RegisterService;
import service.WindowService;

import java.io.IOException;

import static java.awt.Color.white;

public class LoginController {
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_register;
    @FXML
    private TextField tf_login;
    @FXML
    private PasswordField pf_password;
    @FXML
    private Label lbl_error;

    // pola globalne
    private LoginService loginService;
    private WindowService windowService;



    // metoda implementujaca instrukcje rozpoczynajace dzialanie aplikacji
    public void initialize() {      // initialize to slowo kluczowe
        loginService = new LoginService();
        windowService = new WindowService();

    }

    @FXML
    void loginAction(ActionEvent event) throws IOException {
        if (loginService.login(lbl_error,tf_login,pf_password)) {
            windowService.openNewWindow("/view/cookBookView.fxml", "Książka kucharska");
            windowService.closeCurrentWindow(lbl_error);    // podajemy cokolwiek z tego okienka
        }

    }

    @FXML
    void keyLoginAction(KeyEvent keyEvent) throws IOException {
        // nasluchiwanie na enter
        if (keyEvent.getCode() == KeyCode.ENTER) {
//            loginService.login(lbl_error, tf_login, pf_password);
            if (loginService.login(lbl_error,tf_login,pf_password)) {
                windowService.openNewWindow("/view/cookBookView.fxml", "Książka kucharska");
                windowService.closeCurrentWindow(lbl_error);    // podajemy cokolwiek z tego okienka
            }

        }
    }

    @FXML
    void registerAction(ActionEvent event) throws IOException {
        // z serwisu WindowService wywolaj metode tworzaca nowe okno
        windowService.openNewWindow("/view/registerView.fxml", "Panel rejestracji");
        windowService.closeCurrentWindow(lbl_error);    // podajemy cokolwiek z tego okienka
    }


    @FXML
    void enterMouseAction(MouseEvent mouseEvent) {
        loginService.setButtonColor(btn_login, "black");
//        btn_login.setStyle("-fx-border-color: aqua;" + "-fx-background-color: black;");
    }

    @FXML
    void exitMouseAction(MouseEvent mouseEvent) {
        loginService.setButtonColor(btn_login, "darkgrey");

    }

    @FXML
    void enterMouseActionRegister(MouseEvent event) {
        loginService.setButtonColor(btn_register, "black");
//        btn_register.setStyle("-fx-border-color: green;" + "-fx-background-color: black;");

    }

    @FXML
    void exitMouseActionRegister(MouseEvent event) {
        loginService.setButtonColor(btn_register, "darkgrey");

    }
}
