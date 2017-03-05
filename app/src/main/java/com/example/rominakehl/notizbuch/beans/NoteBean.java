package com.example.rominakehl.notizbuch.beans;

/**
 * Created by rominakehl on 19.02.17.
 */

public class NoteBean {
    private static final String FILE_TYPE_TXT = ".txt";

    private String strFileName = "";

    private String strStatusImportance = "";

    private String strNote = "";

    public NoteBean() {
    }

    public NoteBean(String strFileName, String strStatusImportance, String strNote) {
        setFileName(strFileName);
        setStatusImportance(strStatusImportance);
        setNote(strNote);
    }

    public String getFileName() {
        return strFileName;
    }

    public String getStatusImportance() {
        return strStatusImportance;
    }

    public String getNote() {
        return strNote;
    }

    public void setFileName(String strFileName) {
        this.strFileName = strFileName+FILE_TYPE_TXT;
    }

    public void setStatusImportance(String strStatusImportance) {
        this.strStatusImportance = strStatusImportance;
    }

    public void setNote(String strNote) {
        this.strNote = strNote;
    }

    public String getPureFileName() {
        String[] strPureFileName = strFileName.split(FILE_TYPE_TXT);
        return strPureFileName[0];
    }

    @Override
    public String toString()
    {
        String strReturn = "";
        strReturn = "Dateiname: "+strFileName+"|";
        strReturn += "Wichtigkeit: " + strStatusImportance + "\n";
        strReturn += "Notiz:\n" + strNote;

        return strReturn;
    }
}
