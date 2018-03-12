package com.example.alex.stockquotes_smith;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    private TextView displaySymbol;
    private TextView displayName;
    private TextView displayLastTradePrice;




    private Stock stock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displaySymbol = findViewById(R.id.displaySymbol);
        displayName = findViewById(R.id.displayName);
        displayLastTradePrice = findViewById(R.id.displayLastTradePrice);

        //gets symbol
        editText = findViewById(R.id.editText);

        //create stock object with new symbol
        //stock = new Stock(editText.toString());

        stock = new Stock("goog");
        try {
            stock.load();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        displaySymbol.setText(stock.getSymbol().toString());
        //displayName.setText(stock.getName().toString());
        //displayLastTradePrice.setText(stock.getLastTradePrice().toString());




    }
}
