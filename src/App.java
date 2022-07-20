import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ui/login.fxml"));
        primaryStage.setTitle("Exo 4");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}








// import javax.swing.*;
// import java.sql.*;

// public class App {
//     public static void main(String[] args) throws Exception {
//         System.out.println("Hello, World!");
//         try {
//             Connection con=DriverManager.getConnection(
//                     "jdbc:mysql://localhost:3306/dbmessage","root","");

//             Statement stmt=con.createStatement();
//             ResultSet rs=stmt.executeQuery("select * from discussion;");
//             //textPane1.setText(rs.getString(5));
//             while(rs.next()) {
//                 //    textPane1.setText(rs.getString(5));
//                 //discussionList.add(new Discussion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(3),rs.getString(3)));
//                 String msg=rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5);
//                 System.out.println(msg);

//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }
