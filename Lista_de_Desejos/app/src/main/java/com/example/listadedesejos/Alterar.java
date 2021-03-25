package com.example.listadedesejos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Alterar extends AppCompatActivity {
    Button salvar;
    ArrayList<Desejo> listaDesejos;
    Desejo desejo;
    EditText produto;
    EditText categoria;
    EditText precoMin;
    EditText precoMax;
    EditText lojas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        this.listaDesejos = (ArrayList<Desejo>) getIntent().getSerializableExtra("ListaDesejos");
        this.desejo = (Desejo) getIntent().getSerializableExtra("DesejoEditar");
        produto= findViewById(R.id.editText7);
        categoria= findViewById(R.id.editText8);
        precoMin = findViewById(R.id.editText9);
        precoMax= findViewById(R.id.editText10);
        lojas= findViewById(R.id.editText11);
        salvar = findViewById(R.id.button);

        produto.setText(this.desejo.getProduto());
        categoria.setText(this.desejo.getCategoria());
        precoMin.setText(String.valueOf(this.desejo.getPrecoMin()));
        precoMax.setText(String.valueOf(this.desejo.getPrecomax()));
        lojas.setText(this.desejo.getLojas());



        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desejo.setProduto(produto.getText().toString());
                desejo.setCategoria(categoria.getText().toString());
                desejo.setPrecoMin(Double.parseDouble(precoMin.getText().toString()));
                desejo.setPrecomax(Double.parseDouble(precoMax.getText().toString()));
                desejo.setLojas(lojas.getText().toString());

                int indiceAlterar = 0;
                for (Desejo d: listaDesejos) {
                    if (d.getId() == desejo.getId()){
                        break;
                    }
                    indiceAlterar++;
                }
                listaDesejos.set(indiceAlterar, desejo);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ListaDesejos", listaDesejos);
                startActivity(intent);

            }
        });
    }
}
