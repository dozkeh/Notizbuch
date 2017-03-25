package com.example.rominakehl.notizbuch.wrapper;

import android.widget.TextView;

/**
 * Created by rominakehl on 25.03.17.
 */

public class ListViewItemWrapper {

    private TextView txtFilename = null;
    private TextView txtImportance = null;

    public ListViewItemWrapper(){}

    public ListViewItemWrapper(TextView txtFilename, TextView txtImportance)
    {
        setTxtFilename(txtFilename);
        setTxtImportance(txtImportance);
    }

    public TextView getTxtFilename()
    {return txtFilename;}

    public TextView getTxtImportance()
    {return txtImportance;}

    public void setTxtFilename(TextView txtFilename)
    {this.txtFilename=txtFilename;}

    public void setTxtImportance(TextView txtImportance)
    {this.txtImportance=txtImportance;}

}