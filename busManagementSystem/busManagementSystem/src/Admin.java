
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tensu.B
 */
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.geometry.HPos; 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class Admin extends ProjectTest1 {
    
    Scanner console=new Scanner(System.in);
     public String name;
     public String password;
     private final String adminid="Abebe";
     private final String pass="1234";
     int num;

    
        
            
       
  
    
     public Boolean login(String name, String password){
         
      /*  System.out.println("Enter User Name: ");
        name = console.next();
        System.out.println("Enter Password: ");
        password = console.next();*/

        if(( name.equals(adminid)) && ( password.equals(pass))){
             //menu();
             return true;
        }
        else{
           //System.out.println("Incorrect UserName or Password!\n"); 
          // login();
           return false;
        }
     }
     public void menu(){
         AddGui addG=new AddGui();
         
         GridPane pane = new GridPane();
         pane.setAlignment(Pos.CENTER);   //place the nodes in the center of the pane
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
         pane.add(new Label("*****************************"), 0, 0);
       
        //System.out.println("*****************************");
          pane.add(new Label("Enter:"), 0, 1);
         Button Rdes = new Button("Register Destination");
         Button mdest = new Button("Modify Destination");
         Button viewR = new Button("View Report");
        Button exit = new Button("Exit");
        //System.out.println("*****************************");
        //System.out.print("--:");
         
        pane.add(Rdes, 0, 2);
        pane.add(mdest, 0, 3);
        pane.add(viewR, 0, 4);
        pane.add(exit, 0, 5);
        
         Scene secondScene = new Scene(pane, 500, 400);

				// New window (Stage)
				Stage newWindow = new Stage();
                                
				newWindow.setTitle("Admin menu");
				newWindow.setScene(secondScene);

        Image icon= new Image(getClass().getResourceAsStream("bus.jpg"));
       newWindow.getIcons().add(icon);
         viewR.setOnAction(e->{
              
         // try{
                   viewReport(newWindow);
                     newWindow.close();
                //catch(InputMismatchException e){
                  //  System.out.println("Please enter a number");
                //     
         } );
         
         mdest.setOnAction(e->{
              
         // try{
                    modify();
                    newWindow.close();
               // }
                //catch(InputMismatchException e){
                  //  System.out.println("Please enter a number");
                //     
         } );
         
         Rdes.setOnAction(e->{
              
         // try{
                    registor(newWindow);
                     newWindow.close();
                     // main.mainMenu();
               // }
                //catch(InputMismatchException e){
                  //  System.out.println("Please enter a number");
                //     
         } );
         
         
         exit.setOnAction(e->{
              
         // try{
                     newWindow.close();
                    addG.start(newWindow);
               // }
                //catch(InputMismatchException e){
                  //  System.out.println("Please enter a number");
                //     
         } );
       
				// Set position of second window, related to primary window.
				//newWindow.setX( primaryStage.getX() + 200);
				//newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();

       
                    

     }
     public void registor(Stage newWindow){
          VBox vBox = new VBox(15);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(15, 5, 5, 5));

         Scene thirdScene = new Scene( vBox, 500, 400);

				// New window (Stage)
				Stage newWindow1 = new Stage();
                                
				newWindow1.setTitle("Register Destination");
				newWindow1.setScene(thirdScene);
                    Image icon= new Image(getClass().getResourceAsStream("bus.jpg"));
        newWindow1.getIcons().add(icon);
        
        
        
          GridPane pane2 = new GridPane();
         pane2.setAlignment(Pos.CENTER);   //place the nodes in the center of the pane
        pane2.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane2.setHgap(5.5);
        pane2.setVgap(5.5);
        
         
          Scene fourthScene = new Scene(pane2, 500, 400);
          
          GridPane pane3 = new GridPane();
         pane3.setAlignment(Pos.CENTER);   //place the nodes in the center of the pane
        pane3.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane3.setHgap(5.5);
        pane3.setVgap(5.5);
        
         
          Scene fifthScene = new Scene(pane3, 500, 400);
          
          /*Stage newWindow2 = new Stage();
                                
				newWindow2.setTitle("Register Destination");
				newWindow2.setScene(fourthScene);*/
         Button Submit = new Button("REGISTER");
        vBox.getChildren().add( Submit);
         Button exit = new Button("EXIT");
        vBox.getChildren().add(exit);
        

  exit.setOnAction(e->{
             
              
              newWindow1.close();
                                      
                        
         } );

				// New window (Stage)
				
        
               Submit.setOnAction(e->{
             
              
              newWindow1.setScene(fourthScene);
                                      
                        
         } );
               pane2.add(new Label("Enter name of the destination"), 0, 0);
                                         TextField named= new TextField();
                                             pane2.add( named, 1, 0);
					
				     pane2.add(new Label("Enter price of the destination"), 0, 1);
                                         TextField priced= new TextField();
                                          pane2.add(priced, 1, 1);
					
					 pane2.add(new Label("Enter available seat of the destination"), 0, 2);
                                          TextField seat= new TextField();
                                           pane2.add(seat, 1, 2);
                                          
                                          
                                          Button submit1 = new Button("SUBMIT");
                                           pane2.add(submit1, 1, 3);
                                             
		 submit1.setOnAction(e->{
                    String name=named.getText();
                    int price=Integer.parseInt(priced.getText());
                    int seatd= Integer.parseInt(seat.getText());
                    regi(newWindow1,name,price, seatd );
                    
                    named.clear();
                    priced.clear();
                    seat.clear();
                             newWindow1.setScene(fifthScene);             
                                          
                     
                     
                 });		
                 
                 pane3.add(new Label("do you want to add another destination"), 0, 0);
       
       
        Button yes = new Button("yes");
        pane3.add(yes, 0, 1);
            
          Button no = new Button("No");
        pane3.add(no, 1, 1);
                       
       yes.setOnAction(e->{
                    
                      newWindow1.setScene(thirdScene);  
                     
                 });
                 	
        no.setOnAction(e->{
                    
                      menu(); 
                      newWindow1.close(); 
                     
                 });
                 //  System.out.println("How many destinations do you want to register?");
				    // num1=console.nextInt();
                                      
//				 
//                                    menu();
//                                 
                                         
				 newWindow1.show(); 
                    }	  
				 
      public void regi(Stage newWindow1,String name, int price ,int seat){
          
               

          // for(int i=0, j=Admin.noDest; i<num1;i++,j++){
                                    
                                           for(int i=0, j=Admin.noDest; i<1;i++,j++){
                                               Admin.destName[j]=name;
                                                Admin.destPrice[j]=price;
	 				Admin.destAvailable[j]=seat;
                                        Admin.destId[j]=Admin.noDest;
                                        Admin.noDest++; 
                                    }
                                 
                                 
          
          
          
          
      }
     public void modify(){
           String destname;
         int index=-1;
         System.out.println("\nEnter name of the destination you want to modify");
         destname = console.next();
         for(int i=0; i<=Admin.noDest; i++){
             if(destname.equals(Admin.destName[i])){
                 index=i;
                 break;
             }
         }
         if(index==-1){
             System.out.println("\nDestination Not Found!\n");
         }
         else{
             System.out.println("Edit name of the destination");
		Admin.destName[index]=console.next();
	     System.out.println("Edit price of the destination");
		Admin.destPrice[index]=console.nextInt();
	     System.out.println("Edit available seat of the destination");
		Admin.destAvailable[index]=console.nextInt();
             System.out.println("\nYou have successfully Edited the destination!\n");
	       
         }
        
         

     }
      
     public void viewReport(Stage newWindow) {
    int choice;                 
    if(User.noCust!=0) {
        //the DESTINATION DETAILS and The Customers Details//
    
      System.out.println("*******************************************************************");
    System.out.println("CustId   |CustName   |DestID |   DESTINATION   |  FARE         ");
    System.out.println("****************************************");
          for(int i=0; i<User.noCust;i++)
          {
    System.out.println(User.custId[i] +"\t"+User.name[i]+" "+destId[i]+" "+ destName[i]+"|\t"   +  destPrice[i]  +  "|\t"  + "**");
    }
     }
                 else{
                        System.out.println("There is no Information!");
                      }
                menu();
                       /* System.out.println("*****************************************************");
                    System.out.println("1.Continue");
                        System.out.println("2.Exit");
                        choice = input.nextInt();
                        switch(choice){
                            case 1:
                              adminMenu();
                                break;
                            case 2:
                                System.exit(0);
                                break;
                                
                        }*/
  }

}

