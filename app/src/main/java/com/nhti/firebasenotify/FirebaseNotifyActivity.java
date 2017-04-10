package com.nhti.firebasenotify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FirebaseNotifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_notify);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            TextView textView = (TextView) findViewById(R.id.myTextView);
            textView.setText(bundle.getString("MyKey1"));
        }
    }
}
