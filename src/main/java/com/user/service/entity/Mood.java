package com.user.service.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Container(containerName = "mood-logging")
public class Mood {

    @Id
    private String id;
    private String profileId;
    private String moodType;
    private String moodDescription;
    private LocalDateTime createTimeStamp;

}
