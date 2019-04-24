package com.example.myapplicationxxx;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Person {
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
    @NonNull
    @PrimaryKey
    private String id ;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private String name;
}
