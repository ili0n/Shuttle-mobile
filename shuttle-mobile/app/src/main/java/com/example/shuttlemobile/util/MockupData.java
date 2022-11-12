package com.example.shuttlemobile.util;

import com.example.shuttlemobile.driver.Driver;
import com.example.shuttlemobile.passenger.Passenger;
import com.example.shuttlemobile.review.Review;
import com.example.shuttlemobile.ride.Ride;
import com.example.shuttlemobile.route.Location;
import com.example.shuttlemobile.route.Route;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockupData {
    public static List<Ride> getRides() {
        List<Ride> rides = new ArrayList<Ride>();

        Passenger passenger1 = new Passenger();
        Driver driver1 = new Driver();
        Route route1 = new Route(
                12,
                LocalDateTime.of(2022, 11, 11, 17, 00),
                LocalDateTime.of(2022, 11, 11, 18, 00),
                LocalTime.of(0, 50, 0),
                400,
                0,
                new Location(44, 40),
                new Location(39, 39)
        );

        Passenger[] passengers = new Passenger[]{passenger1};
        Route[] routes = new Route[]{route1};

        for (int j = 0; j < 7; j++) {
            Ride r1 = new Ride(
                    LocalDateTime.of(2022, 11, 11, 17, 00),
                    LocalDateTime.of(2022, 11, 11, 18, 00),
                    LocalTime.of(0, 50, 0),
                    400,
                    Ride.RideStatus.COMPLETED,
                    new ArrayList<Passenger>(Arrays.asList(passengers)),
                    driver1,
                    12,
                    new ArrayList<Route>(Arrays.asList(routes)),
                    j % 2 == 0,
                    j % 3 == 0
            );

            Ride r2 = new Ride(
                    LocalDateTime.of(2022, 11, 11, 23, 32),
                    LocalDateTime.of(2022, 11, 11, 23, 59),
                    LocalTime.of(0, 25, 0),
                    300,
                    Ride.RideStatus.COMPLETED,
                    new ArrayList<Passenger>(Arrays.asList(passengers)),
                    driver1,
                    8,
                    new ArrayList<Route>(Arrays.asList(routes)),
                    j % 4 == 0,
                    j % 5 == 0
            );

            Ride r3 = new Ride(
                    LocalDateTime.of(2022, 11, 12, 7, 15),
                    LocalDateTime.of(2022, 11, 12, 9, 0),
                    LocalTime.of(2, 10, 0),
                    1100,
                    Ride.RideStatus.COMPLETED,
                    new ArrayList<Passenger>(Arrays.asList(passengers)),
                    driver1,
                    32,
                    new ArrayList<Route>(Arrays.asList(routes)),
                    j % 6 == 0,
                    j % 7 == 0
            );

            rides.add(r1);
            rides.add(r2);
            rides.add(r3);
        }

        return rides;
    }

    public static List<Ride> getRidesForPassenger() {
        return getRides(); // This is only allowed because every ride in getRides has the same lone passenger. Otherwise, rewrite.
    }

    public static List<Review> getReviews(Ride ride) {
        List<Review> res = new ArrayList<>();

        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        for (int i = 0; i < 3; i++) {
            res.add(new Review((5 - i) % 5 + 1, lorem, ride, ride.getPassengers().get(i % ride.getPassengers().size())));
        }

        return res;
    }
}
