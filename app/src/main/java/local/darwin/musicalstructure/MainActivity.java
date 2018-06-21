package local.darwin.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songs = new ArrayList<>();
        populateList();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SongAdapter(songs);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemListener(this.getApplicationContext(),
                new RecyclerItemListener.RecyclerTouchListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(), PlayingActivity.class);
                        intent.putExtra("title", songs.get(position).getTitle());
                        intent.putExtra("artist", songs.get(position).getArtist());
                        startActivity(intent);
                    }
                }));
    }

    void populateList() {
        songs.add(new Song("Stairway to Heaven", "ACDC"));
        songs.add(new Song("Tik Tok", "Kesha"));
    }
}
