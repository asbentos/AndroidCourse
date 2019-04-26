import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.myapplication.Word;
import com.example.myapplication.WordDao;
// Definir la clase como base de datos.
// Existen mas opciones para esa anotation.
@Database(entities = {Word.class}, version=1)
public abstract class WordRoomDatabase extends RoomDatabase {
    //Definir un DAO para trabajar.
    public abstract WordDao wordDao();
    public static volatile WordRoomDatabase INSTANCE;
    //Crear instancia singleton.
    static WordRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (WordRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
