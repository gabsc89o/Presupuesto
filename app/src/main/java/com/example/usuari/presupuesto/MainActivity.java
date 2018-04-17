package com.example.usuari.presupuesto;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvshow;
    RadioGroup rgmem;
    CheckBox chkimp, chkmon;
    String fecha="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvshow = (TextView) this.findViewById(R.id.tvShow);
        rgmem = (RadioGroup) this.findViewById(R.id.rgmemoria);
        chkimp = (CheckBox) this.findViewById(R.id.chkImpresora);
        chkmon = (CheckBox) this.findViewById(R.id.chkMonitor);
    }
    public void fecha(View v){
            new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    fecha = day+"/"+(month+1)+"/"+year;
                }
            },2018,2,13).show();
    }
    @SuppressLint("ResourceType")
    public void calcular(View v){
        int base = 500;
        int memoria = rgmem.getCheckedRadioButtonId();
        String mem="",print="",monitor="";
        int m=0,p=0,n=0;
        switch (memoria){
            case R.id.rd8:
                //tvshow.setText("8 gb");
                mem = "8 gb";
                base += 25;
                m=25;
                break;
            case R.id.rd16:
                //tvshow.setText("16 gb");
                mem = "16 gb";
                base += 50;
                m=50;
                break;
            case R.id.rd32:
                //tvshow.setText("32 gb");
                mem = "32 gb";
                base += 100;
                m=100;
                break;
        }
        if(chkimp.isChecked()) {
            //tvshow.setText("impresora");
            print = "impresora";
            base += 200;
            p=200;
        }
        if(chkmon.isChecked()) {
            //tvshow.setText("monitor");
            monitor = "monitor";
            base += 100;
            n=100;
        }
        if(fecha == "")
            tvshow.setText("Seleccionar Fecha...");
        else
            tvshow.setText("Fecha de envio: "+fecha+" memoria: "+mem+" "+m+" impresora: "+print+" "+p+" monitor: "+monitor+" "+n+" TOTAL= "+base);
    }
}
