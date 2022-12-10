package org.example.repository;

import org.example.entity.Reservation;
import org.example.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoomDao extends JpaRepository<Room, Integer>{

    List<Room> findAll();

}
