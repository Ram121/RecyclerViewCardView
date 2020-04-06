package com.example.recyclerviewcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtHi) TextView txtHi;
    @BindView(R.id.myRecyclerView) RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewCustomAdapter recyclerViewCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewCustomAdapter = new RecyclerViewCustomAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewCustomAdapter);


        Observable.just("How are you").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                txtHi.setText(s);
            }
        });

        Observable.just("Ram", "Shyam", "Kaka", "Nana", "Bapu", "Chachu", "Manya", "Sonya", "Gotya", "Betya").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
            recyclerViewCustomAdapter.addStringToList(s);
            }
        });
    }
}