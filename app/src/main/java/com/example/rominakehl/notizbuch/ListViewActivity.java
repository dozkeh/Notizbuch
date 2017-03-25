package com.example.rominakehl.notizbuch;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.rominakehl.notizbuch.adapter.ListViewActivityAdapter;
import com.example.rominakehl.notizbuch.controller.MyFileHandler;
import com.example.rominakehl.notizbuch.listener.ListViewOnItemOnClickListener;

public class ListViewActivity extends ListActivity {

    private static ListViewActivityAdapter listViewActivityAdpater = null;
    private static ListViewOnItemOnClickListener listViewOnItemOnClickListener = null;

    @Override
    protected void onResume()
    {
        super.onResume();
        listViewActivityAdpater.notifyDataSetChanged();
        if(listViewActivityAdpater != null) {
            listViewActivityAdpater = new ListViewActivityAdapter(this);
            setListAdapter(listViewActivityAdpater);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if((MyFileHandler.getInstance().getAllNotes()!=null) && (!MyFileHandler.getInstance().getAllNotes().isEmpty()))
        {
            listViewActivityAdpater = new ListViewActivityAdapter(this);
            listViewOnItemOnClickListener = new ListViewOnItemOnClickListener();
            getListView().setOnItemClickListener(listViewOnItemOnClickListener);
            setListAdapter(listViewActivityAdpater);
        }
    }
}
