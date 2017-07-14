package com.example.luisb.menuopscontextpopup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //vamos a crear un menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);//le pasamos nuestro menu (todo el layout)
        return true;
    }

    /*Vamos a darle movimiento,
    * Aqui defino que hacer cuando se seleccione uno de los items*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //comapramos que seleccionaron
        switch (item.getItemId()){//me devolvera el id del item seleccionado

            case R.id.mAbout:
                Intent intento = new Intent(this, ActivityAbout.class);
                startActivity(intento);
                break;

            case R.id.mSettings:
                Intent i = new Intent(this, ActivitySettings.class);
                startActivity(i);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
