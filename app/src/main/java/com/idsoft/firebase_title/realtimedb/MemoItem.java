package com.idsoft.firebase_title.realtimedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.idsoft.firebase_title.R;

public class MemoItem {

    private String user;
    private String memotitle;
    private String memocontents;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMemotitle() {
        return memotitle;
    }

    public void setMemotitle(String memotitle) {
        this.memotitle = memotitle;
    }

    public String getMemocontents() {
        return memocontents;
    }

    public void setMemocontents(String memocontents) {
        this.memocontents = memocontents;
    }
}
