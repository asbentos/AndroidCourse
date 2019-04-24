package com.example.myapplicationxxx;

import android.os.AsyncTask;

import java.util.Random;

public final class DataBaseUtil {

    public static void populateAsync(final AppDatabase db){


        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();


    }

    public static class PopulateDbAsync extends AsyncTask <Void, Void, Void> {
        private final AppDatabase pDB;

        PopulateDbAsync(AppDatabase db) {
            pDB = db;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            populateWithSomeData(pDB);
            return null;
        }

        private void populateWithSomeData(AppDatabase pDB) {
            Random random = new Random();
            int number = random.nextInt(500);
            String id = String.valueOf(number);
            Person p1 = new Person(id,"User "+ id);
            pDB.personModel().insertPerson(p1);
        }
    }

}


