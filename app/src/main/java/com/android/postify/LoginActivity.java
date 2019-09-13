package com.android.postify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView emoji_view, switch_to_regiser;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emoji_view = findViewById(R.id.emoji_textview);
        int wavingHand_uinicode =0x1F44B;
        emoji_view.setText(getEmojiByUnicode(wavingHand_uinicode));
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
                Toast.makeText(LoginActivity.this, "Noch nicht verfügbar!"+getEmojiByUnicode( 0x1F609), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}
