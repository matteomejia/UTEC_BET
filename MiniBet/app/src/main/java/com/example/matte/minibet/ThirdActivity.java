package com.example.matte.minibet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button buttonBet = (Button) findViewById(R.id.buttonBet);
        buttonBet.setOnClickListener(new OnClickListenerCreateBet());
        countRecords();
        readRecords();
    }

    public void countRecords() {
        int recordCount = new TableControllerBet(this).count();
        TextView textViewRecordCount = (TextView) findViewById(R.id.textViewRecordCount);
        textViewRecordCount.setText(recordCount + " records found.");
    }

    public void readRecords() {

        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();

        List<ObjectBet> bets = new TableControllerBet(this).read();

        if (bets.size() > 0) {

            for (ObjectBet obj : bets) {

                int id = obj.id;
                String betCountry = obj.betCountry;
                int betAmount = obj.betAmount;

                String textViewContents = betCountry + " - " + betAmount;

                TextView textViewBetItem= new TextView(this);
                textViewBetItem.setPadding(0, 10, 0, 10);
                textViewBetItem.setText(textViewContents);
                textViewBetItem.setTag(Integer.toString(id));

                linearLayoutRecords.addView(textViewBetItem);
            }

        }

        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records.");

            linearLayoutRecords.addView(locationItem);
        }

    }



}
