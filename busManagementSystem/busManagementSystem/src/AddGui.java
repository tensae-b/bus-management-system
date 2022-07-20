/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tensu.B
 */

// admin login 
// unsername - Abebe
//password- 1234

  import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.geometry.HPos; 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.scene.layout.GridPane;
  import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddGui extends Application  {
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        Admin ad= new Admin();
         User us= new User();
        //
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);   //place the nodes in the center of the pane
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        
                pane.add(new Label("Welcome to Anit Bus resevation system"), 0, 0);
                
        Button admin = new Button("Admin");
       admin.setStyle("-fx-font-size: 30 ");
         Button user = new Button("User");
       user.setStyle("-fx-font-size: 30 ");
        pane.add(admin, 0, 1);
         pane.add(user, 0, 2);
        //Set the horizontal alignment for the node
        GridPane.setHalignment(admin, HPos.CENTER); 
        GridPane.setHalignment(user, HPos.CENTER); 
      /**************************************************************/
        
         GridPane pane1 = new GridPane();
        pane1.setAlignment(Pos.CENTER);   //place the nodes in the center of the pane
        pane1.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane1.setHgap(5.5);
        pane1.setVgap(5.5);
        
         
        
          
       
       
                pane.add(new Label("Welcome to Anit Bus resevation system"), 0, 0);
       
        Button login1 = new Button("Login");
        
         Button exit = new Button("exit");
        pane1.add(login1, 0, 1);
         pane1.add(exit, 0, 2);
        //Set the horizontal alignment for the node
        GridPane.setHalignment(login1, HPos.CENTER); 
        GridPane.setHalignment(exit, HPos.CENTER);
        
       /**************************************************************/
        
         GridPane pane2 = new GridPane();
        pane.setAlignment(Pos.CENTER);   //place the nodes in the center of the pane
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        
          pane2.add(new Label("USER NAME:"), 0, 0);
        TextField username= new TextField();
        pane2.add(username, 1, 0);
        TextField password= new TextField();
        pane2.add(new Label("PASSWORD"), 0, 1);
        pane2.add(password, 1, 1);
       
        Button login2 = new Button("Login");
        pane2.add(login2, 1, 3);
        //Set the horizontal alignment for the node
        
        GridPane.setHalignment(login2, HPos.RIGHT); 

        //
        /**************************************************************/
        Scene main= new Scene(pane,500, 400);
       
       Scene login = new Scene(pane1, 500, 400);
       Scene reg= new Scene(pane2,500, 400);
       
         primaryStage.setTitle("ANIT BUS RESERVATION SYSYTEM");
        primaryStage.setScene(main);
        primaryStage.show();
        Image icon= new Image(getClass().getResourceAsStream("bus.jpg"));
        primaryStage.getIcons().add(icon);
        /**************************************************************/
         admin.setOnAction(e->{
              primaryStage.setScene(login);
         }
         );
         user.setOnAction(e->{
              us.userMenu();
               primaryStage.close();
         }
         );
         

          login1.setOnAction(e->{
                primaryStage.setScene(reg);
                 
         }
         );
          exit.setOnAction(e->{
               primaryStage.close();
         }
         );
        // Create a scene and place it in the stage
        login2.setOnAction(e->{
               Boolean che= ad.login(username.getText(), password.getText());
               if(che==true)
               {
                   ad.menu();
                   primaryStage.close();
               }else{
                   alert(primaryStage);
               }
         }
         );
       /**************************************************************/
    }
    public void alert(Stage primaryStage){
        
        Label secondLabel = new Label("Incorrect password or username");

				StackPane secondaryLayout = new StackPane();
				secondaryLayout.getChildren().add(secondLabel);

				Scene secondScene = new Scene(secondaryLayout, 500, 400);

				// New window (Stage)
				Stage newWindow = new Stage();
                                newWindow.initModality(Modality.APPLICATION_MODAL);
				newWindow.setTitle("Alert!");
				newWindow.setScene(secondScene);
Image icon= new Image(getClass().getResourceAsStream("bus.jpg"));
        newWindow.getIcons().add(icon);
				// Set position of second window, related to primary window.
				newWindow.setX( primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
        
    }
      public static void main(String[] args) { 
          launch(args); 
      }

        }
   

