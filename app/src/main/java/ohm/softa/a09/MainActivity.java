package ohm.softa.a09;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;

import ohm.softa.a09.model.FighterFactory;
import ohm.softa.a09.adapter.FighterListAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int FIGHTER_COUNT = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FighterFactory fighterFactory = new FighterFactory(this);
        FighterListAdapter fighterListAdapter = new FighterListAdapter(this);

        final ListView fighterListView = findViewById(R.id.fighter_list_view);
        fighterListView.setAdapter(fighterListAdapter);

        for (int i = 0; i < FIGHTER_COUNT; i++) {
            fighterListAdapter.add(fighterFactory.createFighter());
        }
    }
}
