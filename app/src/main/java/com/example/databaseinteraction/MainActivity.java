package com.example.databaseinteraction;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText editCodice;
    private EditText editNome;
    private EditText editCognome;
    private Button btnRicerca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCodice = (EditText) findViewById(R.id.editCodice);
        editNome = (EditText) findViewById(R.id.editNome);
        editCognome = (EditText) findViewById(R.id.editCognome);
        //btnRicerca = (Button) findViewById(R.id.ricerca);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onclickBottone(View view) throws IOException {

        String codiceBiglietto = editCodice.getText().toString();
        String nome = editNome.getText().toString();
        String cognome = editCognome.getText().toString();

        if(dataControl(codiceBiglietto, nome, cognome)) {
            new InvioDati(this, codiceBiglietto, nome, cognome).execute("http://172.19.27.76/DemoWebBeacon/ricerca.php?codice=" +
                    codiceBiglietto + "&nome=" + nome + "&cognome=" + cognome);
        }


    }

    public boolean dataControl(String codice, String nome, String cognome){
        if((codice != null) && (!codice.equals(""))){
            if((nome != null) && (!nome.equals(""))){
                if((cognome != null) && (!cognome.equals(""))){
                    return true;
                }
            }
        }
        return false;
    }
}



