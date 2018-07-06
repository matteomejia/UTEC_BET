package com.example.matte.minibet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OnClickListenerCreateBet implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        final Context context= view.getRootView().getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.bet_input_form, null, false);
        final EditText editTextCountry = (EditText) formElementsView.findViewById(R.id.editTextCountry);
        final EditText editTextCountryAmount = (EditText) formElementsView.findViewById(R.id.editTextCountryAmount);
        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("BET")
                .setPositiveButton("Add",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String betCountry = editTextCountry.getText().toString();
                                String amount= editTextCountryAmount.getText().toString();
                                int betAmount = Integer.parseInt(amount);
                                ObjectBet objectBet = new ObjectBet();
                                objectBet.betCountry= betCountry;
                                objectBet.betAmount = betAmount;
                                //context es final?
                                boolean createSuccessful = new TableControllerBet(context).create(objectBet);
                                if(createSuccessful){
                                    Toast.makeText(context, "Bet information was saved.", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Unable to save bet information.", Toast.LENGTH_SHORT).show();
                                }
                                ((ThirdActivity) context).readRecords();
                                dialog.cancel();


                            }
                        }).show();

    }
}
