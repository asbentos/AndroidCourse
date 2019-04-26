package com.example.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRespository mRepository;

    private LiveData<List<Word>> mAllWords;
    public WordViewModel (Application application){
        super(application);
        mRepository = new WordRespository(application);
        mAllWords = mRepository.getmAllWords();
    }
    LiveData <List<Word>> getAllWords(){
        return this.mAllWords;
    }
    public void insert(Word word) {
        mRepository.insert(word);
    }

}
