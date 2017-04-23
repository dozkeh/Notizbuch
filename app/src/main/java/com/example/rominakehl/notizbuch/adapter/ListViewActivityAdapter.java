package com.example.rominakehl.notizbuch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rominakehl.notizbuch.R;
import com.example.rominakehl.notizbuch.beans.NoteBean;
import com.example.rominakehl.notizbuch.controller.MyFileHandler;
import com.example.rominakehl.notizbuch.wrapper.ListViewItemWrapper;

import java.util.logging.FileHandler;

/**
 * Created by rominakehl on 25.03.17.
 */

public class ListViewActivityAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater = null;

    public ListViewActivityAdapter(Context context)
    {
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return MyFileHandler.getInstance().getAllNotes().size();
    }

    @Override
    public Object getItem(int index)
    {
        return MyFileHandler.getInstance().getAllNotes().get(index);
    }

    @Override
    public long getItemId(int id)
    {
        return id;
    }

    @Override
    public View getView(int index, View currentView, ViewGroup parent)
    {
        NoteBean noteBean = (NoteBean) getItem(index);
        if(currentView == null) {
            currentView = layoutInflater.inflate(R.layout.list_view_item_layout, parent, false);
        }
        ListViewItemWrapper listViewItemWrapper = new ListViewItemWrapper();

        listViewItemWrapper.setTxtFilename((TextView) currentView.findViewById(R.id.txtFilename));
        listViewItemWrapper.setTxtImportance((TextView) currentView.findViewById(R.id.txtImportance));

        listViewItemWrapper.getTxtFilename().setText(noteBean.getPureFileName());
        listViewItemWrapper.getTxtImportance().setText(noteBean.getStatusImportance());


        return currentView;
    }


}