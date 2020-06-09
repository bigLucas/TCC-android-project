package com.example.tcc_pro_v02.OpenActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tcc_pro_v02.ManagementLogicFile;
import com.example.tcc_pro_v02.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpenActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> files = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        recyclerView = findViewById(R.id.recyclerView);
        this.files.addAll(Arrays.asList(getApplicationContext().fileList()));
        Adapter adapter = new Adapter(files);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener (
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                String file = files.get(position);
                                Toast.makeText(getApplicationContext(),"Arquivo " + file + " selecionado", Toast.LENGTH_SHORT).show();
                                ManagementLogicFile managementLogicFile = new ManagementLogicFile(getApplicationContext());
                                String content = managementLogicFile.read(file);
                                Intent result = new Intent();
                                result.putExtra("content", content);
                                setResult(RESULT_OK, result);
                                finish();
                            }
                            @Override
                            public void onLongItemClick(View view, int position) {}
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {}
                        }
                        )
                );
    }
}
