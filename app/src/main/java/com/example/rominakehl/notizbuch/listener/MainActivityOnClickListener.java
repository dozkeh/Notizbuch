package com.example.rominakehl.notizbuch.listener;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.rominakehl.notizbuch.ListViewActivity;
import com.example.rominakehl.notizbuch.MainActivity;
import com.example.rominakehl.notizbuch.R;
import com.example.rominakehl.notizbuch.beans.NoteBean;
import com.example.rominakehl.notizbuch.controller.MyFileHandler;

/**
 * Created by rominakehl on 12.02.17.
 */

public class MainActivityOnClickListener implements View.OnClickListener {

    //MainActivity
    private static MainActivity mainActivity = null;

    //EditText
    // TODO Warum statisch???? -> Für jedes Objekt dieser Klasse sollten die gleichen Widgets gelten
    // die Variable wird im Klassenobjekt gespeichert
    private static EditText txtFile = null;
    private static EditText txtNote = null;


    //RadioButton
    private static RadioButton radioVeryImportant = null;
    private static RadioButton radioImportant = null;
    private static RadioButton radioNotImportant = null;

    @Override
    public void onClick(View v) {

        //Referenz auf die MainActivity erzeugen
        mainActivity =((MainActivity) v.getContext());

        //Referenzen auf die Widgets erzeugen
        generateWidgetReferences();

        switch (v.getId())
        {
            case R.id.cmdDelete:
                //TODO Alle Notizen löschen
                break;

            case R.id.cmdShow:
                Intent intShow = new Intent(mainActivity, ListViewActivity.class);
                mainActivity.startActivity(intShow);
                break;

            case R.id.cmdSave:
                addNote();
                break;
        }
    }

    private void generateWidgetReferences() {


        //EditText
        this.txtFile = (EditText) mainActivity.findViewById(R.id.txtFile);
        this.txtNote = (EditText) mainActivity.findViewById(R.id.txtNote);


        //RadioButtons
        this.radioImportant = (RadioButton) mainActivity.findViewById(R.id.radioImportant);
        this.radioNotImportant = (RadioButton) mainActivity.findViewById(R.id.radioNotImportant);
        this.radioVeryImportant = (RadioButton) mainActivity.findViewById(R.id.radioVeryImportant);
    }

    private boolean checkUserInput()
    {
        boolean valid = true;
        String strInputFileName = txtFile.getText().toString();
        String strInputNote = txtNote.getText().toString();

        if (strInputFileName.equalsIgnoreCase("")|| strInputNote.equalsIgnoreCase("")) {
            valid = false;
        }
        return valid;

    }

    private String getStatusImportance()
    {
        String strStatusImportance = "";

        if(radioImportant.isChecked()){
            strStatusImportance = radioImportant.getText().toString();
        }
        if(radioVeryImportant.isChecked()){
            strStatusImportance = radioVeryImportant.getText().toString();
        }
        if(radioNotImportant.isChecked()){
            strStatusImportance = radioNotImportant.getText().toString();
        }

        return strStatusImportance;
    }


    private void addNote()
    {
        if(checkUserInput()){

            String strInputFileName = "";
            String strInputStatusImportance = "";
            String strInputNote = "";

            //Daten aus der Oberfäche einsammeln
            strInputFileName = txtFile.getText().toString();
            strInputStatusImportance = getStatusImportance();
            strInputNote = txtNote.getText().toString();

            //Überprüfung, ob eine Datei mit dem Namen bereits existiert
            if (!MyFileHandler.getInstance().fileNameAlreadyExists(strInputFileName)) {
                NoteBean noteBean = new NoteBean(strInputFileName, strInputStatusImportance, strInputNote);
                MyFileHandler.getInstance().getAllNotes().add(noteBean);
                Toast.makeText(mainActivity, "Datei gespeichert\n" + noteBean.toString(), Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(mainActivity,"Datei besteht bereits",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(mainActivity,"Geben Sie bitte einen Dateinamen und eine Notiz ein",Toast.LENGTH_LONG).show();

        }

    }
}