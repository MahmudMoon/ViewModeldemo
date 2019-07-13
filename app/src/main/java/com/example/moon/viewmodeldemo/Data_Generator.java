package com.example.moon.viewmodeldemo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class Data_Generator extends ViewModel {
    private static final String TAG = "MyTag";
    MutableLiveData number;
    public MutableLiveData getNumber(){
        Log.d(TAG, "getNumber: Called");
        if(number==null) {
            Log.d(TAG, "getNumber: Number Created");
            number = new MutableLiveData();
            createLiveData();
        }
        return number;
    }

    public void createLiveData() {
        Random random = new Random();
        int num = random.nextInt(10);
        number.setValue(num);
        Log.d(TAG, "createLiveData: ");

    }


    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
    }
}
