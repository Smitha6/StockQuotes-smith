package com.example.alex.stockquotes_smith;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    private Button findButton;

    private Task task;

    private TextView displaySymbol;
    private TextView displayName;
    private TextView displayLastTradePrice;
    private TextView displayLastTradeTime;
    private TextView displayChange;
    private TextView displayWeekRange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displaySymbol = findViewById(R.id.displaySymbol);
        displayName = findViewById(R.id.displayName);
        displayLastTradePrice = findViewById(R.id.displayLastTradePrice);
        displayLastTradeTime = findViewById(R.id.displayLastTradeTime);
        displayChange = findViewById(R.id.displayChange);
        displayWeekRange = findViewById(R.id.displayWeekRange);

        findButton = findViewById(R.id.findButton);
        editText = findViewById(R.id.editText);


        task = new Task(displaySymbol,displayName,displayLastTradePrice,displayLastTradeTime,displayChange,displayWeekRange);


        findButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                task.execute(editText.getText().toString());
            }
        });
    }
}
