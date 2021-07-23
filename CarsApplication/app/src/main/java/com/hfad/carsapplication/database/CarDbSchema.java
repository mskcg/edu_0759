package com.hfad.carsapplication.database;

public class CarDbSchema {
    public static final class CarTable{
        public static final String NAME = "cars"; // Название таблицы БД
    }
    public static final class Cols{     // колонки БД
        public static final String UUID = "uuid";
        public static final String CARNUMBER = "car_number";
        public static final String CARMODEL = "car_model";
        public static final String CARCOLOR = "car_color";
        public static final String CARYEAR = "car_year";
    }
}
