package com.example.myapplication.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private Repository repository;

    private LiveData<List<ModelClass>> allCourses;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allCourses = repository.getModel();
    }

    public void insert(ModelClass model) {
        repository.insert(model);
    }

    public void update(ModelClass model) {
        repository.update(model);
    }

    public void delete(ModelClass model) {
        repository.delete(model);
    }

    public void deleteAllData() {
        repository.deleteAllData();
    }

    public LiveData<List<ModelClass>> getAllData() {
        return allCourses;
    }
}