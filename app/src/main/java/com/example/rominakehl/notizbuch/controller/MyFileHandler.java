package com.example.rominakehl.notizbuch.controller;

import com.example.rominakehl.notizbuch.beans.NoteBean;

import java.util.ArrayList;

/**
 * Created by rominakehl on 19.02.17.
 */

public class MyFileHandler {

    private static MyFileHandler instance = null;

    //Liste aller Notizen
    private ArrayList<NoteBean> allNotes = new ArrayList<>();

    //Detailansicht Bean
    private NoteBean currentDetailNoteBean = new NoteBean();

    private MyFileHandler(){
    }

    //Es wird genau eine Instanz der Klasse zurückgegeben
    public static synchronized MyFileHandler getInstance(){
        if (instance == null){
            instance = new MyFileHandler();
        }
        return instance;
    }

    public ArrayList<NoteBean> getAllNotes(){
        return this.allNotes;
    }

    public void setAllNotes(ArrayList<NoteBean> allNotes){
        this.allNotes.clear();
        this.allNotes.addAll(allNotes);
    }

    public boolean fileNameAlreadyExists(String strInputFileName){
        boolean fileExists = false;

        if(!allNotes.isEmpty()){
            for(NoteBean noteBean : allNotes){
                if(noteBean.getPureFileName().equalsIgnoreCase(strInputFileName)){
                    fileExists = true;
                };
            }
        }
        return fileExists;
    }
}
