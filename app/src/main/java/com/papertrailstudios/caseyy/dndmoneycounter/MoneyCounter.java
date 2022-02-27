package com.papertrailstudios.caseyy.dndmoneycounter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MoneyCounter extends AppCompatActivity {

    int total = 0;
    boolean platBool = true;
    boolean elecBool = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_counter);

        //Make variables for the buttons
        Button addButton = findViewById( R.id.addButton );
        Button subButton = findViewById( R.id.subButton );
        Button emptyButton = findViewById( R.id.emptyButton );
        FloatingActionButton clearButton = findViewById( R.id.clearButton );

        //Listener for the add button
        addButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Bring in all the text fields
                EditText platNumEditText = findViewById( R.id.platNumEditText );
                EditText goldNumEditText = findViewById( R.id.goldNumEditText );
                EditText elecNumEditText = findViewById( R.id.elecNumEditText );
                EditText silvNumEditText = findViewById( R.id.silvNumEditText );
                EditText coppNumEditText = findViewById( R.id.coppNumEditText );

                // Create variables to hold the value entered into the text fields
                // This is needed because a blank field doesn't default to 0 when parsed into an
                // int and I want that to happen. So I have to do it manually.
                int copp, silv, elec, gold, plat;
                if( coppNumEditText.getText().toString().equals("") ){
                    copp = 0;
                } else {
                    copp = Integer.parseInt( coppNumEditText.getText().toString() );
                }
                if( silvNumEditText.getText().toString().equals("") ){
                    silv = 0;
                } else {
                    silv = Integer.parseInt( silvNumEditText.getText().toString() );
                }
                if( elecNumEditText.getText().toString().equals("") ){
                    elec = 0;
                } else {
                    elec = Integer.parseInt( elecNumEditText.getText().toString() );
                }
                if( goldNumEditText.getText().toString().equals("") ){
                    gold = 0;
                } else {
                    gold = Integer.parseInt( goldNumEditText.getText().toString() );
                }
                if( platNumEditText.getText().toString().equals("") ) {
                    plat = 0;
                } else {
                    plat = Integer.parseInt( platNumEditText.getText().toString() );
                }

                // Find the value put into the calculator
                // newNum adds up the values of the text fields
                int newNum = copp + ( silv * 10 ) + ( elec * 50 ) + ( gold * 100 ) + ( plat * 1000 );
                //System.out.println( newNum );

                // Run the operation
                total = total + newNum;
                //System.out.println( total );

                // Output the value into the currentTextView text field
                updateDisplay();

                // Clear the text fields
                platNumEditText.getText().clear();
                goldNumEditText.getText().clear();
                elecNumEditText.getText().clear();
                silvNumEditText.getText().clear();
                coppNumEditText.getText().clear();
            }
        });

        //Listener for the subtract button
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Bring in all the text fields
                EditText platNumEditText = findViewById( R.id.platNumEditText );
                EditText goldNumEditText = findViewById( R.id.goldNumEditText );
                EditText elecNumEditText = findViewById( R.id.elecNumEditText );
                EditText silvNumEditText = findViewById( R.id.silvNumEditText );
                EditText coppNumEditText = findViewById( R.id.coppNumEditText );

                // Create variables to hold the value entered into the text fields
                // This is needed because a blank field doesn't default to 0 when parsed into an
                // int and I want that to happen. So I have to do it manually.
                int copp, silv, elec, gold, plat;
                if( coppNumEditText.getText().toString().equals("") ){
                    copp = 0;
                } else {
                    copp = Integer.parseInt( coppNumEditText.getText().toString() );
                }
                if( silvNumEditText.getText().toString().equals("") ){
                    silv = 0;
                } else {
                    silv = Integer.parseInt( silvNumEditText.getText().toString() );
                }
                if( elecNumEditText.getText().toString().equals("") ){
                    elec = 0;
                } else {
                    elec = Integer.parseInt( elecNumEditText.getText().toString() );
                }
                if( goldNumEditText.getText().toString().equals("") ){
                    gold = 0;
                } else {
                    gold = Integer.parseInt( goldNumEditText.getText().toString() );
                }
                if( platNumEditText.getText().toString().equals("") ) {
                    plat = 0;
                } else {
                    plat = Integer.parseInt( platNumEditText.getText().toString() );
                }

                // Find the value put into the calculator
                // newNum adds up the values of the text fields
                int newNum = copp + ( silv * 10 ) + ( elec * 50 ) + ( gold * 100 ) + ( plat * 1000 );
                //System.out.println( newNum );

                //Run the operation
                if (total > newNum){
                    total = total - newNum;
                } else {
                    total = 0;
                }
                //System.out.println( total );

                //Output the value into the currentTextView text field
                updateDisplay();

                // Clear the text fields
                platNumEditText.getText().clear();
                goldNumEditText.getText().clear();
                elecNumEditText.getText().clear();
                silvNumEditText.getText().clear();
                coppNumEditText.getText().clear();
            }
        });

        emptyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = 0;
                updateDisplay();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Bring in all the text fields
                EditText platNumEditText = findViewById( R.id.platNumEditText );
                EditText goldNumEditText = findViewById( R.id.goldNumEditText );
                EditText elecNumEditText = findViewById( R.id.elecNumEditText );
                EditText silvNumEditText = findViewById( R.id.silvNumEditText );
                EditText coppNumEditText = findViewById( R.id.coppNumEditText );

                // Clear the text fields
                platNumEditText.getText().clear();
                goldNumEditText.getText().clear();
                elecNumEditText.getText().clear();
                silvNumEditText.getText().clear();
                coppNumEditText.getText().clear();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item.setChecked(!item.isChecked());
        switch (item.getItemId()){
            case R.id.platSwitch:
                platBool = item.isChecked();
                break;
            case R.id.elecSwitch:
                elecBool = item.isChecked();
        }
        updateDisplay();
        return super.onOptionsItemSelected(item);
    }

    protected void updateDisplay() {
        // Bring in the TextView that will display the value
        TextView currentTextView = findViewById( R.id.currentTextView );

        // Check which buttons are checked
        if ( platBool && elecBool ) {
            // Update the TextView
            currentTextView.setText(String.format(Locale.US, "%dp %dg %de %ds %dc",
                    total / 1000, (total % 1000) / 100, (total % 100) / 50, (total % 50) / 10, total % 10 ));
        } else if ( platBool ) {
            // Update the TextView
            currentTextView.setText(String.format(Locale.US, "%dp %dg %ds %dc",
                    total / 1000, (total % 1000) / 100, (total % 100) / 10, total % 10 ));
        } else if ( elecBool ) {
            // Update the TextView
            currentTextView.setText(String.format(Locale.US, "%dg %de %ds %dc",
                     total / 100, (total % 100) / 50, (total % 50) / 10, total % 10 ));
        } else {
            // Update the TextView
            currentTextView.setText(String.format(Locale.US, "%dg %ds %dc",
                    total / 100, (total % 100) / 10, total % 10 ));
        }

    }
}
