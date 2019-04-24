package com.example.myapplicationxxx;

import android.content.Context;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {Person.class},version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    static final String DATABASE_NAME = "BD_PEPITO";
    public abstract PersonDao personModel();

    public static AppDatabase getInMemoryDatabase(Context context){
        if (INSTANCE==null){
             INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE_NAME)
                     //Falta eliminar esto
                     .allowMainThreadQueries()
                    .build();
        }
        return  INSTANCE;
    }
    public static void destroyOnInstance() {INSTANCE=null;}
}
