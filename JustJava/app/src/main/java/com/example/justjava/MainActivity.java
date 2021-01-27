/**
        * IMPORTANT: Make sure you are using the correct package name.
        * This example uses the package name:
        * package com.example.android.justjava
        * If you get an error when copying this code into Android studio, update it to match teh package name found
        * in the project's AndroidManifest.xml file.
        **/

package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;  // Global Var of Quantity Ordered.
    String menuSelected;
    int priceSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called whether the + button or - Button is clicked.
     */
    public void increment(View view) {
        if(quantity ==100){
            // Show an Error Message when User Try to Decrease the Quantity Less than 1
            Toast.makeText(this, "you cant have more than 100 Coffees", Toast.LENGTH_SHORT).show();
            // Exit the Method
            return;
        }
        // prefix increment.
        display(++quantity);
    }
    public void decrement(View view) {
        if(quantity ==1) {
            // Show an Error Message when User Try to Decrease the Quantity More than 100
            Toast.makeText(this, "you cant have less than 1 Coffee", Toast.LENGTH_SHORT).show();
            // Exit the Method
            return;
        }
        // prefix decrement.
            display(--quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        createOrderSummary();
    }


    /**
     * Display the information of the Order Like table number and quantity ordered
     * containing Methods (displayMessage, displayPrice, calculatePrice)
     *
     * @param  - that show the number of the table
     */
    private void createOrderSummary() {
        String quantityR =  getResources().getString(R.string.quantity);  // get the variables from String File For localization and Translation output
        String totalR = getResources().getString(R.string.total);
        String thankYouR = getResources().getString(R.string.thank_you);

        int price = calculatePrice(quantity, 10);
        String priceMessage;

        EditText name = (EditText) findViewById(R.id.name_editText);
        String getName = name.getText().toString();

        if(hasChecked())
        priceMessage = quantityR + ":" + quantity + "\n" + totalR +":" + price + "$" + "\n" + menuSelected + "\n" +  thankYouR;
            else
                priceMessage = quantityR + ":" + quantity + "\n" + totalR + ":" + price + "$" + "\n" + thankYouR;

        displayMessage(priceMessage, getName);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity    is the number of cups of coffee ordered
     * @param pricePerCup is the price of one cup of coffee
     */
    private int calculatePrice(int quantity, int pricePerCup) {
        int price;

        if(hasChecked()) {
            pricePerCup += priceSelected;
            price = quantity * pricePerCup;
        }else
            price = quantity * pricePerCup;

        return price;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_TextView);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message, String name) {
        /*
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_TextView);
        orderSummaryTextView.setText(message);
        */

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this.
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order Done: " + name);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null)  //prevent the app from crash when no App found to handle.
            startActivity(intent);
    }

    /**
     *  Method to check whethter the Toppings is being Checked or Not.
     *  if one of the Topping is checked then Add Price to the global Var and Change the Price.
     *  MEthod Contain CheckBox Views, String of Array To define the Selected CheckBox and Array of int to Define the Price and Change it.
     *  If Statement to Know which one of toppings or Both Is being Checked by isChecked Method.
     * @return menuChecked If whippedCream or Chocolate Checked or Both.
     */
    private boolean hasChecked() {
        CheckBox whipedCream =(CheckBox) findViewById(R.id.Whipped_Cream_CheckBox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.Chocolate_CheckBox);
        String[] menu = {"Whipped Cream", "Chocolate"};
        int[] menuPrice = {1, 2};

        boolean menuChecked = false;

        if (whipedCream.isChecked() && chocolate.isChecked() ) {
            this.menuSelected = menu[0] + " With " + menu[1];
            this.priceSelected = menuPrice[0] + menuPrice[1] ;
            return menuChecked = true; }

        if (whipedCream.isChecked()) {
            this.menuSelected = menu[0];
            this.priceSelected = menuPrice[0];
            return menuChecked = true; }

        if (chocolate.isChecked()){
            this.menuSelected = menu[1];
            this.priceSelected = menuPrice[1];
            return menuChecked = true; }

        return menuChecked;

    }

}
