package com.example.nifras.pias;

import android.content.Intent;
import android.database.Cursor;
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


public class LoginActivity extends ActionBarActivity {

    String fontPath;
    String fontPath2;

    TextView remind;
    EditText user;
    EditText pass;
    Button login;
    TextView register;
    String username, password;
    private DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setParam();
        setTypeFace();



        // Loading Font Face


        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        register();
                    }
                }
        );

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValues();
                Toast.makeText(getApplicationContext(), username +"   "+ password, Toast.LENGTH_SHORT).show();
                login();
            }
        });

    }

    public void register(){
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);

    }

    public void login() {
            Cursor rs =null;



        try{
            rs = mydb.getUser(username);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if(rs != null){
        rs.moveToFirst();
        String user = rs.getString(rs.getColumnIndex(DBHelper.USER_USERNAME));
        String pass = rs.getString(rs.getColumnIndex(DBHelper.USER_PASSWORD));

        if (!rs.isClosed()) {
            rs.close();
        }
        if (user.equals(username) && pass.equals(password)) {

            Toast.makeText(getApplicationContext(), "Redirecting", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), AddTaskActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "username or password wrong", Toast.LENGTH_LONG).show();
        }
     }
        else{
            Toast.makeText(getApplicationContext(), "rs null", Toast.LENGTH_LONG).show();
        }



    }


    public void setParam(){
        fontPath = "fonts/helvetica.otf";
        fontPath2 = "fonts/bold.otf";

        remind = (TextView) findViewById(R.id.remindme);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);
        mydb = new DBHelper(this);

    }

    public void setTypeFace(){
        Typeface helvetica = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface bold= Typeface.createFromAsset(getAssets(), fontPath2);

        // Applying font
        user.setTypeface(helvetica);
        pass.setTypeface(helvetica);
        login.setTypeface(helvetica);
        register.setTypeface(helvetica);
        remind.setTypeface(bold);

    }

    public void setValues(){
        username = user.getText().toString();
        password = pass.getText().toString();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
