package com.example.myapplication.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {

    private Dao dao;
    private LiveData<List<ModelClass>> model;

    public Repository(Application application) {
        MyDB database = MyDB.getInstance(application);
        dao = database.Dao();
        model = dao.getAllData();
    }

    public void insert(ModelClass model) {
        new InsertAsyncTask(dao).execute(model);
    }

    public void update(ModelClass model) {
        new UpdateAsyncTask(dao).execute(model);
    }

    public void delete(ModelClass model) {
        new DeleteAsyncTask(dao).execute(model);
    }

    public void deleteAllData() {
        new DeleteAllDataAsynceTask(dao).execute();
    }

    public LiveData<List<ModelClass>> getModel() {
        return model;
    }

    private static class InsertAsyncTask extends AsyncTask<ModelClass, Void, Void> {
        private Dao dao;

        private InsertAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(ModelClass... model) {
            dao.insert(model[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<ModelClass, Void, Void> {
        private Dao dao;

        private UpdateAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(ModelClass... models) {
            dao.update(models[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<ModelClass, Void, Void> {
        private Dao dao;

        private DeleteAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(ModelClass... models) {
            dao.delete(models[0]);
            return null;
        }
    }

    private static class DeleteAllDataAsynceTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;
        private DeleteAllDataAsynceTask(Dao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllData();
            return null;
        }
    }
}
