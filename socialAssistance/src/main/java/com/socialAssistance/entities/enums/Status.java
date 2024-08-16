package com.socialAssistance.socialAssistance.entities.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Status {
    PREPARING, ON_THE_WAY, DELIVERED
}
