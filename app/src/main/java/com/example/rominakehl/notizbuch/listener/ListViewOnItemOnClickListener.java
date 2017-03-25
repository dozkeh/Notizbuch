package com.example.rominakehl.notizbuch.listener;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.rominakehl.notizbuch.DetailViewActivity;
import com.example.rominakehl.notizbuch.controller.MyFileHandler;

/**
 * Created by rominakehl on 25.03.17.
 */

public class ListViewOnItemOnClickListener implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int index, long id)
    {
        MyFileHandler.getInstance().setCurrentDetailNoteBean(index);

        Intent intDetail = new Intent(view.getContext(), DetailViewActivity.class);
        view.getContext().startActivity(intDetail);

    }

}
