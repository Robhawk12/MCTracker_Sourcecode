package com.rtj.mctrackerrebuild.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rtj.mctrackerrebuild.dao.ClientDao;
import com.rtj.mctrackerrebuild.entities.Client;

@Database(entities = {Client.class}, version = 24, exportSchema = false)
public abstract class ClientDBBuilder extends RoomDatabase {

    public abstract ClientDao clientDao();

    private static volatile  ClientDBBuilder Instance;

    static ClientDBBuilder getDatabase(final Context context){
        if(Instance==null){
            synchronized (ClientDBBuilder.class){
                if (Instance == null){
                    Instance = Room.databaseBuilder(context.getApplicationContext(), ClientDBBuilder.class,
                                    "My_Client_Builder.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return Instance;
    }
}