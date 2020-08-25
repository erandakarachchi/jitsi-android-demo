package com.casper.jitsi_mob_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.casper.jitsi_mob_demo.utils.Constants;
import com.facebook.react.modules.core.PermissionListener;

import org.jitsi.meet.sdk.JitsiMeetActivityInterface;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import org.jitsi.meet.sdk.JitsiMeetUserInfo;
import org.jitsi.meet.sdk.JitsiMeetView;
import org.jitsi.meet.sdk.JitsiMeetViewListener;

import java.net.URL;
import java.util.Map;

public class VideoChatActivity extends FragmentActivity implements JitsiMeetActivityInterface, JitsiMeetViewListener {

    private String roomName,username;
    private JitsiMeetView jitsiMeetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_chat);

        getDataFromIntent();


        jitsiMeetView = new JitsiMeetView(VideoChatActivity.this);
        JitsiMeetConferenceOptions conferenceOptions = getVideoChatOptions();
        jitsiMeetView.join(conferenceOptions);

        setContentView(jitsiMeetView);
        jitsiMeetView.setListener(this);
    }

    @Override
    public void requestPermissions(String[] strings, int i, PermissionListener permissionListener) {

    }

    @Override
    public void onConferenceJoined(Map<String, Object> map) {

    }

    @Override
    public void onConferenceTerminated(Map<String, Object> map) {
        this.finish();
    }

    @Override
    public void onConferenceWillJoin(Map<String, Object> map) {

    }

    void getDataFromIntent(){
        Intent mainActivityIntent = getIntent();
        roomName = mainActivityIntent.getStringExtra(Constants.ROOM_NAME);
        username = mainActivityIntent.getStringExtra(Constants.USERNAME);
    }

    private JitsiMeetConferenceOptions getVideoChatOptions(){
        URL VIDEO_CHAT_HOST = null;
        try {
            VIDEO_CHAT_HOST = new URL(Constants.JITSI_MEET_HOST);
        }catch (Exception e){
            e.printStackTrace();
        }

        JitsiMeetUserInfo meetUserInfo = new JitsiMeetUserInfo();
        meetUserInfo.setDisplayName(username);

        return  new JitsiMeetConferenceOptions.Builder()
                .setServerURL(VIDEO_CHAT_HOST)
                .setWelcomePageEnabled(false)
                .setFeatureFlag("chat.enabled",false)
                .setVideoMuted(false)
                .setUserInfo(meetUserInfo)
                .setSubject(roomName)//Set call subject here. use to display phone number here.
                .setRoom(roomName)
                .build();
    }

    public void startVideoChat(){


    }
}