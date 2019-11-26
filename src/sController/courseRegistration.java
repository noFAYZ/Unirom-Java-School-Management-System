package sController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import mainP.Course;
import utilities.sqliteConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
public class courseRegistration implements Initializable {


    @FXML
    private TableView<Course> tableView;

    @FXML
    private TableColumn<Course,Integer> idColumn;

    @FXML
    private TableColumn<Course,String> CNameColumn;

    @FXML
    private TableColumn<Course,Integer> preReqColumn;

    @FXML
    private TableColumn<Course,Integer> CHrsColumn;

        @Override
        public void initialize(URL url,ResourceBundle rb){
            idColumn.setCellValueFactory(new PropertyValueFactory<Course,Integer>("id"));
            CNameColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("cName"));
            preReqColumn.setCellValueFactory(new PropertyValueFactory<Course,Integer>("PreReq"));
            CHrsColumn.setCellValueFactory(new PropertyValueFactory<Course,Integer>("cHrs"));

            tableView.setItems(getCourses());
        }

        public ObservableList<Course> getCourses(){
            ObservableList<Course> Course= FXCollections.observableArrayList();
                try {
                    Connection connection = sqliteConnection.dbConnector();
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from courses");
                    while (resultSet.next()) {
                        Course.add(new Course(resultSet.getInt("id"), resultSet.getString("cName"), resultSet.getString("code"), resultSet.getInt("cHrs"), resultSet.getString("aTeacher"), resultSet.getInt("preReq"), resultSet.getString("type"), resultSet.getInt("semester")));
                    }


                } catch (SQLException e) {
                    System.err.println("Cannot Connect to Database");
                }



            return Course;
        }


    //Event Handlers
    @FXML
    void logout(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/mainP/login.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    @FXML
    void homei(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sView/homeview.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    @FXML
    void attendance(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sView/Attendance.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    @FXML
    void dash(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sView/homeStudent.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
}
