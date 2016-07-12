package com.aupadhyay.intentandbundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String EMAIL = "email";
    private static final String PHONE = "phone";

    private TextView emailTextView, phoneTextView;
    private Button goBackButton;
    private String em, ph;

    public void setViews()
    {
        emailTextView = (TextView) findViewById(R.id.emailTextView);
        phoneTextView = (TextView) findViewById(R.id.phoneTextView);
        goBackButton = (Button)findViewById(R.id.goBackButton);

        Intent rcv = getIntent();

        String em = rcv.getStringExtra("email");
        String ph = rcv.getStringExtra("phone");

        emailTextView.setText(em);
        phoneTextView.setText(ph);

        goBackButton.setOnClickListener(this);
    }

    public void getDetailsUsingBundle()
    {
        Bundle bundle = getIntent().getExtras();
        em = bundle.getString(EMAIL);
        ph = bundle.getString(PHONE);
    }

    public void getDetailsUsingIntent()
    {
        Intent rcv = getIntent();

        em = rcv.getStringExtra(EMAIL);
        ph = rcv.getStringExtra(PHONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //getDetailsUsingIntent();
        getDetailsUsingBundle();
        setViews();
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
