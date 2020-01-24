package ar.com.dariojolo.misnotas;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ar.com.dariojolo.misnotas.DAOs.NotaDao;
import ar.com.dariojolo.misnotas.Entities.NotaEntity;

@Database(entities = {NotaEntity.class}, version = 1)
public abstract class NotaRoomDatabase extends RoomDatabase {

    public abstract NotaDao getNotaDao();

    private static volatile NotaRoomDatabase INSTANCE;

    public static NotaRoomDatabase getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NotaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), NotaRoomDatabase.class, "notas_database").build();
                }
            }
        }

        return INSTANCE;
    }
}
