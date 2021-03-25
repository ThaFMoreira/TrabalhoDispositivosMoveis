package com.example.listadedesejos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    FloatingActionButton btn;
    ArrayList<Desejo> listaDesejos;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.listaDesejos = (ArrayList<Desejo>) getIntent().getSerializableExtra("ListaDesejos");

        lista= findViewById(R.id.listView);
        btn= findViewById(R.id.btnAdd);

        List<String> items = new ArrayList<String>();
        if (this.listaDesejos != null) {
            for (Desejo item : this.listaDesejos) {
                items.add(item.getProduto());
            }
        }

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Detalhes.class);
                intent.putExtra("ListaDesejos", listaDesejos);
                intent.putExtra("DesejoDetalhes", listaDesejos.get(i));
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Inserir.class);
                intent.putExtra("ListaDesejos", listaDesejos);
                startActivity(intent);
            }
        });

    }
}
