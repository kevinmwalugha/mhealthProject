package com.example.dynamicict.mhealthsurvellance;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;


public class chooseActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2;

    public static final String ARG_UserID = "userID";
    private Bundle extras;
    private String user;

    private TextView timeshower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        timeshower=(TextView) findViewById(R.id.time);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

       // timeshower is the TextView view that should display it
        timeshower.setText(currentDateTimeString);

        btn1=(Button) findViewById(R.id.submit_data);
        btn1.setOnClickListener(this);
        btn2=(Button) findViewById(R.id.support);
        btn2.setOnClickListener(this);

        extras = getIntent().getExtras();
        if (extras != null) {
            user = extras.getString(ARG_UserID);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_data:
                Intent intent=new Intent(getApplicationContext(),wekaDetails.class);
                intent.putExtra(wekaDetails.ARG_UserID,user.toString().trim());
                startActivity(intent);
                break;
            case R.id.support:
                Intent support=new Intent(getApplicationContext(),faq.class);
                startActivity(support);
                break;
            default:
                break;
        }
    }
}
