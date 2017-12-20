package com.example.administrator.notepad;

import android.support.v4.media.MediaMetadataCompat;

import lombok.Data;

/**
 * Created by Administrator on 2017-12-07.
 */

@Data
public class Notepad {
    private String title;

    public Notepad(String title) {
        this.title = title;
    }
}


