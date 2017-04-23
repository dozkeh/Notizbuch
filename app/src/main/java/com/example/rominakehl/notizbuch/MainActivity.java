package com.example.rominakehl.notizbuch;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.rominakehl.notizbuch.R;
import com.example.rominakehl.notizbuch.controller.MyFileHandler;
import com.example.rominakehl.notizbuch.listener.MainActivityOnClickListener;
import com.example.rominakehl.notizbuch.services.FileService;

import java.util.logging.FileHandler;

public class MainActivity extends AppCompatActivity {

    //Button
    private Button cmdDelete = null;
    private Button cmdShow = null;
    private Button cmdSave = null;

    //EditText
    private EditText txtFile = null;
    private EditText txtNote = null;

    //RadioGroup
    private RadioGroup radioGroup = null;

    //RadioButton
    private RadioButton radioVeryImportant = null;
    private RadioButton radioImportant = null;
    private RadioButton radioNotImportant = null;

    //Listener
    private View.OnClickListener mainAcitivityOnClickListener = null;

    //Service
    private static FileService fileService = null;

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            FileService.FileServiceBinder binder = (FileService.FileServiceBinder) service;

            fileService = binder.getFileService();

            /*try
            {
                MyFileHandler.getInstance().setAllNotes(fileService.loadAllFilesFromDevice());
            }*/

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            fileService = null;
        }

    };

    public FileService getFileService(){return this.getFileService();}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        //Button
        this.cmdDelete = (Button) findViewById(R.id.cmdDelete);
        this.cmdSave = (Button) findViewById(R.id.cmdSave);
        this.cmdShow = (Button) findViewById(R.id.cmdShow);

        //EditText
        this.txtFile = (EditText) findViewById(R.id.txtFile);
        this.txtNote = (EditText) findViewById(R.id.txtNote);

        //RadioGroup
        this.radioGroup = (RadioGroup) findViewById(R.id.radioGroupClassification);

        //RadioButtons
        this.radioImportant = (RadioButton) findViewById(R.id.radioImportant);
        this.radioNotImportant = (RadioButton) findViewById(R.id.radioNotImportant);
        this.radioVeryImportant = (RadioButton) findViewById(R.id.radioVeryImportant);

        //Generierung Listener
        this.mainAcitivityOnClickListener = new MainActivityOnClickListener();


        //Adding Listeners
        cmdShow.setOnClickListener(mainAcitivityOnClickListener);
        cmdDelete.setOnClickListener(mainAcitivityOnClickListener);
        cmdSave.setOnClickListener(mainAcitivityOnClickListener);


    }

    @Override
    protected void onResume(){
        super.onResume();
        bindConnectionAndStartFileService();

    }

    @Override
    protected void onPause(){
        super.onPause();
        unbindConnectionAndKillFileService();
    }

    @Override
    protected void onStop(){
        super.onStop();
        unbindConnectionAndKillFileService();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unbindConnectionAndKillFileService();
    }


    private void unbindConnectionAndKillFileService(){
        if(fileService != null){
            fileService.stopSelf();

            unbindService(connection);

            fileService=null;
        }
    }


    private void bindConnectionAndStartFileService(){
        Intent intent = new Intent(this, FileService.class);
        bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }
}
