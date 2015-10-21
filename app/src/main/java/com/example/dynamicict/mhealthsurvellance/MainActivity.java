package com.example.dynamicict.mhealthsurvellance;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton next;
    private EditText userID;
    private EditText password;
    //private String UserID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userID=(EditText)findViewById(R.id.userID);
        password=(EditText)findViewById(R.id.password);

        next=(ImageButton) findViewById(R.id.next);
        next.setOnClickListener(this);

        //UserID=userID.getText().toString();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            Intent newIntent= new Intent(getApplicationContext(),about.class);
            startActivity(newIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (userID.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Please Provide a User ID!", Toast.LENGTH_LONG).show();
        }else if(userID.getText().toString().equals("mobile1")&& password.getText().toString().equals("12345")){
            Intent intent=new Intent(getApplicationContext(),chooseActivity.class);
//            Intent intent=new Intent(getApplicationContext(),wekaDetails.class);
            intent.putExtra(chooseActivity.ARG_UserID,userID.getText().toString().trim());
            //intent.putExtra(wekaDetails.ARG_userID,userID.getText().toString().trim());
            startActivity(intent);
        }else if(userID.getText().toString().equals("mobile2")&& password.getText().toString().equals("123456")){
            Intent intent=new Intent(getApplicationContext(),chooseActivity.class);
//            Intent intent=new Intent(getApplicationContext(),wekaDetails.class);
            intent.putExtra(chooseActivity.ARG_UserID,userID.getText().toString().trim());
            //intent.putExtra(wekaDetails.ARG_userID,userID.getText().toString().trim());
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Wrong Info Provided!", Toast.LENGTH_LONG).show();

            //Intent intentBack new Intent(getApplicationContext(),this);
        }

    }
}
