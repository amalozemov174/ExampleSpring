package org.example.service;

import org.example.dto.ReservationDtoRq;
import lombok.AllArgsConstructor;
import org.example.entity.Reservation;
import org.example.entity.Room;
import org.example.mapper.ReservationMapper;
import org.example.repository.ReservationDao;
import org.example.repository.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HotelService {
    private ReservationDao reservationDao;
    private RoomDao roomDao;
    private ReservationMapper reservationMapper;

    public String createReservation(ReservationDtoRq reservationDtoRq) {
        List<Room> curentRooms =  roomDao.findAll();
        Reservation currentResrevation = reservationMapper.castFromReservationDto(reservationDtoRq, curentRooms);
        List<Reservation> currentReservations = reservationDao.findBetweenDates(currentResrevation.getFromDate(), currentResrevation.getToDate());
        List<Reservation> fromReservations = reservationDao.findFromDate(currentResrevation.getFromDate());
        List<Reservation> toReservations = reservationDao.findToDate(currentResrevation.getToDate());

        if(currentReservations.size() > 0) {
            for (Reservation reservation:currentReservations) {
                if(reservation.getRoom().getName().toLowerCase().equals(currentResrevation.getRoom().getName().toLowerCase())){
                    return "Номер забронирован";
                }
            }
        }
        else if (fromReservations.size() > 0) {
            for (Reservation reservation:fromReservations) {
                if(reservation.getRoom().getName().toLowerCase().equals(currentResrevation.getRoom().getName().toLowerCase())){
                    return "Номер забронирован";
                }
            }
        }
        else if (toReservations.size() > 0) {
            for (Reservation reservation:toReservations) {
                if(reservation.getRoom().getName().toLowerCase().equals(currentResrevation.getRoom().getName().toLowerCase())){
                    return "Номер забронирован";
                }
            }
        }
        reservationDao.save(currentResrevation);
        return "Номер брони " + reservationDao.save(currentResrevation).getId().toString();
    }

    public Reservation getReservation(Long id) {
        Reservation reservation = null;
        try {
            reservation = reservationDao.findById(id).get();
        }
        catch (NoSuchElementException e){
            reservation = null;
        }
        return reservation;
    }

    public void deleteReservation(Long id) {
        if (!(getReservation(id) == null)) {
            reservationDao.delete(getReservation(id));
        }
    }

    public List<Reservation> getAllReservationsForCustomer(String name) {
        return reservationDao.findByName(name);
    }
}
