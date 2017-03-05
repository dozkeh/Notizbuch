package com.example.rominakehl.notizbuch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.rominakehl.notizbuch.R;
import com.example.rominakehl.notizbuch.listener.MainActivityOnClickListener;

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
}
