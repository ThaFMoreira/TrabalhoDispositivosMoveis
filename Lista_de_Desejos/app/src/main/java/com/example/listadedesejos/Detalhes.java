package com.example.listadedesejos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Detalhes extends AppCompatActivity {

    FloatingActionButton btnEditar;
    FloatingActionButton btnRemover;
    ArrayList<Desejo> listaDesejos;
    Desejo desejo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        this.listaDesejos = (ArrayList<Desejo>) getIntent().getSerializableExtra("ListaDesejos");
        this.desejo = (Desejo) getIntent().getSerializableExtra("DesejoDetalhes");
        TextView produto = findViewById(R.id.textView2);
        TextView categoria = findViewById(R.id.textView4);
        TextView precoMin = findViewById(R.id.textView6);
        TextView precoMax = findViewById(R.id.textView8);
        TextView lojas = findViewById(R.id.textView10);
        produto.setText(this.desejo.getProduto());
        categoria.setText(this.desejo.getCategoria());
        precoMin.setText("R$ " + String.valueOf(this.desejo.getPrecoMin()));
        precoMax.setText("R$ " + String.valueOf(this.desejo.getPrecomax()));
        lojas.setText(this.desejo.getLojas());

        btnRemover = findViewById(R.id.btnRemover);
        btnEditar = findViewById(R.id.btnEditar);

        btnRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indiceRemover = 0;
                for (Desejo d: listaDesejos) {
                    if (d.getId() == desejo.getId()){
                        break;
                    }
                    indiceRemover++;
                }
                listaDesejos.remove(indiceRemover);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ListaDesejos", listaDesejos);
                startActivity(intent);
            }
        });
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Alterar.class);
                intent.putExtra("ListaDesejos", listaDesejos);
                intent.putExtra("DesejoEditar", desejo);
                startActivity(intent);
            }
        });
    }


}
