package com.example.rominakehl.notizbuch.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileService extends Service {
    //private OutputStreamWriter out = null;

    //private InputStreamReader inputStreamReader = null;

    //private BufferedReader in = null;

    //Brücke zur Aktivity
    public class FileServiceBinder extends Binder
    {
        public FileService getFileService(){
            return FileService.this;
        }
    }

    IBinder binderFileService = new FileServiceBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return binderFileService;
    }

    public void loadAllFilesFromDevice(){

    }
}
