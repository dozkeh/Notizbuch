package com.example.rominakehl.notizbuch.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.rominakehl.notizbuch.beans.NoteBean;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

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

    public NoteBean loadAFileFromDevice(FileInputStream fileInputStream){
        return new NoteBean();
    }

    public ArrayList<NoteBean> loadAllFilesFromDevice(){
        return new ArrayList<NoteBean>();
    }
}
