package com.example.myphotoalbum;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = MyImages.class,version = 1)
public abstract class MyImagesDatabase extends RoomDatabase {

    private static MyImagesDatabase instance;
    public abstract MyImagesDAO myImagesDAO();

    public static synchronized MyImagesDatabase getInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    ,MyImagesDatabase.class,"my_images_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

}
