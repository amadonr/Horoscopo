package com.amadon.horoscopo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.Date;


public class Principal extends ActionBarActivity  implements  NumberPicker.OnValueChangeListener{


    private NumberPicker mes;
    private NumberPicker dia;
    private int mesNum;
    private int diaNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        // OCULTAR BARRA DE NOTIFICACIONES
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Enlazando los controles
        this.mes=(NumberPicker)findViewById(R.id.numberPickerMes);
        this.dia=(NumberPicker)findViewById(R.id.numberPickerDia);

        //valor minimo y max del mes
        mes.setMinValue(0);
        mes.setMaxValue(11);

        //String con 12 valores a mostrar
        mes.setDisplayedValues(new String [] {"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep",
                                                "Oct","Nov","Dic"} );

        //metodo listener para observar los cambios en el objeto mes
        mes.setOnValueChangedListener(this);

        //valor minimo y max dia
        dia.setMaxValue(31);
        dia.setMinValue(1);
    }
        public void onValueChange (NumberPicker mes, int oldVal, int newVal){
            if(mes.getDisplayedValues()[newVal].equals("Abr")
                    || mes.getDisplayedValues()[newVal].equals("Jun")
                    || mes.getDisplayedValues()[newVal].equals("Sep")
                    || mes.getDisplayedValues()[newVal].equals("Nov")){
                dia.setMaxValue(30);
            }
            else if(mes.getDisplayedValues()[newVal].equals("Feb")){
                dia.setMaxValue(29);
            }
            else{
                dia.setMaxValue(31);
            }
        }
    public void comprueba(View v){

        mesNum=mes.getValue()+1; // le sumamos uno para que vaya del 1 al 12 y no del 0 al 11
        diaNum=dia.getValue();

        /*creacion del objeto intent al que pasamos una referencia de la
        actividad que llama (Principal.this)  y por otro lado, la clase de la actividad a la
        que queremos llamar (PantallaResultados.class)*/
         /*Este intent se encargara de pasar la informacion entre actividades*/

        Intent itn = new Intent(Principal.this, PantallaResultados.class);


        /*preparamos un objeto bundle con la informacion que le pasaremos al intent
          en este caso es un String, por lo que usamos el metodo putString
          al que pasamos como argumento una clave para identificarlo("fech")
          y la variable fecha en la que habiamos almacenado la fecha*/

        Bundle bndl=new Bundle();
        bndl.putInt("mes", this.mesNum);
        bndl.putInt("dia", this.diaNum);

        /*ahora añadimos al intent ese bundle con la informacion*/

        itn.putExtras(bndl);

        /*Y por fin iniciamos la nueva actividad (otra pantalla)
        pasandole en intent como parametro*/

        startActivity(itn);
    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
