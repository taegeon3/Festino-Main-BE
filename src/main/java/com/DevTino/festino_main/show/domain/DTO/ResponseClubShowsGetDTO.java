package com.DevTino.festino_main.show.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class ResponseClubShowsGetDTO {
    UUID clubId;
    String performer;
    String showDate;
    String showStartTime;
    String showEndTime;
    String clubImage;
    String clubDescription;
    String instagram;
    List<Map<String, Object>> musicList;
    Boolean isShowing;
}
