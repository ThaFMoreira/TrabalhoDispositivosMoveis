package com.example.listadedesejos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Inserir extends AppCompatActivity {

    Button salvar;
    ArrayList<Desejo> listaDesejos;
    EditText produto;
    EditText categoria;
    EditText precoMin;
    EditText precoMax;
    EditText lojas;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);
        this.listaDesejos = (ArrayList<Desejo>) getIntent().getSerializableExtra("ListaDesejos");
        if (this.listaDesejos == null) {
            this.listaDesejos = new ArrayList<Desejo>();
        }
        this.id =0;
        //pegar o próximo id
        for(Desejo d: this.listaDesejos){
            if(d.getId()> this.id){
                this.id = d.getId();
            }
        }
        this.id ++;

        salvar = findViewById(R.id.salvar);
        produto= findViewById(R.id.editText);
        categoria= findViewById(R.id.editText2);
        precoMin = findViewById(R.id.editText3);
        precoMax= findViewById(R.id.editText4);
        lojas= findViewById(R.id.editText5);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Desejo d = new Desejo(id, produto.getText().toString(), categoria.getText().toString(), lojas.getText().toString(), Double.parseDouble(precoMin.getText().toString()), Double.parseDouble(precoMax.getText().toString()));

                listaDesejos.add(d);
                intent.putExtra("ListaDesejos", listaDesejos);
                startActivity(intent);
            }
        });
    }
}
