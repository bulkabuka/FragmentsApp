package org.leftbrained.taskthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements FirstFragment.FirstFragmentReceiver, SecondFragment.SecondFragmentReceiver {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void secondReceive(String data) {
        FirstFragment secondFragment = (FirstFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_first);
        assert secondFragment != null;
        secondFragment.dataReceived(data);
    }

    @Override
    public void firstReceive(String data) {
        SecondFragment sendFragment = (SecondFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_second);
        assert sendFragment != null;
        sendFragment.dataReceived(data);
    }
}