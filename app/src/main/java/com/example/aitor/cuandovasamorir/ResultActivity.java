package com.example.aitor.cuandovasamorir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    Calcula calcula = new Calcula();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String nombre = getIntent().getStringExtra("nombre");
        TextView tvNombre = (TextView) findViewById(R.id.tvNombreResult);
        tvNombre.setText(nombre);

        TextView tvFechaMuerte = (TextView) findViewById(R.id.tvFechaResult);
        tvFechaMuerte.setText(calcula.fechaMuerte());

        TextView tvCausaMuerte = (TextView) findViewById(R.id.tvResultVert);
        tvCausaMuerte.setText(calcula.escojerCausaMuerte());

    }


    @Override
    public void finish() {

        Intent intent = new Intent();
        TextView tvTexto = (TextView) findViewById(R.id.tvFechaResult);
        intent.putExtra("comprobando", tvTexto.getText().toString());
        setResult(this.RESULT_OK, intent);

        super.finish();
    }
}
