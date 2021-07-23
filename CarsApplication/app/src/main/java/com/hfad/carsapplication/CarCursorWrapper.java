package com.hfad.carsapplication;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.hfad.carsapplication.database.CarDbSchema;
import java.util.UUID;

public class CarCursorWrapper extends CursorWrapper {
    public CarCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Car getCar(){
        String uuidString = getString(getColumnIndex(CarDbSchema.Cols.UUID));
        String carNumber = getString(getColumnIndex(CarDbSchema.Cols.CARNUMBER));
        String carModel = getString(getColumnIndex(CarDbSchema.Cols.CARMODEL));
        String carColor = getString(getColumnIndex(CarDbSchema.Cols.CARCOLOR));
        int carYear = getInt(getColumnIndex(CarDbSchema.Cols.CARYEAR));
        Car car = new Car(UUID.fromString(uuidString));
        car.setNumber(carNumber);
        car.setModel(carModel);
        car.setColor(carColor);
        car.setYear(carYear);
        return car;
    }
}