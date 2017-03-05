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

    //Für die Detailansicht Bean
    private NoteBean currentDetailNoteBean = new NoteBean();

    //Konstruktor
    private MyFileHandler(){
    }

    //Es wird genau eine Instanz der Klasse zurückgegeben -> Singelton-Pattern
    public static synchronized MyFileHandler getInstance(){
        if (instance == null){
            instance = new MyFileHandler();
        }
        return instance;
    }

    //Zugriff auf die Liste mit allen Notizen
    public ArrayList<NoteBean> getAllNotes(){
        return this.allNotes;
    }

    //Aus allen Notizen, die als Liste übergeben werden, die Liste im FileHandler erstellen -> FileService
    public void setAllNotes(ArrayList<NoteBean> allNotes){
        this.allNotes.clear();
        this.allNotes.addAll(allNotes);
    }

    //Methode zur Überprüfung der der existierenden Dateinamen
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
