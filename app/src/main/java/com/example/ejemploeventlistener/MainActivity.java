package com.example.ejemploeventlistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recupero los elementos des layout
        final TextView etiqueta1 = findViewById(R.id.lbl1);
        final TextView etiqueta2 = findViewById(R.id.lbl2);
        final TextView etiqueta3 = findViewById(R.id.lbl3);
        final TextView etiqueta4 = findViewById(R.id.lbl4);


        final EditText texto = findViewById(R.id.et);

        //Defino el evenbt listener TextChangeListener
        texto.addTextChangedListener(new TextWatcher() {
            //Metodo que se lanza antes de cambiar al texto
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                etiqueta1.setText(charSequence.toString());

                //Este metodo es llamado para notificar que desntro de charSequence, count caracteres
                //a partir de start va a ser reemplazados por nuevo texto cuya longitud es after
                etiqueta3.setText(charSequence.toString() + " start: " + start + " count: " + count + " after: " + after);
            }

            //Metodo que se lanza cuando el texto cambia
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                etiqueta2.setText(charSequence.toString());

                etiqueta4.setText(charSequence.toString() + " start: " + start + " before: " + before + " count: " + count);
            }

            //No hacemos nada
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void onCLick(View view) {
        final TextView etiqueta5 = findViewById(R.id.lbl5);
        int id = view.getId();

        if(id == R.id.btnAceptar) {
            etiqueta5.setText("Aceptar");
        } else if (id == R.id.btnCancelar) {
            etiqueta5.setText("Cancelar");
        }

        /*Mas eficiente pero no funciona
        
        switch (view.getId()){
            case R.id.btnAceptar:
                // Código
                break;
            case R.id.btnCancelar:
                // Código
                break;
        }*/

    }
}