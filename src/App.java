
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Offre;
import models.User;

public class App extends Application {
    static Stage stage;
    static Scene scene;
    static Parent root;
    public static Connection con;
    static String userId;
    static User user;
    static Offre seletedOfrre;
    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("ui/login.fxml"));
        primaryStage.setTitle("Recru GHR");
        primaryStage.setScene(new Scene(root, 700, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recrutementdb","root","");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        launch(args);
    }
}

