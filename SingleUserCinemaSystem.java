package Project;

import java.util.Scanner;

public class SingleUserCinemaSystem {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("""
                           Welcome Back...(PIN set for 1 for fist entrance)
                           Please Enter Pin for Access
                           """);
        int count=0,userpassword=1;
        while(!authenticateUser(input.nextInt())){
            count++;
            if(count!=5)
                System.out.println("Wrong PIN Please Try Again");
            if (count==5){
                System.out.println("The system closing due to entering an incorrect password....");
                System.exit(0);
            }  
        }
        String seat1="EMPTY",seat2="EMPTY",seat3="EMPTY";
        String last="EMPTY",last1="EMPTY",last2="EMPTY",last3="EMPTY";
        
        while (true){
            System.out.println("""
                           Menu :
                            1-View Seat Status
                            2-Reserve a Seat
                            3-Cancel a Reservation
                            4-Show Last 3 Actions
                            5-Change PIN
                            6-Exit
                           """);
            int usermenu = input.nextInt();
            int user;             
             
            switch(usermenu){
                case 1 -> {
                    viewSeats(seat1,seat2,seat3);
                    last="Vıewed seat status";
                    break;
                }
                case 2 -> {
                    System.out.println("Enter the seat number you want to revise (between 1-3) :");
                    switch(input.nextInt()){
                        case 1 -> {
                            seat1=reserveSeat(1,seat1,seat2,seat3); 
                            last="Reserved seat 1";
                    }
                        case 2 -> {
                            seat2=reserveSeat(2,seat1,seat2,seat3);
                            last="Reserved seat 2";
                    }
                        case 3 -> {
                            seat3=reserveSeat(3,seat1,seat2,seat3);
                            last="Reserved seat 3";
                    }
                    }
                    break;
                }

                case 3 -> {
                    System.out.println("Enter the seat number you want to cancel the reservation for (between 1-3) :");
                    switch(input.nextInt()){
                        case 1 -> {
                            seat1=cancelSeat(1,seat1,seat2,seat3);
                            last="Canceled seat 1";
                    }
                        case 2 -> {
                            seat2=cancelSeat(2,seat1,seat2,seat3);
                            last="Canceled seat 2";
                    }
                        case 3 -> {
                            seat3=cancelSeat(3,seat1,seat2,seat3);
                            last="Canceled seat 3";
                    }
                    }
                    break;
                }

                case 4 -> {
                    printLastThreeActions(last1,last2,last3);
                    last="Prınted last 3 actıons";
                    break;
                }
                case 5 -> {
                    count=0;
                    while(count!=5){
                        System.out.println("Enter your current password :");
                        if(input.nextInt()==userpassword){
                            System.out.println("Enter your new password :");
                            userpassword=changePIN(userpassword,input.nextInt());
                            break;
                        }
                        else
                            count++;
                    }
                    last="Changed PIN";
                }
                case 6 -> {
                    System.out.println("The system closing...Have a nice day.");
                    System.exit(0);
                    break;
                } 
        }
        last3=last2;
        last2=last1;
        last1=last;
        }
     
    }
    
   
    
    public static void viewSeats(String s1, String s2, String s3){
        System.out.printf("***** Seats Status *****%n"+
                "Seat 1 : %s%n"+
                "Seat 2 : %s%n"+
                "Seat 3 : %s%n",
                s1.toUpperCase(),s2.toUpperCase(),s3.toUpperCase());
        
    }
    
    public static boolean authenticateUser(int actualPIN){
        return actualPIN==1;
    }
    
    public static String reserveSeat(int seatNumber, String seat1, String seat2, String seat3){
        Scanner input = new Scanner(System.in);
        
        switch(seatNumber){
            case 1 -> {
                if(seat1.equals("EMPTY")){
                    System.out.println("Please enter a name for seat revision :");
                    return seat1=input.nextLine();
                }
                else{
                    System.out.println("This seat has been reserved before...");
                    return seat1;
                }
            }
            case 2 -> {
                if(seat2.equals("EMPTY")){
                    System.out.println("Please enter a name for seat revision :");
                    return seat2=input.nextLine();
                }
                else{
                    System.out.println("This seat has been reserved before...");
                    return seat2;
                }
            }
            case 3 -> {
                if(seat3.equals("EMPTY")){
                    System.out.println("Please enter a name for seat revision :");
                    return seat3=input.nextLine();
                }
                else{
                    System.out.println("This seat has been reserved before...");
                    return seat3;
                }
            }
                    
        }
        return null;
    }

    public static String cancelSeat(int seatNumber, String seat1, String seat2, String seat3){
        Scanner input = new Scanner(System.in);
        
        switch(seatNumber){
            case 1 -> {
                if(seat1.equals("EMPTY")){
                    System.out.println("""
                                       A reservation cannot be cancelled for a seat that has not been previously reserved. 
                                       You are returning to the menu.
                                       """);
                    return seat1;
                }
                else{
                    System.out.println("Your reservation has been canceled");
                    return "EMPTY";
                }
            }
            case 2 -> {
                if(seat2.equals("EMPTY")){
                    System.out.println("""
                                       A reservation cannot be cancelled for a seat that has not been previously reserved. 
                                       You are returning to the menu.
                                       """);
                    return seat2;
                }
                else{
                    System.out.println("Your reservation has been canceled");
                    return "EMPTY";
                }
            }
            case 3 -> {
                if(seat3.equals("EMPTY")){
                    System.out.println("""
                                       A reservation cannot be cancelled for a seat that has not been previously reserved. 
                                       You are returning to the menu.
                                       """);
                    return seat3;
                }
                else{
                    System.out.println("Your reservation has been canceled");
                    return "EMPTY";
                }
            }
                    
        }
        return null;
    }
    
    public static int changePIN(int oldPIN, int newPIN){
        return newPIN;
    }

    public static void printLastThreeActions(String a1, String a2, String a3){
        System.out.printf("***** Last Three Actions *****%n"+
                "Action 1 : %s%n"+
                "Action 2 : %s%n"+
                "Avtion 3 : %s%n",
                a1.toUpperCase(),a2.toUpperCase(),a3.toUpperCase());
        
    }
}
