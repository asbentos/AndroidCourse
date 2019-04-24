package com.example.myapplicationxxx;

import java.util.List;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;

@Dao
public interface PersonDao {
    @Query("select * from Person")
    LiveData<List<Person>> loadAllPersons();

    @Query("select * from Person where id = :id")
    Person loadPersonById(int id);

    @Query("select count(*) from Person")
    int totalPersons();
    @Insert
    void insertPerson(Person Person);

    @Delete
    void deletePerson(Person Person);



    @Query("DELETE FROM Person")
    void deleteAll();

}
