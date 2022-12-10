package org.example.mapper;

import org.example.dto.ReservationDtoRq;
import org.example.entity.Reservation;
import org.example.entity.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationMapper {

    public Reservation castFromReservationDto(ReservationDtoRq reservationDtoRq, List<Room> rooms) {
        Room currentRoom = null;
        for (Room roome:rooms) {
            if (roome.getName().toLowerCase().equals(reservationDtoRq.getRoomName().toLowerCase())){
                currentRoom = roome;
            }
        }
        return new Reservation(currentRoom, reservationDtoRq.getFromDate(), reservationDtoRq.getToDate(), reservationDtoRq.getCustomerName());
    }

}
