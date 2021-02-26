package com.aiolos.solutions.youtubeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends YouTubeBaseActivity {
YouTubePlayerView youTubePlayer;
Button btnPlay;
YouTubePlayer.OnInitializedListener yOnInitializedListener;
    public static final String TAG="Checking";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate:Starting");
        btnPlay=findViewById(R.id.btnplay);
        youTubePlayer=findViewById(R.id.youtube_view);

        yOnInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG,"onClick:Done Intialization");
                List<String> videoList=new ArrayList<>();
                videoList.add("ajtGlNRsM-I&list=RDMMajtGlNRsM-I&start_radio=1");
                videoList.add("sK7riqg2mr4&list=RDMMajtGlNRsM-I&index=14");
                videoList.add("B1Jrf2Pz5vU&list=RDMMajtGlNRsM-I&index=7");

//                youTubePlayer.loadVideo("watch?v=W4hTJybfU7s");

                if (!b){
                    youTubePlayer.cueVideo("W4hTJybfU7s");
                }
                //for adding playlist one by one
//                youTubePlayer.loadPlaylist("https://www.youtube.com/c/HiteshChoudharydotcom/playlists");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG,"onClick:Failed to Intialization");
            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayer.initialize(YoutubeConfig.getKey(),yOnInitializedListener);

            }
        });
    }


}