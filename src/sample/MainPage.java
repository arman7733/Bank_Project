package sample;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainPage {


    @FXML private Button btnExit;

    @FXML private Button btnAccountManagement;

    @FXML private Button btnLoanRequest;

    @FXML private Button btnPayingBorrow;

    @FXML private Button btnFundTransfers;

    @FXML private Button btnFrequentlyUsedAccounts;

    @FXML private Button btnAccountInformation;

    @FXML private Button btnCloseAnAccount;


    @FXML
    void pressAccountInformation(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnAccountInformation.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Accountinfo3.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressAccountManagement(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnAccountManagement.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AccountManagement.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void pressCloseAnAccount(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCloseAnAccount.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CloseAccount.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void pressFrequentlyUsedAccounts(ActionEvent event) {

    }

    @FXML
    void pressFundTransfers(ActionEvent event) {

    }

    @FXML
    void pressLoanRequest(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLoanRequest.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LoanRequest.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void pressPayingBorrow(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPayingBorrow.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("PayingBorrow.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


}
