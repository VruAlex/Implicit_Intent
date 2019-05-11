package com.example.vrushabh.implicit_intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText subject;
    EditText too;
    Button button;

    TextView textView;
    TextView copyText;
    private ClipboardManager clipboardManager;
    private ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subject = findViewById(R.id.Subject);
        too = findViewById(R.id.To);
        button = findViewById(R.id.SendButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{too.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it, "Choose Gmail App"));
            }
        });


        textView = (TextView) findViewById(R.id.textView);
        copyText = (Button) findViewById(R.id.copy);
        copyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label","https://youtu.be/yFmf6e4OH_8");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Data Copied to Clipboard", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void you(View view) {
        Intent Intent = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("https://www.youTube.com"));
        startActivity(Intent);
        Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
    }



}
