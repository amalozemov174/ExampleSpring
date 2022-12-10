package org.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
public class ReservationDtoRq {
    //Есть брони (номер брони, имя номера, дата от, дата до, имя покупателя).
    private String roomName;
    private Date fromDate;
    private Date toDate;
    private String customerName;
}
