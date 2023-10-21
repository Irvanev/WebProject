package com.example.webwork.constants;

public enum CategoryEnum {
    Car ("Машина", 0),
    Bus ("Автобус", 1),
    Truck ("Грузовик", 2),
    Motorcycle ("Мотоцикл", 3);
    private String type;
    private int number;

    CategoryEnum(String type, int number) {
        this.type = type;
        this.number = number;
    }
}
