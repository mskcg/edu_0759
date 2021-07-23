package com.hfad.carsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CarFormActivity extends AppCompatActivity {

    private Button insertCarBtn;
    private EditText editTextNumber;
    private EditText editTextModel;
    private EditText editTextColor;
    private EditText editTextYear;
    private Car car;
    private boolean new_car = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_form);
        car = (Car) getIntent().getSerializableExtra("car");
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextModel = findViewById(R.id.editTextModel);
        editTextColor = findViewById(R.id.editTextColor);
        editTextYear = findViewById(R.id.editTextYear);
        insertCarBtn = findViewById(R.id.insertCarBtn);
        if(car != null){ // Если редактируем машину
            editTextNumber.setText(car.getNumber());
            editTextModel.setText(car.getModel());
            editTextColor.setText(car.getColor());
            editTextYear.setText("" + car.getYear());
        }else{ // если добавляем новую
            new_car = true;
            car = new Car();
        }

        insertCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                car.setNumber(editTextNumber.getText().toString());
                car.setModel(editTextModel.getText().toString());
                car.setColor(editTextColor.getText().toString());
                car.setYear(Integer.parseInt(editTextYear.getText().toString()));
                Cars cars = new Cars(CarFormActivity.this);
                if(new_car) cars.addCar(car);
                else cars.updateCar(car);
                onBackPressed();
            }
        });
    }
}