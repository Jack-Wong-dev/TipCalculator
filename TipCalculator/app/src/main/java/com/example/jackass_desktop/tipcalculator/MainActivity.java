package com.example.jackass_desktop.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;




public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity ";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonCompute = (Button)findViewById(R.id.buttonCompute);
        final EditText checkAmountValue = (EditText)findViewById(R.id.checkAmountValue);
        final EditText partySizeValue   = (EditText)findViewById(R.id.partySizeValue);


        buttonCompute.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        int tipResult15, tipResult20, tipResult25;
                        int totalResult15, totalResult20, totalResult25;
                        int party;
                        double check;


                        TextView fifteenPercentTipValue   =(TextView)findViewById(R.id.fifteenPercentTipValue);
                        TextView fifteenPercentTotalValue =(TextView)findViewById(R.id.fifteenPercentTotalValue);

                        TextView twentyPercentTipValue   =(TextView)findViewById(R.id.twentyPercentTipValue);
                        TextView twentyPercentTotalValue =(TextView)findViewById(R.id.twentyPercentTotalValue);

                        TextView twentyfivePercentTipValue   =(TextView)findViewById(R.id.twentyfivePercentTipValue);
                        TextView twentyfivePercentTotalValue =(TextView)findViewById(R.id.twentyfivePercentTotalValue);

                        if ((checkAmountValue.getText().toString().isEmpty()) || (partySizeValue.getText().toString().isEmpty())) {
                            Toast.makeText(MainActivity.this, "No input", Toast.LENGTH_LONG).show();
                        }

                        else if (   ((Integer.parseInt(partySizeValue.getText().toString()))== 0)) //||
                                   // ((Double.parseDouble(checkAmountValue.getText().toString()))== 0.0)   )

                        {
                            Toast.makeText(MainActivity.this, "Division by Zero Error", Toast.LENGTH_LONG).show();
                        }

                        else {

                            check = Double.parseDouble(checkAmountValue.getText().toString());
                            party = Integer.parseInt(partySizeValue.getText().toString());


                            tipResult15 = (int) (Math.round((check * 0.15) / party));
                            totalResult15 = (int) (Math.round((check / party) + tipResult15));

                            tipResult20 = (int) (Math.round((check * 0.20) / party));
                            totalResult20 = (int) (Math.round((check / party) + tipResult20));

                            tipResult25 = (int) (Math.round((check * 0.25) / party));
                            totalResult25 = (int) (Math.round((check / party) + tipResult25));


                            fifteenPercentTipValue.setText("" + tipResult15);
                            fifteenPercentTotalValue.setText("" + totalResult15);

                            twentyPercentTipValue.setText("" + tipResult20);
                            twentyPercentTotalValue.setText("" + totalResult20);

                            twentyfivePercentTipValue.setText("" + tipResult25);
                            twentyfivePercentTotalValue.setText("" + totalResult25);

                        }
                    }
                }


        );


    }


}
