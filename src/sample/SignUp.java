/**
 * Sample Skeleton for 'SignUp.fxml' Controller Class
 */

package sample;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import server.*;


public class SignUp extends Signin {

    @FXML private TextField txtFirstName;

    @FXML private Button btnExit;

    @FXML private TextField txtLastName;

    @FXML private TextField txtNationalCode;

    @FXML private TextField txtPhone;

    @FXML private TextField txtEmail;

    @FXML private Button btnBack;

    @FXML private Button btnNext;

    @FXML private TextField txtPassword1;

    @FXML private TextField txtPassword2;

    public static User user;

    @FXML
    void pressBack(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void pressNext(ActionEvent event) throws IOException {

//make sure that Users directory exists
        File UserDir = new File("Users");
        if (!UserDir.exists()) {
            UserDir.mkdir();
        }

        if (!signUpIsCorrect())
            return;

//creating a user account
        user = new User(txtFirstName.getText(), txtLastName.getText(),txtPassword1.getText()
                ,txtNationalCode.getText(),txtEmail.getText(),txtPhone.getText());

        DataBase.userSaver(user);

// go to next page
        Stage stage =(Stage) btnNext.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("OpeningAccount.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        error.setInfo("your UserAccount created!");


    }

    boolean signUpIsCorrect(){

//check that the passwords are the same or not
        boolean isThePasswordsTheSame = txtPassword1.getText().equals(txtPassword2.getText());
        if(!isThePasswordsTheSame) {
            error.setError("the passwords aren't the same");
            return false;
        }

//check the user have already signed up or not
        if ( DataBase.isNationalCodeExist(txtNationalCode.getText()) )
            return false;

// check that national number has only 10 index
        if (!nationalNumHas10Index(txtNationalCode.getText()))
            return false;

//check that first/last name are only letters
        if (!(isonlyLetter(txtFirstName.getText()) && isonlyLetter(txtLastName.getText())))
            return false;

//check that national code is only numberic
        if (!(isOnlyNumber(txtNationalCode.getText()) && isOnlyNumber(txtPhone.getText())))
            return false;

        if (!passwordHas4Index(txtPassword1.getText()))
            return false;

        if (! nameXHasNIndex(txtPhone.getText(), 11)) {
            return false;
        }

            return true;
    }
    boolean isonlyLetter (String name){

        for (int i = 0; i < name.length(); i++) {

            if(!Character.isLetter(name.charAt(i))){
                error.setError("the first name of last name aren't letters \n pleas enter only letters ");
                return false;
            }
        }
        return true;
    }
    boolean isOnlyNumber (String code){

        for (int i = 0; i < code.length(); i++) {
            if(!isNumber(code.charAt(i))) {
                error.setError("the " + code + "isn't fully numberic ");
                return false;
            }
        }
        return true;
    }
    boolean isNumber(char ch){
        return ('0' <= (int)ch && (int)ch <= '9');
    }
    boolean nameXHasNIndex (String name, int indexLimit){
        if (name.length() == indexLimit)
            return true;
        else {
            error.setError(  name + " haven't"+ indexLimit + " index");
            return false;
        }
    }
    boolean nationalNumHas10Index (String nationalCode){
       return  nameXHasNIndex( nationalCode , 10);
    }
    boolean passwordHas4Index(String pass){
        return nameXHasNIndex(pass, 4);
    }
}





