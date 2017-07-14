package com.example.luisb.menuopscontextpopup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);

        registerForContextMenu(tvNombre);//nuestro textview esta disponible para levantar menu de contexto
    }

    //vamos a crear un menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);//le pasamos nuestro menu ( el layout)
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

    /*Vamos a crear un menu contextual*/
    /*Cuando mantengas presionado el textview se creara*/
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_contexto,menu);
    }

    /*vamos a capturar el click sobre los elementos de nuestro menu contextual*/
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mEdit:
                //acciones aqui
                Toast.makeText(this,getResources().getString(R.string.text_click_edit),Toast.LENGTH_SHORT).show();
                break;

            case R.id.mDelete:
                //acciones aqui
                Toast.makeText(this,getResources().getString(R.string.text_click_delete),Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);

    }
}
