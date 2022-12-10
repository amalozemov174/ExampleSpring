package org.example.repository;

import org.example.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.example.entity.Reservation;

import java.util.Date;
import java.util.List;

@Component
public interface ReservationDao extends JpaRepository<Reservation, Long> {

    @Query(value = "select * from reservation u where u.from_date = ?1 and u.to_date = ?2", nativeQuery = true)
    List<Reservation> findBetweenDates(Date fromDate, Date toDate);

    @Query(value = "select * from reservation u where u.from_date = ?1", nativeQuery = true)
    List<Reservation> findFromDate(Date fromDate);

    @Query(value = "select * from reservation u where u.to_date = ?1", nativeQuery = true)
    List<Reservation> findToDate(Date fromDate);

    @Query(value = "select * from reservation u where u.customer_name = ?1", nativeQuery = true)
    List<Reservation> findByName(String customerName);
}
