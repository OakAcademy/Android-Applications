package com.example.myphotoalbum;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyImagesRepository {

    private MyImagesDAO myImagesDAO;
    private LiveData<List<MyImages>> imagesList;

    public MyImagesRepository(Application application)
    {
        MyImagesDatabase database = MyImagesDatabase.getInstance(application);
        myImagesDAO = database.myImagesDAO();
        imagesList = myImagesDAO.getAllImages();
    }

    public void insert(MyImages myImages)
    {
        new InsertImageAsyncTask(myImagesDAO).execute(myImages);
    }

    public void delete(MyImages myImages)
    {
        new DeleteImageAsyncTask(myImagesDAO).execute(myImages);
    }

    public void update(MyImages myImages)
    {
        new UpdateImageAsyncTask(myImagesDAO).execute(myImages);
    }

    public LiveData<List<MyImages>> getAllImages()
    {
        return imagesList;
    }

    public static class InsertImageAsyncTask extends AsyncTask<MyImages,Void,Void>
    {

        MyImagesDAO imagesDAO;

        public InsertImageAsyncTask(MyImagesDAO imagesDAO) {
            this.imagesDAO = imagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {

            imagesDAO.Insert(myImages[0]);
            return null;
        }
    }

    public static class DeleteImageAsyncTask extends AsyncTask<MyImages,Void,Void>
    {

        MyImagesDAO imagesDAO;

        public DeleteImageAsyncTask(MyImagesDAO imagesDAO) {
            this.imagesDAO = imagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {

            imagesDAO.Delete(myImages[0]);
            return null;
        }
    }

    public static class UpdateImageAsyncTask extends AsyncTask<MyImages,Void,Void>
    {

        MyImagesDAO imagesDAO;

        public UpdateImageAsyncTask(MyImagesDAO imagesDAO) {
            this.imagesDAO = imagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {

            imagesDAO.Update(myImages[0]);
            return null;
        }
    }

}
