package org.example.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//Есть брони (номер брони, имя номера, дата от, дата до, имя покупателя).
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    @NonNull
    private Room room;

    @Column(nullable = false)
    @NonNull
    private Date fromDate;

    @Column(nullable = false)
    @NonNull
    private Date toDate;

    @Column(nullable = false)
    @NotNull
    private String customerName;

//    public Reservation(@NonNull Room room, @NonNull Date fromDate, @NonNull Date toDate, String customerName) {
//        this.room = room;
//        this.fromDate = fromDate;
//        this.toDate = toDate;
//        this.customerName = customerName;
//    }
}
