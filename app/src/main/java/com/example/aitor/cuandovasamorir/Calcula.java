package com.example.aitor.cuandovasamorir;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;


public class Calcula extends AppCompatActivity {



    public static boolean stringIsNullOrEmpty (String cadena)

    {
        return (cadena == null || cadena.length()==0);

    }

    public static boolean editTextIsNullOrEmpty (EditText editText)
    {
        return stringIsNullOrEmpty (editText.getText().toString());
    }

    public String fechaMuerte (){
        Random aleatorio;
        aleatorio = new Random();
        Calendar fechaMuerte;

        fechaMuerte = Calendar.getInstance();
        fechaMuerte.set (aleatorio.nextInt(10)+2016, aleatorio.nextInt(12)+1, aleatorio.nextInt(30)+1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        return sdf.format(fechaMuerte.getTime());
    }

    public String escojerCausaMuerte(){
        Random rgenerator = new Random();
        String[] string;
        Resources res = getResources();
        string = res.getStringArray(R.array.muertes);
        String resultado = string[rgenerator.nextInt(string.length)];

        return resultado;
    }
}
