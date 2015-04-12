package com.example.nifras.pias;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends ActionBarActivity {

    String fontPath, fontPath2;
    TextView remind;
    EditText email;
    EditText name;
    EditText user;
    EditText pass;
    Button register;

    String Email, Name, username, password;

    private DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setParam();
        setTypeFace();


       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               register();

           }
       });


    }

    public void setTypeFace(){
        // Loading Font Face
        Typeface helvetica = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface bold= Typeface.createFromAsset(getAssets(), fontPath2);

        // Applying font
        remind.setTypeface(bold);
        user.setTypeface(helvetica);
        pass.setTypeface(helvetica);
        email.setTypeface(helvetica);
        register.setTypeface(helvetica);
        name.setTypeface(helvetica);

    }

    public void setParam(){
        fontPath = "fonts/helvetica.otf";
        fontPath2 = "fonts/bold.otf";
        mydb = new DBHelper(this);
        remind = (TextView) findViewById(R.id.remindme);
        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.name);
        user = (EditText) findViewById(R.id.username);
        pass= (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register);

    }

    public void setValues(){
        Email = email.getText().toString();
        Name = name.getText().toString();
        username = user.getText().toString();
        password = pass.getText().toString();
    }

    public void register(){

        setValues();

        if(mydb.insertUser(username, password, Email, Name)){
            Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(getApplicationContext(), " Not done", Toast.LENGTH_SHORT).show();
        }

        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
