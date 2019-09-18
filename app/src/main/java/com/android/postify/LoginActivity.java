package com.android.postify;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.security.keystore.KeyProperties;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

@RequiresApi(api = Build.VERSION_CODES.M)
public class LoginActivity extends AppCompatActivity {
    TextView emoji_view, switch_to_regiser;
    Button login_button;
    ImageView fingerprint_png;

    private static final String KEY_NAME = "yourKey";
    private Cipher cipher;
    private KeyStore keyStore;
    private KeyGenerator keyGenerator;
    private TextView textView;
    private FingerprintManager.CryptoObject cryptoObject;
    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emoji_view = findViewById(R.id.emoji_textview);
        int wavingHand_uinicode = 0x1F44B;
        emoji_view.setText(getEmojiByUnicode(wavingHand_uinicode));
        fingerprint_png = findViewById(R.id.fingerprint);
        fingerprint_png.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Lege deinen Finger auf deinen Scanner um dich einzuloggen", Toast.LENGTH_SHORT).show();
            }
        });
        switch_to_regiser = findViewById(R.id.switch_to_register);
        switch_to_regiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_to_register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(login_to_register);

            }
        });
        login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Noch nicht verfügbar!" + getEmojiByUnicode(0x1F609), Toast.LENGTH_SHORT).show();
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            }
        });

    }
    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }


}
