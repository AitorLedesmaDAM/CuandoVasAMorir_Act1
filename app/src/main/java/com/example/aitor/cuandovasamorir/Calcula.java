package com.example.aitor.cuandovasamorir;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;


public class Calcula  {

    private Context context;

        /* Creamos constructor de context */
    public Calcula(Context context) {

        this.context = context;
    }

        /* Comprobamos si una cadena esta vacía */
    public static boolean stringIsNullOrEmpty (String cadena) {
        return (cadena == null || cadena.length()==0);

    }

        /* Comprobamos si un editText está vacío o lleno */
    public static boolean editTextIsNullOrEmpty (EditText editText)
    {
        return stringIsNullOrEmpty (editText.getText().toString());
    }

        /* Creamos una fecha futura aleatoria */
    public String fechaMuerte (){
        Random aleatorio;
        aleatorio = new Random();
        Calendar fechaMuerte;

        fechaMuerte = Calendar.getInstance();
        fechaMuerte.set (aleatorio.nextInt(50)+2016, aleatorio.nextInt(12)+1, aleatorio.nextInt(30)+1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        return sdf.format(fechaMuerte.getTime());
    }
        /* Seleccionamos una cadena de una array de String */
    public String escojerCausaMuerte(){
        Random rgenerator = new Random();
        String[] string;
        Resources res = context.getResources();
        string = res.getStringArray(R.array.muertes);
        String resultado = string[rgenerator.nextInt(string.length)];

        return resultado;
    }
}
