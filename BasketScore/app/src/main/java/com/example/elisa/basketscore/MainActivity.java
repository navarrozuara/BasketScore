package com.example.elisa.basketscore;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnEnviar;
    EditText equipo1, equipo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        equipo1 = (EditText) findViewById(R.id.equipo1);
        equipo2 = (EditText) findViewById(R.id.equipo2);
        btnEnviar = (Button) findViewById(R.id.button);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BasketActivity.class);
                Bundle bundle1 = new Bundle();
                Bundle bundle2 = new Bundle();
                bundle1.putString("LOCAL", equipo1.getText().toString());
                bundle2.putString("VISITANTE", equipo2.getText().toString());
                intent.putExtras(bundle1);
                intent.putExtras(bundle2);
                startActivity(intent);
            }
        });
    }

}
