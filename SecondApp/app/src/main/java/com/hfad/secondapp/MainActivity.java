package com.hfad.secondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<User> users = new ArrayList<>();  // элементы списка
    UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));  // списковая компановка макета (не плиточная)
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUserName("Пользователь №"+i);
            user.setUserLastName("Фамилия №"+i);
            users.add(user);
        }
        userAdapter = new UserAdapter(users);   // создание адаптера
        recyclerView.setAdapter(userAdapter);
    }

    private  class UserHolder extends RecyclerView.ViewHolder{      // UserHolder создаёт элемент списка
        TextView itemTextView;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            // itemView - текущий layout single_item
            itemTextView = itemView.findViewById(R.id.itemTextView);
        }

        public void bind(String userString){
            itemTextView.setText(userString);
        }
    }
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{     // адаптер помещает элементы, созданные UserHolder, на экран
        ArrayList<User> users;
        public UserAdapter(ArrayList<User> users) {
            this.users = users;
        }
        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {  // RecyclerView вызывает этот метод, когда создаёт новый ViewHolder
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater, viewGroup);     // возвращается элемент списка (пока пустой)
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) { // RecyclerView вызывает этот медот, чтобы наполнить ViewHolder данными
            User user = users.get(position);
            String userString = user.getUserName()+"\n"+user.getUserLastName();
            userHolder.bind(userString);
        }

        @Override
        public int getItemCount() {         // возвращает количество элементов в списке
            return users.size();
        }
    }
}