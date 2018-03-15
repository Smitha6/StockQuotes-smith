package com.example.alex.stockquotes_smith;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

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

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;


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




        toolbar = findViewById(R.id.toolbarLayout);
        //setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);

        //actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);

        //drawerLayout.addDrawerListener(actionBarDrawerToggle);





        findButton = findViewById(R.id.findButton);
        editText = findViewById(R.id.editText);

        task = new Task(displaySymbol,displayName,displayLastTradePrice,displayLastTradeTime,displayChange,displayWeekRange,this);

        findButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                task.execute(editText.getText().toString());
            }
        });
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //actionBarDrawerToggle.syncState();
    }



    public void clickGoog(MenuItem menuItem) {
        drawerLayout.closeDrawers();
        task.execute("goog");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //getMenuInflater().inflate(R.menu.title_bar_icons,menu);

        return true;
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    */




}