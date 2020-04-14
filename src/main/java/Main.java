import entities.Passenger;
import entities.Ticket;
import services.GetAll;
import services.GetById;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose any command from listed below:");
            System.out.println("0 - exit");
            System.out.println("1 - get all passengers");
            System.out.println("2 - get all tickets");
            System.out.println("3 - get passenger by id");
            System.out.println("4 - get ticket by id");
            int cmd = sc.nextInt();
            switch (cmd) {
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                case 1:
                    System.out.println("All passengers:");
                    ArrayList<Passenger> passengers = new GetAll().getPassengers();
                    for (Passenger passenger : passengers) {
                        System.out.println(passenger.toString());
                    }
                    break;
                case 2:
                    System.out.println("All tickets:");
                    ArrayList<Ticket> tickets = new GetAll().getTickets();
                    for (Ticket ticket : tickets) {
                        System.out.println(ticket.toString());
                    }
                    break;
                case 3:
                    System.out.println("Type in a passenger id:");
                    cmd = sc.nextInt();
                    Passenger passenger = new GetById().getPassenger(cmd);
                    System.out.println(passenger.toString());
                    break;
                case 4:
                    System.out.println("Type in a ticket id:");
                    cmd = sc.nextInt();
                    Ticket ticket = new GetById().getTicket(cmd);
                    System.out.println(ticket.toString());
                    break;
                default:
                    System.out.println("Wrong command!");
            }
            System.out.println("Press Enter for continue...");
            Scanner sc2 = new Scanner(System.in);
            sc2.nextLine();
        }
    }
}
