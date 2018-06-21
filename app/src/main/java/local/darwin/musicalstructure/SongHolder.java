package local.darwin.musicalstructure;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class SongHolder extends RecyclerView.ViewHolder {
    private TextView title, artist;
    private Song song;

    SongHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.song_title);
        artist = itemView.findViewById(R.id.song_artist);
    }

    void setSong(Song song) {
        this.song = song;
        title.setText(song.getTitle());
        artist.setText(song.getArtist());
    }
}
