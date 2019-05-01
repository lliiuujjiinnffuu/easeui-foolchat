package com.ce.foolchat;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ChatActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    ChatFragment chatFra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        chatFra = new ChatFragment();
        chatFra.setArguments(getIntent().getExtras());
        fragmentManager.beginTransaction().add(R.id.fl,chatFra).commit();
    }
}
