package ohm.softa.a09;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ListView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import ohm.softa.a09.adapter.FighterRecyclerViewAdapter;
import ohm.softa.a09.model.Fighter;
import ohm.softa.a09.model.FighterFactory;
import ohm.softa.a09.adapter.FighterListAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int FIGHTER_COUNT = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FighterFactory fighterFactory = new FighterFactory(this);
        // FighterListAdapter fighterListAdapter = new FighterListAdapter(this);

        final RecyclerView fighterRecyclerView = findViewById(R.id.fighter_list_view);
        // fighterListView.setAdapter(fighterListAdapter);

        List<Fighter> fighters = new LinkedList<>();

        for (int i = 0; i < FIGHTER_COUNT; i++) {
            try {
                fighters.add(fighterFactory.createFighter());
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }

        FighterRecyclerViewAdapter fighterRecyclerViewAdapter = new FighterRecyclerViewAdapter(fighters);

        fighterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fighterRecyclerView.setAdapter(fighterRecyclerViewAdapter);
    }
}
