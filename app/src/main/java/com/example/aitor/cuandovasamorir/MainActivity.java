package com.example.aitor.cuandovasamorir;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends Activity implements OnClickListener, DatePickerDialog.OnDateSetListener {


    private EditText fromDateEtxt;
    private DatePickerDialog fromDatePickerDialog;
    public final int REQUEST_CODE = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            /* Inicializamos el EditText y pedimos el focus */
        fromDateEtxt = (EditText) findViewById(R.id.fecha_nacimiento);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();
        fromDateEtxt.setFocusable(false);

            /* Ponemos el Listener al EditText */
        fromDateEtxt.setOnClickListener(this);

            /* Creamos el DatePickerDialog a partir de la fechaActual */
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, this, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        Button btnCalcular = (Button) findViewById(R.id.btnComprueba);
        btnCalcular.setOnClickListener(this);
    }




    @Override
    public void onClick(View view) {
        if(view == fromDateEtxt) {
            fromDatePickerDialog.show();
        }else {
            Intent intent = new Intent(this, ResultActivity.class);

            if (view.getId() == R.id.btnComprueba) {
                EditText etNombre = (EditText) findViewById(R.id.etNombre);
                EditText etLugarNac = (EditText) findViewById(R.id.etLugarNac);
                EditText etFechaNac = (EditText) findViewById(R.id.fecha_nacimiento);

                if (!Calcula.editTextIsNullOrEmpty(etNombre) && !Calcula.editTextIsNullOrEmpty(etLugarNac)
                        && !Calcula.editTextIsNullOrEmpty(etFechaNac)) {

                    String stringNombre = etNombre.getText().toString();
                    intent.putExtra("nombre", stringNombre);

                    startActivityForResult(intent, REQUEST_CODE);

                } else {
                    if (Calcula.editTextIsNullOrEmpty(etLugarNac)){
                        Toast.makeText(this, "Falta tu lugar de nacimeinto", Toast.LENGTH_SHORT).show();
                        etLugarNac.requestFocus();
                    }
                    if (Calcula.editTextIsNullOrEmpty(etNombre)){
                        Toast.makeText(this, "Falta tu nombre", Toast.LENGTH_SHORT).show();
                        etNombre.requestFocus();
                    }
                    if (Calcula.editTextIsNullOrEmpty(etFechaNac)){
                        Toast.makeText(this, "Falta tu fecha de nacimeinto", Toast.LENGTH_SHORT).show();
                        etFechaNac.requestFocus();
                    }
                }
            }
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


        Calendar newDate = Calendar.getInstance();
        newDate.set(year, month, dayOfMonth);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if ((requestCode == this.REQUEST_CODE) && (resultCode == RESULT_OK))
        {
            Button btnCallActivity = (Button) findViewById (R.id.btnComprueba);
            btnCallActivity.setText (data.getStringExtra("comprobando"));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
