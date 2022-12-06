package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.myapplication.database.ModelClass;
import com.example.myapplication.database.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecordsActivity extends AppCompatActivity implements OnItemClickListener{

    private RecyclerView coursesRV;
    private List<ModelClass> model;
    private ViewModel viewmodal;
    private ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        coursesRV = findViewById(R.id.recordsRV);
        back_arrow = findViewById(R.id.back_arrow);
        coursesRV.setLayoutManager(new LinearLayoutManager(this));
        coursesRV.setHasFixedSize(true);

        viewmodal = ViewModelProviders.of(this).get(ViewModel.class);

        model = new ArrayList<>();
        viewmodal.getAllData().observe(this, modelClasses -> {
            model.addAll(modelClasses);
            Log.d("locationData", "onCreate: " + model.get(0).getLog());
            Log.d("locationData", "onCreate: " + model.get(0).getLat());
            Log.d("locationData", "onCreate: " + model.get(0).getAddress());
            Log.d("locationData", "onCreate: " + model.get(0).getCity());
            Log.d("locationData", "onCreate: " + model.get(0).getPostalCode());
            Log.d("locationData", "onCreate: " + model.get(0).getType());
            final DataAdapter adapter = new DataAdapter(this, model, this);
            coursesRV.setAdapter(adapter);
        });

        back_arrow.setOnClickListener(v -> {
            finish();
        });

    }

    @Override
    public void perform(int pos) {

    }
}