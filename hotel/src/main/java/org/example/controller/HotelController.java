package org.example.controller;

import org.example.dto.ReservationDtoRq;
import lombok.AllArgsConstructor;
import org.example.dto.ReservationDtoRs;
import org.example.entity.Reservation;
import org.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HotelController {

    private HotelService hotelService;

    @PostMapping("/reservation")
    public String makeReservation(@RequestBody ReservationDtoRq reservationDtoRq) {
        return hotelService.createReservation(reservationDtoRq);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable Long id) {
        if (hotelService.getReservation(id) == null) {
            return "Номер брони: " + id + " не найден";
        }
        else {
            hotelService.deleteReservation(id);
            return "Бронь: " + id + " удалена";
        }

    }

    @GetMapping("/getReservation/{id}")
    public String getReservation(@PathVariable Long id) {
        Reservation res = hotelService.getReservation(id);
        return res.toString();
    }

    @GetMapping("/getReservationByName/{name}")
    public String getReservationByName(@PathVariable String name) {
        List<Reservation> reservations = hotelService.getAllReservationsForCustomer(name);
        return reservations.toString();
    }
}
