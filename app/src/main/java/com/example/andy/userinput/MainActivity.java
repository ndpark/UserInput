package com.example.andy.userinput;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int numberCoffee = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(numberCoffee);
        displayPrice(numberCoffee * 5);
    }

    public void increment(View view){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        numberCoffee++;
        quantityTextView.setText(Integer.toString(numberCoffee));
        displayPrice(numberCoffee * 5);
    }

    public void decrement(View view){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        numberCoffee--;
        quantityTextView.setText(Integer.toString(numberCoffee));
        if(getPrice(numberCoffee) < 0 ){
            toast.show();
        } else{
            displayPrice(getPrice(numberCoffee));
        }


    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private int getPrice(int numberCoffee){
        return numberCoffee * 5;
    }

    public class Warning extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.dialog_fire_missiles)
                    .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }

}
