package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Accountinfo3 {


        @FXML private AnchorPane pene1;

        @FXML private Button btnExit;

        @FXML private Label txtType;

        @FXML private Button btnBalance;

        @FXML private Button btnList;

        @FXML private Label txtAcountNum;

        @FXML private Label txtAlias;

        @FXML private Button btnBack;

        @FXML
        void pressBack(ActionEvent event) throws IOException {
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
        }

        @FXML
        void pressBalance(ActionEvent event) {

        }

        @FXML
        void pressExit(ActionEvent event) {
                System.exit(0);
        }

        @FXML
        void pressList(ActionEvent event) {

        }

    }