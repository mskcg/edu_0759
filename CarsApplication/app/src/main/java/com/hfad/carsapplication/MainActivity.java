package com.hfad.carsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Car> carList = new ArrayList<>();  // элементы списка
    private CarAdapter carAdapter;
    private Button addCarBtn;

    private Button filterBtn;
    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));  // списковая компановка макета (не плиточная)
        addCarBtn = findViewById(R.id.addCarBtn);
        addCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CarFormActivity.class);
                startActivity(intent);
            }
        });

        searchEditText = findViewById(R.id.searchEditText);
        filterBtn = findViewById(R.id.filterBtn);
        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carAdapter.filter(searchEditText.getText().toString());
            }
        });
    }

    private void recyclerViewInit(){
        Cars cars = new Cars(MainActivity.this);
        carList = cars.getCarList();
        // Сортировка списка по модели машин (в алфавитном порядке)
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car lhs, Car rhs) {
                return lhs.getModel().compareTo(rhs.getModel());
            }
        });

        carAdapter = new CarAdapter(carList);    // создание адаптера
        recyclerView.setAdapter(carAdapter);
    }

    @Override
    public void onResume(){
        super.onResume();
        recyclerViewInit();
    }

    private  class CarHolder extends RecyclerView.ViewHolder implements View.OnClickListener{  // CarHolder создаёт элемент списка
        TextView itemTextView;
        Car car;
        public CarHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            // itemView - текущий layout single_item
            itemTextView = itemView.findViewById(R.id.itemTextView);
            itemView.setOnClickListener(this);
        }

        public void bind(String carString, Car car){
            itemTextView.setText(carString);
            this.car = car;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, CarInfoActivity.class);
            intent.putExtra("car", car);
            startActivity(intent);
        }
    }

    private class CarAdapter extends RecyclerView.Adapter<CarHolder>{     // адаптер помещает элементы, созданные CarHolder, на экран
        private ArrayList<Car> cars;
        private ArrayList<Car> carsCopy;

        public CarAdapter(ArrayList<Car> cars) {
            this.cars = new ArrayList<>();
            this.cars.addAll(cars);
            this.carsCopy = new ArrayList<>();
            this.carsCopy.addAll(cars);
        }

        // фильтрация списка
        public void filter(String text) {
            cars.clear();
            if(text.isEmpty()){
                cars.addAll(carsCopy);
            } else{
                text = text.toLowerCase();
                for(Car car: carsCopy){
                    if(car.getNumber().toLowerCase().contains(text) || car.getModel().toLowerCase().contains(text)){
                        cars.add(car);
                    }
                }
            }
            notifyDataSetChanged();
        }

        @Override
        public CarHolder onCreateViewHolder(ViewGroup viewGroup, int i) {  // RecyclerView вызывает этот метод, когда создаёт новый ViewHolder
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new CarHolder(inflater, viewGroup);     // возвращается элемент списка (пока пустой)
        }

        @Override
        public void onBindViewHolder(CarHolder carHolder, int position) { // RecyclerView вызывает этот медот, чтобы наполнить ViewHolder данными
            Car car = cars.get(position);
            //String carString = car.getNumber()+"\n"+car.getModel();   // один элемент в две строки, чтобы удобнее попадать пальцем
            String carString = car.getNumber()+" - "+car.getModel();
            carHolder.bind(carString, car);
        }

        @Override
        public int getItemCount() {         // возвращает количество элементов в списке
            return cars.size();
        }
    }
}