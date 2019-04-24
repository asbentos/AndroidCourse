package com.example.myapplicationxxx;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class PersonViewModel extends AndroidViewModel {

    public LiveData<List<Person>> persons;

    private AppDatabase personDB;

    public PersonViewModel(Application application) {
        super(application);
        createDB();
    }

    private void createDB() {
        personDB = AppDatabase.getInMemoryDatabase(this.getApplication());
        DataBaseUtil.populateAsync(personDB);
        persons = personDB.personModel().loadAllPersons();


    }

    public void AddAnother() {
        Random random = new Random();
        int number = random.nextInt(500);
        String id = String.valueOf(number);
        Person person = new Person(id, "User " + id);
        try {
            personDB.personModel().insertPerson(person);
        } catch (Exception excp) {
            String message = excp.getMessage();
        }


    }
}
