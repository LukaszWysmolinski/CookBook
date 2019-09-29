package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import service.RegisterService;
import service.WindowService;

import java.io.IOException;
import java.util.Optional;

public class RegisterController {

    @FXML
    private TextField tf_login;
    @FXML
    private PasswordField pf_password;
    @FXML
    private PasswordField pf_password_confirm;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_register;
    @FXML
    private Label lbl_error;
    @FXML
    private TextField tf_password;
    @FXML
    private TextField tf_password_confirm;
    @FXML
    private CheckBox cb_showPassword;

    private WindowService windowService;
    private RegisterService registerService;

    // metoda implementujaca instrukcje rozpoczynajace dzialanie aplikacji
    public void initialize() {      // initialize to slowo kluczowe
        windowService = new WindowService();
        registerService = new RegisterService();

    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        windowService.openNewWindow("/view/loginView.fxml", "Panel logowania");
        windowService.closeCurrentWindow(pf_password_confirm);

    }

    @FXML
    void enterMouseAction(MouseEvent event) {
    }

    @FXML
    void exitMouseAction(MouseEvent event) {
    }

    @FXML
    void keyRegisterAction(KeyEvent event) {
    }

    @FXML
    void registerAction(ActionEvent event) {
        // sprawdzenie czy pola są niepuste gdy cb jest zaznaczony
        if (cb_showPassword.isSelected() && (registerService.fieldIsEmpty(tf_login.getText(), lbl_error) ||
                registerService.fieldIsEmpty(tf_password.getText(), lbl_error) ||
                registerService.fieldIsEmpty(tf_password_confirm.getText(), lbl_error))) {
//            System.out.println("puste");
            // sprawdzenie czy pola są niepuste gdy cb nie jest zaznaczony
        } else if (!cb_showPassword.isSelected() && (registerService.fieldIsEmpty(tf_login.getText(), lbl_error) ||
                registerService.fieldIsEmpty(pf_password.getText(), lbl_error) ||
                registerService.fieldIsEmpty(pf_password_confirm.getText(), lbl_error))) {
//            System.out.println("puste");
            // gdy pola nie są puste
        } else {
            if (registerService.loginCheck(tf_login, lbl_error)) {
                if (registerService.passwordsEquality(
                        cb_showPassword, tf_password, pf_password, tf_password_confirm, pf_password_confirm, lbl_error)) {
//                    System.out.println("rejestrujemy");
                    Optional<ButtonType> confirm = windowService.getConfirmationAlert("Potwierdzenie rejestracji",
                            "Potwierdź dane rejestracji\nlogin: "+tf_login.getText()+"\nhasło: "+pf_password.getText());
                    if (confirm.get()==ButtonType.OK) {
                    registerService.saveUser(tf_login, cb_showPassword, pf_password, tf_password);
                    registerService.clearField(tf_login, tf_password, tf_password_confirm, pf_password, pf_password_confirm);
                    lbl_error.setVisible(true);
                    lbl_error.setText("Zarejestrowano użytkownika"+tf_login.getText().toUpperCase());
                    lbl_error.setStyle("-fx-text-fill: blue");
                    }else{
                        lbl_error.setVisible(true);
                        lbl_error.setText("Rejestracja odrzucona");
                        lbl_error.setStyle("-fx-text-fill: red");
                    }
                }
            }
        }

    }

    @FXML
    void showPasswordAction(ActionEvent event) {
        registerService.showPassword(cb_showPassword, tf_password, pf_password, tf_password_confirm, pf_password_confirm);

    }
}
