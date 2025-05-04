package com.example.searchview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayAdapter<String> Adapter;
    ArrayList<String> namelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        searchView=findViewById(R.id.searchView);
        listView=findViewById(R.id.listView);

        namelist=new ArrayList<>();
        namelist.add("mafi");
        namelist.add("mafi2");
        namelist.add("Rahim");
        namelist.add("karim");
        namelist.add("sadia");

        Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,namelist);
        listView.setAdapter(Adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Adapter.getFilter().filter(newText);
                return false;
            }
        });

    }
}