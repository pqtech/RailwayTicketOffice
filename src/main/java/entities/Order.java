package entities;

public class Order {
    private int id;
    private int passengerId;
    private int ticketId;
    private String passengerArrivalStation;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerArrivalStation() {
        return passengerArrivalStation;
    }

    public void setPassengerArrivalStation(String passengerArrivalStation) {
        this.passengerArrivalStation = passengerArrivalStation;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", passengerId=" + passengerId +
                ", ticketId=" + ticketId +
                ", passengerArrivalStation='" + passengerArrivalStation + '\'' +
                '}';
    }
}
