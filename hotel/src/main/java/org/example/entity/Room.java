package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique=true)
    @NonNull
    private String name;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservation;

    @Column(nullable = false)
    @NonNull
    private RoomType roomType;


    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", roomType=" + roomType +
                '}';
    }
}
