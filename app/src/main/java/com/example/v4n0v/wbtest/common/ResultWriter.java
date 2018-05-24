package com.example.v4n0v.wbtest.common;

import android.os.Environment;
import android.util.Log;

import com.example.v4n0v.wbtest.App;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import timber.log.Timber;

public class ResultWriter {

    public static void writeText(String text) {

        File fileName = null;
        String sdState = android.os.Environment.getExternalStorageState();
        if (sdState.equals(android.os.Environment.MEDIA_MOUNTED)) {
            File sdDir = App.getInstance().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            fileName = new File(sdDir, "result.txt");
        } else {
            fileName = App.getInstance().getCacheDir();
        }
        if (!fileName.exists())
            try {
                fileName.createNewFile();
                Log.d("ResultWriter", "файл создан");
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
            FileWriter f = new FileWriter(fileName, true);
            f.write(text);
            f.flush();
            f.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
