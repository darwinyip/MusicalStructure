package local.darwin.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayingActivity extends Activity {

    boolean playing = true;
    ImageButton playPauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String artist = intent.getStringExtra("artist");

        TextView titletv = findViewById(R.id.playing_title);
        TextView artisttv = findViewById(R.id.playing_artist);

        titletv.setText(title);
        artisttv.setText(artist);

        playPauseButton = findViewById(R.id.play_pause_button);
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePlayButton();
            }
        });

    }

    void togglePlayButton() {
        if (playing) {
            playPauseButton.setImageResource(R.drawable.ic_pause_circle_outline_black_48dp);
        } else {
            playPauseButton.setImageResource(R.drawable.ic_play_circle_outline_black_48dp);
        }
        playing = !playing;
    }
}
