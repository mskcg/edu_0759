package com.hfad.carsapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.hfad.carsapplication.database.CarBaseHelper;
import com.hfad.carsapplication.database.CarDbSchema;
import java.util.ArrayList;
import java.util.UUID;

public class Cars {
    private ArrayList<Car> carList;
    private SQLiteDatabase database;
    private Context context;

    public Cars(Context context) {
        this.context = context.getApplicationContext();
        this.database = new CarBaseHelper(context).getWritableDatabase();
    }
    public void addCar(Car car){
        ContentValues values = getContentValues(car);
        database.insert(CarDbSchema.CarTable.NAME, null,values);
    }
    private static ContentValues getContentValues(Car car){
        ContentValues values = new ContentValues();
        // Сопоставляем колонки и свойства объекта Car
        values.put(CarDbSchema.Cols.UUID, car.getUuid().toString());
        values.put(CarDbSchema.Cols.CARNUMBER, car.getNumber());
        values.put(CarDbSchema.Cols.CARMODEL, car.getModel());
        values.put(CarDbSchema.Cols.CARCOLOR, car.getColor());
        values.put(CarDbSchema.Cols.CARYEAR, car.getYear());
        return values;
    }

    private CarCursorWrapper queryCars(){
        Cursor cursor = database.query(CarDbSchema.CarTable.NAME,null,null,null,null,null,null);
        return new CarCursorWrapper(cursor);
    }

    public ArrayList<Car> getCarList(){
        this.carList = new ArrayList<Car>();
        CarCursorWrapper cursorWrapper = queryCars();
        try {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                Car car = cursorWrapper.getCar();
                carList.add(car);
                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }
        return carList;
    }

    public Car getCarFromDB(UUID uuid){
        Cursor cursor = database.query(CarDbSchema.CarTable.NAME,
                null,
                CarDbSchema.Cols.UUID+"=?",
                new String[]{uuid.toString()},
                null, null, null);
        CarCursorWrapper cursorWrapper = new CarCursorWrapper(cursor);
        cursorWrapper.moveToFirst();
        return cursorWrapper.getCar();
    }
    public void removeCar(UUID uuid){
        String stringUuid = uuid.toString();
        database.delete(CarDbSchema.CarTable.NAME,
                CarDbSchema.Cols.UUID+"=?", new String[]{stringUuid});
    }
    public void updateCar(Car car){
        ContentValues values = getContentValues(car);
        String stringUuid = car.getUuid().toString();
        database.update(CarDbSchema.CarTable.NAME,
                values,
                CarDbSchema.Cols.UUID+"=?", new String[]{stringUuid}
        );
    }
}
