package mx.edu.isc.tesoem.hugo4295.ejemploservicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {

    TextView lblcronometro;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lblcronometro = findViewById(R.id.cronometro);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        Cronometro cronometro = new Cronometro(getApplicationContext());

        b1.setOnClickListener(view -> {
            /*cronometro.setView(lblcronometro);*/
            cronometro.nuevo();
        });

        b2.setOnClickListener(view ->{
            cronometro.onDestroy();
        });
    }
}