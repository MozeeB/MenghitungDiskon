package com.example.mozeeb.menghitungdiskon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText harga, diskon;
    Button hitung;
    EditText hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        harga = (EditText)findViewById(R.id.harga_barang);
        diskon = (EditText)findViewById(R.id.dicount);
        hitung = (Button)findViewById(R.id.hitung);
        hasil = (EditText)findViewById(R.id.hasilnya);
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nharga = Integer.parseInt(harga.getText().toString());
                int ndiskon = Integer.parseInt(diskon.getText().toString());
                int diskon = ndiskon * nharga;
                int totaldiskon = diskon / 100;
                int totalbayar = nharga - totaldiskon;
                hasil.setText(String.valueOf(totalbayar));
            }
        });
    }
    public void keluar(View view){
        finish();
    }
}
