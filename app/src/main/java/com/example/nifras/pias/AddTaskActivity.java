package com.example.nifras.pias;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AddTaskActivity extends ActionBarActivity {

    String fontPath, fontPath2;
    EditText task_description;
    EditText task;
    Button remind, location, time;
    TextView addnew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_task);
        setParam();
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
