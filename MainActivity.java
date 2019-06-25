package com.example.petera.penghitungsuhu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
//  Mendeklaraskan variable palette
    Button btn_hitung;
    TextView txt_hasil;
    EditText enter_jumlah;

    DecimalFormat formater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        formater = new DecimalFormat("#0.0");

        btn_hitung = findViewById(R.id.btn_hitung);
        txt_hasil = findViewById(R.id.txt_hasil);
        enter_jumlah = findViewById(R.id.enter_jumlah);

        txt_hasil.setVisibility(View.GONE);

        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enter_jumlah.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Masukan number kerik", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int number = Integer.parseInt(enter_jumlah.getText().toString().trim());

                    double temperature = (number / 3.0) + 4;

                    String hasil = "Perkiraan suhu : " + formater.format(temperature)+ "\tdrajat Celcius";

                    txt_hasil.setText(hasil);
                    txt_hasil.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
