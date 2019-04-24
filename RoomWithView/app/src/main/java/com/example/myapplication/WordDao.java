package com.example.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

/*    In this codelab, you do not need a conflict strategy this codelab, you do not need a conflict strategy, because the word is your primary key, and the default SQL behavior is ABORT, so that you cannot insert two items with the same primary key into the database.

    If the table has more than one column, you can use

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    to replace a row.

    https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#4
    https://developer.android.com/training/data-storage/room/accessing-data.html

*/

    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}
