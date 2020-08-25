package com.casper.jitsi_mob_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.casper.jitsi_mob_demo.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private Button btnJoinRoom;
    private EditText etRoomName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews(){
        btnJoinRoom = findViewById(R.id.btnJoinRoom);
        etRoomName = findViewById(R.id.etRoomName);

        initListeners();
    }

    void initListeners(){
        btnJoinRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roomName = etRoomName.getText().toString();
                Intent videoChatActivityIntent = new Intent(MainActivity.this,VideoChatActivity.class);
                videoChatActivityIntent.putExtra(Constants.ROOM_NAME,roomName);
                startActivity(videoChatActivityIntent);
            }
        });
    }
}