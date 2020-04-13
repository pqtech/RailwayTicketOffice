import entities.Passenger;
import services.GetById;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cmd = sc.nextInt();
        GetById getByIdObject = new GetById();
        Passenger passenger = getByIdObject.getPassenger(cmd);
        System.out.println(passenger.toString());
    }
}
