package com.nuitinfo.nuitinfoapi.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {
    List<Long> rescuersIds;
    LocalDateTime departureTime;
}
