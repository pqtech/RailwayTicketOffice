import entities.Order;
import entities.Passenger;
import entities.Ticket;
import services.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose any command from listed below:");
            System.out.println("0 - Exit");
            System.out.println("1 - Sign up as a new passenger");
            System.out.println("2 - Get a list of your ordered tickets");
            System.out.println("3 - Get a list of available tickets by departure station and date");
            System.out.println("4 - Make a ticket order");
            System.out.println("8 - System: Delete passenger entry by id");
            System.out.println("9 - System: Update passenger entry");
            int cmd = sc.nextInt();
            int id, result;
            String firstName, secondName, phoneNumber;
            switch (cmd) {
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                case 1:
                    System.out.println("Type in your phone number:");
                    phoneNumber = sc.next();
                    SignUpPassenger signUpPassenger = new SignUpPassenger();
                    if (signUpPassenger.checkPhone(phoneNumber)) {
                        System.out.println("This phone number is already registered!");
                        break;
                    }
                    System.out.println("Type in the passenger's first name:");
                    firstName = sc.next();
                    System.out.println("Type in the passenger's second name:");
                    secondName = sc.next();
                    Passenger newPassenger = new Passenger();
                    newPassenger.setFirstName(firstName);
                    newPassenger.setSecondName(secondName);
                    newPassenger.setPhoneNumber(phoneNumber);
                    result = signUpPassenger.createPassenger(newPassenger);
                    if (result == 1) {
                        System.out.println("Successfully created!");
                    } else {
                        System.out.println("Error!");
                    }
                    break;
                case 2:
                    System.out.println("Type in your phone number:");
                    phoneNumber = sc.next();
                    OrdersByPhoneNumber ordersByPhoneNumber = new OrdersByPhoneNumber();
                    if (!ordersByPhoneNumber.checkPhoneRegistered(phoneNumber)) {
                        System.out.println("This phone number is not registered yet!");
                        break;
                    }
                    ArrayList<Order> orders = ordersByPhoneNumber.getOrders(phoneNumber);
                    if (orders.isEmpty()) {
                        System.out.println("There are not any orders for " + phoneNumber);
                    } else {
                        System.out.println("All orders for " + phoneNumber + ":");
                        for (Order order : orders) {
                            System.out.println(order.toStringShort());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Type in the departure station name:");
                    sc.nextLine();
                    String departureStation = sc.nextLine();
                    System.out.println("Type in the departure date (YYYY-MM-DD):");
                    String departureDate = sc.next();
                    ArrayList<Ticket> ticketsByStationAndDate = new TicketsByStationAndDate().getTickets(departureStation, departureDate);
                    if (ticketsByStationAndDate.isEmpty()) {
                        System.out.println("There are not any tickets for " + departureStation +
                                "station on " + departureDate);
                    } else {
                        for (Ticket ticket : ticketsByStationAndDate) {
                            System.out.println(ticket.toString());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ordering a ticket");
                    System.out.println("Type in your phone number:");
                    phoneNumber = sc.next();
                    System.out.println("Type in the existing ticket id:");
                    int ticketId = sc.nextInt();
                    System.out.println("Type in your destination station name:");
                    sc.nextLine();
                    String destinationStation = sc.nextLine();
                    result = new MakeTicketOrder().createOrder(phoneNumber, ticketId, destinationStation);
                    if (result == 1) {
                        System.out.println("Successfully created a new ticket order!");
                    } else {
                        System.out.println("Error!");
                    }
                    break;
                case 5:
                    System.out.println("Creating a new passenger");
                    System.out.println("Type in the passenger's first name:");
                    firstName = sc.next();
                    System.out.println("Type in the passenger's second name:");
                    secondName = sc.next();
                    System.out.println("Type in the passenger's phone number name:");
                    phoneNumber = sc.next();
                    newPassenger = new Passenger();
                    newPassenger.setFirstName(firstName);
                    newPassenger.setSecondName(secondName);
                    newPassenger.setPhoneNumber(phoneNumber);
                    result = new CreateEntity().createPassenger(newPassenger);
                    System.out.println("result = " + result);
                    break;
                case 8:
                    System.out.println("Deleting a passenger by id");
                    System.out.println("Type in the id:");
                    id = sc.nextInt();
                    result = new DeleteById().deletePassenger(id);
                    System.out.println("result = " + result);
                    break;
                case 9:
                    System.out.println("Updating an existing passenger");
                    System.out.println("Type in the passenger's id:");
                    id = sc.nextInt();
                    System.out.println("Type in the passenger's first name:");
                    firstName = sc.next();
                    System.out.println("Type in the passenger's second name:");
                    secondName = sc.next();
                    System.out.println("Type in the passenger's phone number name:");
                    phoneNumber = sc.next();
                    Passenger passenger = new Passenger();
                    passenger.setId(id);
                    passenger.setFirstName(firstName);
                    passenger.setSecondName(secondName);
                    passenger.setPhoneNumber(phoneNumber);
                    result = new UpdateEntity().updatePassenger(passenger);
                    System.out.println("result = " + result);
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
