package com.aupadhyay.intentandbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private EditText emailEditText, phoneEditText;
    private Button signinButton;
    private String em, ph;

    public void initViews()
    {
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        phoneEditText = (EditText) findViewById(R.id.PhoneEditText);
        signinButton = (Button) findViewById(R.id.signinButton);

        signinButton.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    public void sendDetailsUsingBundle(Bundle bundle)
    {
        bundle.putString(EMAIL, em);
        bundle.putString(PHONE, ph);
    }

    public void sendDetailsUsingIntent(Intent intent)
    {
        intent.putExtra(EMAIL, em);
        intent.putExtra(PHONE, ph);
    }

    @Override
    public void onClick(View view) {
        em = emailEditText.getText().toString().trim();
        ph = phoneEditText.getText().toString().trim();

        Intent intent = new Intent(this, SecondActivity.class);
        //sendDetailsUsingIntent(intent);


        Bundle bundle = new Bundle();
        sendDetailsUsingBundle(bundle);
        intent.putExtras(bundle); // or intent.putExtra("BUNDLE",bundle); and reveive there : Bundle b = getBundleExtra("BUNDLE");

        startActivity(intent);
    }
}
