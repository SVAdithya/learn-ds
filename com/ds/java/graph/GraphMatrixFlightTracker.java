package com.ds.java.graph;

import java.util.*;

public class GraphMatrixFlightTracker {
    public static class Flight {
        public String flightNumber;
        public int delay;
        public String departureTime;
        public String arrivalTime;
        public String departure;
        public String arrival;

        public Flight(String flightNumber, int delay, String departureTime, String arrivalTime, String departure, String arrival) {
            this.flightNumber = flightNumber;
            this.delay = delay;
            this.departureTime = departureTime;
            this.arrivalTime = arrivalTime;
            this.departure = departure;
            this.arrival = arrival;
        }

        @Override
        public String toString() {
            return "\n\t" +flightNumber + "(" + delay + " min, " + departure + "[" + departureTime + "] -> " + arrival + "[" + arrivalTime + "] )";
        }
    }

    private List<Flight>[][] flightMatrix;
    private int numCities;
    private String[] cityNames;

    @SuppressWarnings("unchecked")
    public GraphMatrixFlightTracker(int numCities, String[] cityNames) {
        this.numCities = numCities;
        this.cityNames = cityNames;
        // Java doesn't allow direct generic array creation
        flightMatrix = new ArrayList[numCities][numCities];
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                flightMatrix[i][j] = new ArrayList<>();
            }
        }
    }

    public void addFlight(int src, int dest, String flightNumber, int delay, String departureTime, String arrivalTime) {
        flightMatrix[src][dest].add(
                new Flight(
                        flightNumber, delay, departureTime, arrivalTime, cityNames[src], cityNames[dest]
                )
        );
    }

    public void removeFlight(int src, int dest, String flightNumber) {
        List<Flight> flights = flightMatrix[src][dest];
        flights.removeIf(f -> f.flightNumber.equals(flightNumber));
    }

    public List<Flight> getFlights(int src, int dest) {
        return new ArrayList<>(flightMatrix[src][dest]);
    }

    public void printNetwork() {
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                if (!flightMatrix[i][j].isEmpty()) {
                    System.out.print("Flights from " + cityNames[i] + " to " + cityNames[j] + ": ");
                    System.out.println(flightMatrix[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] cities = {"NYC", "LA", "Chicago", "Dallas"};
        GraphMatrixFlightTracker tracker = new GraphMatrixFlightTracker(4, cities);
        tracker.addFlight(0, 1, "AA101", 45, "08:00", "11:00");
        tracker.addFlight(0, 1, "UA112", 55, "09:00", "12:10");
        tracker.addFlight(1, 2, "DL200", 25, "10:00", "12:15");
        tracker.addFlight(2, 3, "SW300", 40, "13:00", "15:00");
        tracker.printNetwork();
        System.out.println("-- Removing UA112 from NYC to LA --");
        tracker.removeFlight(0, 1, "UA112");
        tracker.printNetwork();
    }
}
