package com.chahnez.smsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText phone;
    private EditText message;
    private Button envoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActivity();
    }

    /**
     * initialisations
     */

    private void initActivity() {
        // récupération objets graphiques
        phone = (EditText) findViewById(R.id.textPhone);
        message = (EditText) findViewById(R.id.txtMessage);
        envoi = (Button) findViewById(R.id.btnEnvoi);
        //gestion de l'evenement clic sur bouton envoi
        createOnC1ickEnvoiButton();
    }

    /**
     * clic sur bouton envoi : envoi sms
     */
    private void createOnC1ickEnvoiButton() {
        envoi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phoneNumber = phone.getText().toString();
                String messageText = message.getText().toString();

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, messageText, null, null);
            }
        });

    }
}