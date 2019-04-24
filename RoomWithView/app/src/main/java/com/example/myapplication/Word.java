package com.example.myapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "word_table")
public class Word {
//    SI QUEREMOS AUTOGENERAR UN VALOR
//    @PrimaryKey(autoGenerate = true)
//    private int id;

//    SI QUEREMOS IGNORAR UN ATRIBUTO DE LA CLASE (POR EJEMPLO SI ES MUY PESADO)
//    @Ignore
//    Bitmap picture;

//      SI QUEREMOS IGNORAR UN ATRIBUTO CUANDO HAY HERENCIA
//            @Entity(igoredColumns = "picture")

    @PrimaryKey
    @NonNull
    @ColumnInfo (name = "word")

    private String mWord;

    public Word(@NonNull String word){ this.mWord=word;}

    public String getWord() {
        return mWord;
    }
}

