package com.example.elisa.basketscore;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class BasketActivity extends AppCompatActivity {

    ImageButton btnLocal1, btnLocal2, btnLocal3, btnVisita1, btnVisita2, btnVisita3,
            btnLocalDecre, btnVisitaDecre;
    TextView ptsLocal, ptsVisita, txtLocal, txtVisita;
    String msgLocal, msgVisita;
    int contLocal = 0;
    int contVisita = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btnLocal1 = (ImageButton) findViewById(R.id.btnLocal1);
        btnLocal2 = (ImageButton) findViewById(R.id.btnLocal2);
        btnLocal3 = (ImageButton) findViewById(R.id.btnLocal3);

        btnVisita1 = (ImageButton) findViewById(R.id.btnVisita1);
        btnVisita2 = (ImageButton) findViewById(R.id.btnVisita2);
        btnVisita3 = (ImageButton) findViewById(R.id.btnVisita3);

        btnLocalDecre = (ImageButton) findViewById(R.id.btnLocalDecre);
        btnVisitaDecre = (ImageButton) findViewById(R.id.btnVisitaDecre);

        ptsLocal = (TextView) findViewById(R.id.ptsLocal);
        ptsVisita = (TextView) findViewById(R.id.ptsVisita);

        txtLocal = (TextView) findViewById(R.id.txtLocal);
        msgLocal = getMensajeLocal();
        if (!msgLocal.equals(null)) {
            txtLocal.setText(msgLocal);
        }

        txtVisita = (TextView) findViewById(R.id.txtVisita);
        msgVisita = getMensajeVisita();
        if (!msgVisita.equals(null)) {
            txtVisita.setText(msgVisita);
        }

        ptsLocal.setText(Integer.toString(contLocal));
        ptsVisita.setText(Integer.toString(contVisita));

        btnLocal1.setOnClickListener(LocalListener);
        btnLocal2.setOnClickListener(LocalListener);
        btnLocal3.setOnClickListener(LocalListener);
        btnLocalDecre.setOnClickListener(LocalListener);

        btnVisita1.setOnClickListener(VisitaListener);
        btnVisita2.setOnClickListener(VisitaListener);
        btnVisita3.setOnClickListener(VisitaListener);
        btnVisitaDecre.setOnClickListener(VisitaListener);
    }

    private View.OnClickListener LocalListener = new View.OnClickListener() {
        public void onClick(View view) {
            mostrarContLocal();
        }
    };

    private View.OnClickListener VisitaListener = new View.OnClickListener() {
        public void onClick(View view) {
            mostrarContVisita();
        }
    };

    public void mostrarContLocal() {
        if (btnLocal1.isPressed())
            contLocal++;
        else if (btnLocal2.isPressed())
            contLocal += 2;
        else if (btnLocal3.isPressed())
            contLocal += 3;
        else if (btnLocalDecre.isPressed())
            if (contLocal > 0)
                contLocal--;

        ptsLocal.setText(Integer.toString(contLocal));
    }

    private void mostrarContVisita() {
        if (btnVisita1.isPressed())
            contVisita++;
        else if (btnVisita2.isPressed())
            contVisita += 2;
        else if (btnVisita3.isPressed())
            contVisita += 3;
        else if (btnVisitaDecre.isPressed())
            if (contVisita > 0)
                contVisita--;

        ptsVisita.setText(Integer.toString(contVisita));
    }

    public String getMensajeLocal() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                if (intent.hasExtra("LOCAL")) {
                    return bundle.getString("LOCAL");
                }
            }
        }
        return null;
    }

    public String getMensajeVisita() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                if (intent.hasExtra("VISITANTE")) {
                    return bundle.getString("VISITANTE");
                }
            }
        }
        return null;
    }
}
