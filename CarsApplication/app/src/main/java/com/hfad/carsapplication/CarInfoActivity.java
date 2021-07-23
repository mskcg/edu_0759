package com.hfad.carsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CarInfoActivity extends AppCompatActivity {
    private TextView textViewInfoNumber;
    private TextView textViewInfoModel;
    private TextView textViewInfoColor;
    private TextView textViewInfoYear;
    private Button removeCarInfo;
    private Button editCarInfo;
    private Cars cars;
    private Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);
        cars = new Cars(CarInfoActivity.this);
        car = (Car) getIntent().getSerializableExtra("car");
        removeCarInfo = findViewById(R.id.removeCarInfo);
        editCarInfo = findViewById(R.id.editCarInfo);
        editCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarInfoActivity.this, CarFormActivity.class);
                intent.putExtra("car", car);
                startActivity(intent);

            }
        });
        removeCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cars.removeCar(car.getUuid());
                onBackPressed();
            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        car = cars.getCarFromDB(car.getUuid());
        textViewInfoNumber = findViewById(R.id.textViewInfoNumber);
        textViewInfoModel = findViewById(R.id.textViewInfoModel);
        textViewInfoColor = findViewById(R.id.textViewInfoColor);
        textViewInfoYear = findViewById(R.id.textViewInfoYear);
        textViewInfoNumber.setText("Номер: "+car.getNumber());
        textViewInfoModel.setText("Модель: "+car.getModel());
        textViewInfoColor.setText("Цвет: "+car.getColor());
        textViewInfoYear.setText("Год выпуска: "+car.getYear());
    }
}