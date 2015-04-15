package com.example.nifras.pias;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class AddTaskActivity extends ActionBarActivity {

    String fontPath, fontPath2;
    EditText task_description;
    EditText task;
    Button remind, location, time;
    TextView addnew;
    ImageButton ok,cancel;
    Spinner year,month, date, hour,min,ampm;

    String [] years = {"2015", "2016", "2017"};
    String [] months = {"Jan", "Feb", "March", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
    String [] dates = {"1","2","3","4","5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
    String [] hours =  {"1","2","3","4","5", "6", "7", "8", "9", "10", "11", "12"};
    String [] mins = {"00", "01","02","03","04","05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15","16","17", "18"};
    String [] ampms = {"am", "pm"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_task);
        setParam();
        setTypeFace();

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime();

            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocation();
            }
        });



        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closetime();
            }
        });

    }


    public void setLocation(){

        int optionId = R.layout.layout_location;
        View C = findViewById(R.id.reminder_layout);
        ViewGroup parent = (ViewGroup) C.getParent();
        int index = parent.indexOfChild(C);
        parent.removeView(C);
        C = getLayoutInflater().inflate(optionId, parent, false);
        parent.addView(C, index);
        setParam();
        setTypeFace();


    }

    public void closeLocation(){

    }
    public void setTime(){
        Toast.makeText(getApplicationContext(), "time open",Toast.LENGTH_SHORT).show();
        int optionId = R.layout.layout_time;

        View C = findViewById(R.id.reminder_layout);
        ViewGroup parent = (ViewGroup) C.getParent();
        int index = parent.indexOfChild(C);
        parent.removeView(C);
        C = getLayoutInflater().inflate(optionId, parent, false);
        parent.addView(C, index);
        setParam();
        setTypeFace();

        ArrayAdapter<String> year_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, years);
        ArrayAdapter<String> month_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, months);
        ArrayAdapter<String> date_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, dates);
        ArrayAdapter<String> hour_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, hours);
        ArrayAdapter<String> min_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, mins);
        ArrayAdapter<String> ampm_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, ampms);
        year.setAdapter(year_adapter);
        month.setAdapter(month_adapter);
        date.setAdapter(date_adapter);

        hour.setAdapter(hour_adapter);
        min.setAdapter(min_adapter);
        ampm.setAdapter(ampm_adapter);

    }

    public void closetime(){


        int optionId = R.layout.reminder_button;
        View C = findViewById(R.id.time_layout);
        ViewGroup parent = (ViewGroup) C.getParent();
        int index = parent.indexOfChild(C);
        parent.removeView(C);
        C = getLayoutInflater().inflate(optionId, parent, false);
        parent.addView(C, index);

        setParam();
        location = (Button) findViewById(R.id.location);
        time = (Button) findViewById(R.id.time);
        setTypeFace();
    }

    public void setParam(){
        fontPath = "fonts/helvetica.otf";
        fontPath2 = "fonts/bold.otf";


        addnew = (TextView) findViewById(R.id.addnew);
        task = (EditText) findViewById(R.id.task);
        task_description = (EditText) findViewById(R.id.description);
        location = (Button) findViewById(R.id.location);
        time = (Button) findViewById(R.id.time);
        remind = (Button) findViewById(R.id.reminder);
        ok = (ImageButton) findViewById(R.id.ok);
        cancel = (ImageButton) findViewById(R.id.cancel);
        year = (Spinner) findViewById(R.id.year);
        month = (Spinner) findViewById(R.id.month);
        date = (Spinner) findViewById(R.id.date);
        hour = (Spinner) findViewById(R.id.hour);
        min = (Spinner) findViewById(R.id.min);
        ampm = (Spinner) findViewById(R.id.ampm);



    }
    public void setTypeFace(){
        // Loading Font Face
        Typeface helvetica = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface bold= Typeface.createFromAsset(getAssets(), fontPath2);

        // Applying font
        addnew.setTypeface(bold);
        remind.setTypeface(helvetica);
        task.setTypeface(helvetica);
        task_description.setTypeface(helvetica);

        location.setTypeface(helvetica);
        location.setAllCaps(false);
        remind.setTypeface(helvetica);
        remind.setAllCaps(false);
        time.setTypeface(helvetica);
        time.setAllCaps(false);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
