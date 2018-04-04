package com.example.android.roomwordsample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by francescaeeros on 30/03/18.
 */

//Database creation:
//insert annotation @Database(entities={tables}, version = 1)
//Database class have to be abstract and to extend RoomDatabase
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    //always make a public abstract for each entity
    public abstract WordDao wordDao();

    //Make WordRoomDatabase a singleton
    private static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (WordRoomDatabase.class){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class,
                            "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
