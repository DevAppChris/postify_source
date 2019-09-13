package com.android.postify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    TextView emojiTextView;
    Button register_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emojiTextView = findViewById(R.id.emojiView);
        int wavingHand_uinicode =0x1F917;
        emojiTextView.setText(getEmojiByUnicode(wavingHand_uinicode));
        register_btn = findViewById(R.id.register_button);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "Server-Status: offline ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}
