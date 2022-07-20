
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
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
public abstract class ProjectTest1 {
     Scanner input=new Scanner(System.in);
//    User user = new User();
    
     AddGui addG=new AddGui();
     Stage newWindow = new Stage();
    
    public static String[] destName=new String[100];
    public static int[] destPrice=new int[100];
    public static int[] destAvailable=new int[100];
    public static int[] noCustAtDest=new int[100];
    public static int[] destId=new int[100];
    public static int noDest; 
    
    public void showDestination(){
		int choice;                 
					  if(noDest!=0) {
		                //the DESTINATION DETAILS//
						//display the "Destination", every destination "Fare", and the "Seat" available//
					System.out.println("****************************************");
 					System.out.println("**ID |   DESTINATION   |  FARE |  SEAT**");
 					System.out.println("****************************************");
 					for(int i=0; i<noDest;i++){
 					System.out.println("** "+destId[i]+" | "+ destName[i]+"|\t"   +  destPrice[i]  +  "|\t" + destAvailable[i]  + "**");
 					}
                     }
                                          else{
                                              System.out.println("There is no destination registered!");
                                          }
 					
                                      addG.start(newWindow);
		}
    

    

public void search(Stage newWindow){
        int num;
        String namedest,nameuser;
        
         GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);   //place the nodes in the center of the pane
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        
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
        
        
        
            Button Destination = new Button("Destination");
            Button customer = new Button("customer");
        
         Button exit = new Button("exit");
        pane.add(Destination, 0, 1);
         pane.add(customer, 0, 2);
         pane.add(exit, 0, 3);
         
         pane1.add(new Label("Enter name of the destination you want to Search for"), 0, 0);
                                         TextField desti= new TextField();
                                          pane1.add(desti, 1,0 );
                                          Button submitd = new Button("Submit");
                                           pane1.add(submitd, 1, 1);
                                           
           pane2.add(new Label("Enter name of Customer"), 0, 0);
                                         TextField custo= new TextField();
                                          pane2.add(custo, 1, 0);
                                          Button submitc = new Button("Submit");
                                           pane2.add(submitc, 1, 1);
                                           
                                           
	Scene main= new Scene(pane,500, 400);
        Scene dest= new Scene(pane1,500, 400);
        Scene cust= new Scene(pane2,500, 400);
         Stage primaryStage = new Stage();
        primaryStage.setTitle("search");
        primaryStage.setScene(main);
        primaryStage.show();
Image icon= new Image(getClass().getResourceAsStream("bus.jpg"));
        primaryStage.getIcons().add(icon);
        
        Destination.setOnAction(e->{
            
            
              primaryStage.setScene(dest);
             
              
         });
        submitd.setOnAction(e->{
            
            
            
              dest(primaryStage,desti.getText());
              newWindow.close();
              
         });
        
        
       customer.setOnAction(e->{
            
            
              primaryStage.setScene(cust);
              
           
              
         });
       
       submitc.setOnAction(e->{
           
              cust(primaryStage,custo.getText());
              newWindow.close();
              
         });
        exit.setOnAction(e->{
           
              addG.start(newWindow);
              newWindow.close();
              
         });
       primaryStage.show();
       /* switch(num){
            case 1:
                System.out.println("\nEnter name of the destination you want to Search for:\n");
                namedest = input.next();                
                for(int i=0; i<=noDest; i++){
                    if(namedest.equals(destName[i])){
                        System.out.println("***************************");
                        System.out.println("Destination  |   Price  |   Seats");
                        System.out.println("***************************");
                        System.out.println("** "+destName[i]+"  |"+destPrice[i]+"  |"+destAvailable[i]+" **");
                        flag=true;
                        break;
                    }
                }
                if(flag==false){
                    System.out.println("\nDestination Not Found!\n");
                }
                redirect();
                break;
            case 2:
                System.out.println("\nEnter name of Customer");
                nameuser= input.next();
                for(int i=0; i<=User.noCust; i++){
                    if(nameuser.equals(User.name[i])){
                        System.out.println("***************************");
                        System.out.println("Customer Name  |   Address  |   Seat No");
                        System.out.println("***************************");
                        System.out.println("** "+User.name[i]+" | "+User.address[i]+" | "+User.seatNo[i]);
                        flag=true;
                        break;
                    }
                    if(flag==false){
                    System.out.println("\nCustomer Not Found!\n");
                }
                     addG.start(newWindow);
                break;
                }
            case 3:
                break;
            default:
                System.out.println("\nWrong Input\n");
                search();
                
        }*/
        
        
		   }

  public void dest(Stage primarystage, String namedest){
      boolean flag=false;
      for(int i=0; i<=noDest; i++){
                    if(namedest.equals(destName[i])){
                        System.out.println("***************************");
                        System.out.println("Destination  |   Price  |   Seats");
                        System.out.println("***************************");
                        System.out.println("** "+destName[i]+"  |"+destPrice[i]+"  |"+destAvailable[i]+" **");
                        flag=true;
                        break;
                    } if(flag==false){
                    System.out.println("\nDestination Not Found!\n");
                }
      
      
      
  }
       primarystage.close();
      addG.start(newWindow);
  }
  
   public void cust(Stage primarystage, String nameuser){
      boolean flag=false;
     for(int i=0; i<=User.noCust; i++){
                    if(nameuser.equals(User.name[i])){
                        System.out.println("***************************");
                        System.out.println("Customer Name  |   Address  |   Seat No");
                        System.out.println("***************************");
                        System.out.println("** "+User.name[i]+" | "+User.address[i]+" | "+User.seatNo[i]);
                        flag=true;
                        break;
                    }
                    if(flag==false){
                    System.out.println("\nCustomer Not Found!\n");
                }
                     
      
      
      
  }
     primarystage.close();
     addG.start(newWindow);
  }
    public void viewReport(){
        
        if(User.noCust!=0){
             System.out.println("\n***********************************\n");
                System.out.println("*************Database**************");
                System.out.println("***********************************\n");
                System.out.println("\n  Destination  |Customer Name    \n");
                for(int i=0; i<User.noCust; i++){
                  System.out.println(i+1+". "+ destName[i]+"  "+ User.noCust);
                }
        }
        else{
            System.out.println("\nThere are no Passengers registored! \n");
        }
        
       }
   /* public void redirect(){
        int choice;
        System.out.println("***********************************");
        System.out.println("1.Main Menu");
        System.out.println("2.Continue");
        System.out.print("Enter choice:-");
                choice = input.nextInt();
                switch(choice){
                    case 1:
                        main.mainMenu();
                        break;
                    case 2:                      
                        break;
                    default:
                        System.out.println("Wrong Input!");
                           addG.start(newWindow);
                                                
                                                
        }
        
    }*/
}
