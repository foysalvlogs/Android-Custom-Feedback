package com.foysaldev.androidcustomfeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FeedBackActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText EditText1 , EditText2, EditText3;
    MaterialButton button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        EditText1 = findViewById(R.id.Gmailid);
        EditText2 = findViewById(R.id.subjectId);
        EditText3 = findViewById(R.id.detailsId);
        button1 = findViewById(R.id.send_btn);
        button2 = findViewById(R.id.clear_text_btn);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String gmail = EditText1.getText().toString();
        String subject = EditText2.getText().toString();
        String details = EditText3.getText().toString();


        if (view.getId() == R.id.send_btn) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            String[] recipients = {gmail};
            intent.putExtra(Intent.EXTRA_EMAIL, recipients);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, details);
            intent.putExtra(Intent.EXTRA_CC, "SmictFoysal@gmail.com");
            intent.setType("text/html");
            intent.setPackage("com.google.android.gm");
            startActivity(Intent.createChooser(intent, "Send mail"));

        } else if (view.getId() == R.id.clear_text_btn) {
            EditText1.setText("");
            EditText2.setText("");
            EditText3.setText("");
        }
    }
}