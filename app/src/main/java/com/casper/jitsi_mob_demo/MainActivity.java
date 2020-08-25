package com.casper.jitsi_mob_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.casper.jitsi_mob_demo.utils.Constants;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;

public class MainActivity extends AppCompatActivity {

    private Button btnJoinRoom;
    private EditText etRoomName,etUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews(){
        btnJoinRoom = findViewById(R.id.btnJoinRoom);
        etRoomName = findViewById(R.id.etRoomName);
        etUserName = findViewById(R.id.etRoomUserName);

        initListeners();
    }

    void initListeners(){
        btnJoinRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roomName = etRoomName.getText().toString();
                String username = etUserName.getText().toString();
                if(TextUtils.isEmpty(roomName) || TextUtils.isEmpty(username)){
                    DynamicToast.makeError(MainActivity.this, "Please Enter Username and Room Name").show();
                }else{
                    Intent videoChatActivityIntent = new Intent(MainActivity.this,VideoChatActivity.class);
                    videoChatActivityIntent.putExtra(Constants.ROOM_NAME,roomName);
                    videoChatActivityIntent.putExtra(Constants.USERNAME,username);
                    startActivity(videoChatActivityIntent);
                }

            }
        });
    }
}