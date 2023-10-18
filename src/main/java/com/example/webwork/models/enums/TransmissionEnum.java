package com.example.webwork.models.enums;

public enum TransmissionEnum {
    MANUAL ("Механичсекая", 0),
    AUTOMATIC ("Автоматиическая", 1);
    private String type;
    private int number;

    TransmissionEnum(String type, int number) {
        this.type = type;
        this.number = number;
    }
}
