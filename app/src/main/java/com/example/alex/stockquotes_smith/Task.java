package com.example.alex.stockquotes_smith;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Alex on 3/12/2018.
 */

public class Task extends AsyncTask<String, Void, ArrayList<String>>
{
    private TextView displaySymbol;
    private TextView displayName;
    private TextView displayLastTradePrice;
    private TextView displayLastTradeTime;
    private TextView displayChange;
    private TextView displayWeekRange;

    private Context context;

    public Task (TextView displaySymbol,
                 TextView displayName,
                 TextView displayLastTradePrice,
                 TextView displayLastTradeTime,
                 TextView displayChange,
                 TextView displayWeekRange,
                 Context context)
    {
        this.displaySymbol = displaySymbol;
        this.displayName = displayName;
        this.displayLastTradePrice = displayLastTradePrice;
        this.displayLastTradeTime = displayLastTradeTime;
        this.displayChange = displayChange;
        this.displayWeekRange = displayWeekRange;

        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected ArrayList<String> doInBackground(String ... strings) {


        ArrayList<String> arrayList = new ArrayList<>();
        Stock stock;


        stock = new Stock(strings[0]);
        try {
            stock.load();
        }
        catch (Exception e) {
            onProgressUpdate();
        }

        arrayList.add(0, stock.getSymbol());
        arrayList.add(1,stock.getName());
        arrayList.add(2,stock.getLastTradePrice());
        arrayList.add(3,stock.getLastTradeTime());
        arrayList.add(4,stock.getChange());
        arrayList.add(5,stock.getRange());


        return arrayList;
    }


    @Override
    protected void onPostExecute(ArrayList<String> arr) {
        super.onPostExecute(arr);


        try {
            displaySymbol.setText(arr.get(0));
            displayName.setText(arr.get(1));
            displayLastTradePrice.setText(arr.get(2));
            displayLastTradeTime.setText(arr.get(3));
            displayChange.setText(arr.get(4));
            displayWeekRange.setText(arr.get(5));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    protected void onProgressUpdate(Void ... voids) {
        Toast.makeText(context, "Stock Quote Not Found",
                Toast.LENGTH_LONG).show();
    }

}
