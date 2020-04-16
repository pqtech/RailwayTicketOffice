package entities;

import java.util.Objects;

public class Ticket {
    private int id;
    private int trainNumber;
    private String departureStation;
    private String arrivalStation;
    private String departureDate;
    private String departureTime;

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Ticket{" +
                "id=" + id +
                ", trainNumber=" + trainNumber +
                ", departureStation='" + departureStation + '\'' +
                ", arrivalStation='" + arrivalStation + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                trainNumber == ticket.trainNumber &&
                departureStation.equals(ticket.departureStation) &&
                arrivalStation.equals(ticket.arrivalStation) &&
                departureDate.equals(ticket.departureDate) &&
                departureTime.equals(ticket.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trainNumber, departureStation, arrivalStation, departureDate, departureTime);
    }
}
