package com.example.matte.minibet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FourthActivity extends Activity {

    private double n_coins = 0;
    private Button mButton;
    private EditText mEdit;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        mButton = (Button)findViewById(R.id.add_button);
        mEdit = (EditText)findViewById(R.id.add_coins);
        mText = (TextView)findViewById(R.id.coins);

        mText.setText(String.valueOf(n_coins));

        mButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Log.v("EditText", mEdit.getText().toString());
                        double amount = Double.parseDouble(mEdit.getText().toString());
                        n_coins += amount;
                        mText.setText(String.valueOf(n_coins));
                    }
                }
        );
    }
}
