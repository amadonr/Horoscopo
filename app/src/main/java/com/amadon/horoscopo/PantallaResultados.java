package com.amadon.horoscopo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;


public class PantallaResultados extends ActionBarActivity {

    private int mes,dia;
    private ImageView imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_resultados);

        // OCULTAR BARRA DE NOTIFICACIONES
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        this.imagen=(ImageView)findViewById(R.id.imageViewHoroscopo);

        Bundle b= this.getIntent().getExtras();
        mes=b.getInt("mes");
        dia=b.getInt("dia");

        proceso(mes,dia);
    }

    public void proceso(int mes,int dia){
        //Condicional, signo zodiacal Aries (21/3 - 20/4)
        if((mes == 3 && dia >= 21) || (mes == 4 && dia <=20))
            imagen.setImageResource(R.drawable.aries);

            //Condicional, signo zodiacal Tauro (21/4 - 21/5)
        else if((mes == 4 && dia >=21) || (mes == 5 && dia <= 21))
            imagen.setImageResource(R.drawable.tauro);

            //Condicional, signo zodiacal Géminis (22/5 - 21/6)
        else if((mes == 5 && dia >= 5) || (mes == 6 && dia <= 21))
            imagen.setImageResource(R.drawable.geminis);

            //Condicional, signo zodiacal Cáncer (21/6 - 23/7)
        else if((mes == 6 && dia >= 21) || (mes == 7 && dia <= 23))
            imagen.setImageResource(R.drawable.cancer);

            //Condicional signo zodiacal Leo (24/7 - 23/8)
        else if((mes == 7 && dia >= 24) || (mes == 8 && dia <= 23))
            imagen.setImageResource(R.drawable.leo);

            //Condicional signo zodiacal Virgo (24/8 - 23/9)
        else if((mes == 8 && dia >= 24) || (mes == 9 && dia <= 23))
            imagen.setImageResource(R.drawable.virgo);

            //Condicional signo zodiacal Libra (24/9 - 23/10)
        else if((mes == 9 && dia >= 24) || (mes == 10 && dia <= 23))
            imagen.setImageResource(R.drawable.libra);

            //Condicional signo zodiacal Escorpio (24/10 - 22/11)
        else if((mes == 10 && dia >= 24) || (mes == 11 && dia <= 22))
            imagen.setImageResource(R.drawable.ecorpion);

            //Condicional signo zodiacal Sagitario (23/11 - 21/12)
        else if((mes == 11 && dia >= 23) || (mes == 12 && dia <= 21))
            imagen.setImageResource(R.drawable.sagitario);

            //Condicional signo zodiacal Capricornio (22/12 - 20/1)
        else if((mes == 12 && dia >= 22) || (mes == 1 && dia <= 20))
            imagen.setImageResource(R.drawable.capricornio);

            //Condiconal signo zodiacal Acuario (21/1 - 19/2)
        else if((mes == 1 && dia >= 21) || (mes == 2 && dia <= 19))
            imagen.setImageResource(R.drawable.acuario);

            //Condicional signo zodiacal Piscis (20/2 - 20/3)
        else if((mes == 2 && dia >= 20) || (mes == 3 && dia <= 20))
            imagen.setImageResource(R.drawable.piscis);
    }









   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pantalla_resultados, menu);
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
