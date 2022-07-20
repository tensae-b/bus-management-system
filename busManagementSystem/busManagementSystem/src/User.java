
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tensu.B
 */
public class User extends ProjectTest1{
    Scanner read =new Scanner(System.in);
  public static String[] address =new String[100];
  public static String[] name = new String[100];
  public static int[] seatNo = new int[100];
  public static String[] custDest = new String[100];
  public static int[] custId=new int[100];
  public static int noCust;
          AddGui addG=new AddGui();
    public void userMenu(){
         VBox vBox = new VBox(15);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(15, 5, 5, 5));

        
         Scene thirdScene = new Scene( vBox, 500, 400);
        
          GridPane pane = new GridPane();
         pane.setAlignment(Pos.CENTER);   //place the nodes in the center of the pane
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
         pane.add(new Label("*****************************"), 0, 0);
       
        //System.out.println("*****************************");
          pane.add(new Label("Enter:"), 0, 1);
          Button dest = new Button(" Destination");
         Button Rseat = new Button("RESERVE SEAT  ");
         
         Button canR = new Button("CANCEL RESRVATION     ");
         Button sear = new Button("SEARCH    ");
        Button exit = new Button("Exit");
        //System.out.println("*****************************");
        //System.out.print("--:");
         
        pane.add(dest, 0, 2);
        pane.add(Rseat, 0, 3);
        pane.add(canR, 0, 4);
        pane.add(sear, 0, 5);
        pane.add(exit, 0, 6);
        
         Scene secondScene = new Scene(pane, 500, 400);

				// New window (Stage)
				Stage newWindow = new Stage();
                                
				newWindow.setTitle("User menu");
				newWindow.setScene(secondScene);

        
         dest.setOnAction(e->{
              
         // try{
                  showDestination();
                  newWindow.close();
                               
               // }
                //catch(InputMismatchException e){
                  //  System.out.println("Please enter a number");
                //     
         } );
         
         Rseat.setOnAction(e->{
              
         // try{
                  if(User.noDest!=0){
                                        reservation(newWindow);
                                        newWindow.close();
                                      //  userMenu();
                  }else{
                                     newWindow.setScene(thirdScene);
                                      Label res= new Label("No destination recorded" );
                       vBox.getChildren().add( res);
                                       userMenu();
                                    }
               // 
                //catch(InputMismatchException e){
                  //  System.out.println("Please enter a number");
                //     
         } );
         
         canR.setOnAction(e->{
              
         // try{
                    cancelReservation(newWindow);
                            newWindow.close();
               // }
                //catch(InputMismatchException e){
                  //  System.out.println("Please enter a number");
                //     
         } );
          sear.setOnAction(e->{
              
         // try{
                 search(newWindow);
                 newWindow.close();
                                   
               // }
                //catch(InputMismatchException e){
                  //  System.out.println("Please enter a number");
                //     
         } );
         
         exit.setOnAction(e->{
              
         // try{
                     addG.start(newWindow);
                     newWindow.close();
               // }                //catch(InputMismatchException e){
                  //  System.out.println("Please enter a number");
                //     
         } );
       
				// Set position of second window, related to primary window.
				//newWindow.setX( primaryStage.getX() + 200);
				//newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();

       
              

    }
    public void reservation(Stage newWindow){
        
        
         GridPane pane1 = new GridPane();
         pane1.setAlignment(Pos.CENTER);   //place the nodes in the center of the pane
        pane1.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane1.setHgap(5.5);
        pane1.setVgap(5.5);
        
        GridPane pane2 = new GridPane();
         pane2.setAlignment(Pos.CENTER);   //place the nodes in the center of the pane
        pane2.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane2.setHgap(5.5);
        pane2.setVgap(5.5);
        
        Scene firstScene = new Scene(pane1, 500, 400);
        Scene secondScene = new Scene(pane2, 500, 400);
         Stage newWindow1 = new Stage();
                                
				newWindow1.setTitle("Register Destination");
				newWindow1.setScene(firstScene);
                                Image icon= new Image(getClass().getResourceAsStream("bus.jpg"));
        newWindow1.getIcons().add(icon);
                                pane1.add(new Label("Enter name "), 0, 0);
                                         TextField nameu= new TextField();
                                             pane1.add( nameu, 1, 0);
					
				     pane1.add(new Label("Enter Address"), 0, 1);
                                         TextField addr= new TextField();
                                          pane1.add(addr, 1, 1);
                                          
                                          Button submit = new Button("SUBMIT");
                                           pane1.add(submit, 1, 3);
                                           
                               pane2.add(new Label("Choose destination by id"), 0, 0);    
                               TextField id= new TextField();
                                             pane2.add( id, 1, 0);
                                             
                                              Button submit1 = new Button("SUBMIT");
                                           pane2.add(submit1, 1, 1);
                                             
                                          
               submit.setOnAction(e->{
                   name[noCust]=nameu.getText();
                     address[noCust]=addr.getText();
                     
                    nameu.clear();
                    addr.clear();
                    showDestination();
                    
                   newWindow1.setScene(secondScene);
             
                                          
                     
                     
                 });	
             
                submit1.setOnAction(e->{
                      int num=Integer.parseInt(id.getText());
                       check(newWindow,num);
                        newWindow.close();
                 });	
       
                newWindow1.show();
     /*   System.out.println("*****************************");
        System.out.println("**********Reservation********");
        System.out.println("*****************************");
        System.out.println("Enter the following information:");
        System.out.print("Name:");
        name[noCust]= read.next();
        System.out.print("Adderss:");
        address[noCust] = read.next();
        showDestination();
        
        System.out.print("Choose destination by id:");
        num = read.nextInt();*/
        
       
    }
    public void cancelReservation(Stage newWindow){
        
       GridPane pane1 = new GridPane();
         pane1.setAlignment(Pos.CENTER);   //place the nodes in the center of the pane
        pane1.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane1.setHgap(5.5);
        pane1.setVgap(5.5);
        
        
        Scene cancel = new Scene( pane1, 500, 400);
         Stage Cancel = new Stage();
      
				 Cancel.setTitle("Cancel Reservation");
				 Cancel.setScene(cancel);

     
       pane1.add(new Label("Enter your Id"), 0, 0);
        
         TextField cancel1= new TextField();
         pane1.add(cancel1,1,0);
         Button submit = new Button("SUBMIT");
         
       pane1.add(submit,0,1);
        submit.setOnAction(e->{
                   
              int num=Integer.parseInt(cancel1.getText());
                                 
                     cancel(Cancel,num);                    
                     
                     Cancel.close();
                 });		
                 
         
   Cancel.show();
       
    }
    public void cancel(Stage newWindow, int num ){
          VBox vBox = new VBox(15);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(15, 5, 5, 5));

        
         Scene thirdScene = new Scene( vBox, 500, 400);
         Stage newWindow2 = new Stage();
        Image icon= new Image(getClass().getResourceAsStream("bus.jpg"));
        newWindow2.getIcons().add(icon);
				newWindow2.setTitle("CANCEL");
				newWindow2.setScene(thirdScene);
                                
         int index=-1;
         for(int i=0; i<noCust; i++){
            if(num == custId[i]){
                index=i;
                break;
            }
        }
        if(index!=-1){
            for(int i=0 ; i<User.noDest; i++){
                if(custDest[index].equals(User.destName[i])){
                    User.noCustAtDest[i]--;
                    User.destAvailable[i]++;
                    noCust--;
                }
            }
            for (int i = index; i < name.length - 1; i++) {
                name[i] = name[i + 1];
                address[i] = address[i + 1];
                custDest[i] = custDest[i + 1];
                custId[i] = custId[i + 1];
                seatNo[i] = seatNo[i + 1];
                
            }
           Label canc= new Label("Reservation Cancelled!");
            Button ok = new Button("OK");
                 
            vBox.getChildren().addAll( canc,ok);
             ok.setOnAction(e->{
                userMenu();
                newWindow2.close();
             });
        }
        else{
            Label exit= new Label("Id not found!");
            Button ok = new Button("OK");
            vBox.getChildren().addAll( exit,ok);
             ok.setOnAction(e->{
                userMenu();
                newWindow2.close();
             });
          
        }
        
        newWindow2.show();
        
        
    }
    
    public void check(Stage newWindow, int num){
        
          VBox vBox = new VBox(15);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(15, 5, 5, 5));

        
         Scene thirdScene = new Scene( vBox, 500, 400);
         Stage newWindow2 = new Stage();
         Image icon= new Image(getClass().getResourceAsStream("bus.jpg"));
       newWindow2.getIcons().add(icon);
        
				newWindow2.setTitle("Alert!");
				newWindow2.setScene(thirdScene);
        boolean flag = false;
         for(int i=0; i<User.noDest; i++){
            if(num == User.destId[i]){
                if(User.destAvailable[i]!=0){
                    custDest[noCust] = User.destName[i];
                    User.destAvailable[i]--;
                    User.noCustAtDest[i]++;
                    seatNo[noCust]++;
                    custId[noCust]=noCust;
                    noCust++;
                    flag = true;
                      Label res= new Label("You have successfully reserved a seat and your Id is" +noCust );
                       Button ok = new Button("OK");
                       vBox.getChildren().addAll( res, ok);
                       ok.setOnAction(e->{
                           newWindow2.close();
                         userMenu();
                            
                 });		
                 

                       
                       
                }
                else{
                   Label nres= new Label("Sorry this destination is fully booked!");
                     Button ok = new Button("OK");
                    vBox.getChildren().addAll( nres,ok);
                  
                      
                       ok.setOnAction(e->{
                           newWindow2.close();
                         userMenu();
                            
                   
                });
            
            
        }
               
                }
        if(flag!=true){
             Label nfo= new Label("There is no destination with that id!");
               Button ok = new Button("OK");
                   vBox.getChildren().addAll( nfo,ok);
                  
                      
                       ok.setOnAction(e->{
                           
                         userMenu();
                            newWindow2.close();
                    reservation(newWindow);
                });
            
             
           
        }
        
        newWindow2.show();
        
    }
    }
    public void showDestination(){
        
		                //the DESTINATION DETAILS//
						//display the "Destination", every destination "Fare", and the "Seat" available//
					System.out.println("****************************************");
 					System.out.println("**ID |   DESTINATION   |  FARE |  SEAT**");
 					System.out.println("****************************************");
 					for(int i=0; i<noDest;i++){
 					System.out.println(destId[i]+" "+ destName[i]+"|\t"   +  destPrice[i]  +  "|\t" + destAvailable[i]  + "**");
 					}
                     
                                       userMenu();    
    }
                             
}
