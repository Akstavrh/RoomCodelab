package com.example.android.roomwordsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    final static String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    EditText mNewWordEditText;
    Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_word_layout);
        mNewWordEditText = findViewById(R.id.et_word);

        mSaveButton = findViewById(R.id.button);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mNewWordEditText.getText())){
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mNewWordEditText.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
