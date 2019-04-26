package com.example.myapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRespository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

     WordRespository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }
    //wrapper para la llamada.
    LiveData<List<Word>> getmAllWords(){
         return this.mAllWords.;
    }
    //wrapper para la operación insert.
    //NO LLAMAR A ESTA OPERACION DESDE LA UI PORQUE SE CAGA TODO
    //YA QUE EL SISTEMA CONTROLA EXPLICITAMENTE QUE NO SEA EL MISMO HILO
    //SI DETECTA QUE ES EL MISMO, LANZA ERROR.
    public void insert (Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }
    private static class insertAsyncTask extends AsyncTask<Word,Void, Void>{
         private  WordDao mAsyncTaskDao ;
         //const
        insertAsyncTask(WordDao dao){
             mAsyncTaskDao=dao;
         }
         @Override
         protected Void doInBackground(final Word... params ){
             mAsyncTaskDao.insert(params[0]);
             return null;
         }

    }
}
