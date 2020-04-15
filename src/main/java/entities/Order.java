package entities;

public class Order {
    private int id;
    private int passengerId;
    private int ticketId;
    private int trainNumber;
    private String departureStation;
    private String arrivalStation;
    private String departureDate;
    private String departureTime;
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

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", passengerId=" + passengerId +
                ", ticketId=" + ticketId +
                ", trainNumber=" + trainNumber +
                ", departureStation='" + departureStation + '\'' +
                ", arrivalStation='" + arrivalStation + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", passengerArrivalStation='" + passengerArrivalStation + '\'' +
                '}';
    }

    public String toStringShort() {
        return "Order{" +
                "orderId=" + id +
                ", ticketId=" + ticketId +
                ", trainNumber=" + trainNumber +
                ", departureStation='" + departureStation + '\'' +
                ", arrivalStation='" + arrivalStation + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", passengerArrivalStation='" + passengerArrivalStation + '\'' +
                '}';
    }
}
