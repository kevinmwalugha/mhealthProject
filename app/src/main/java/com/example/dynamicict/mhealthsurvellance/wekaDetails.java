package com.example.dynamicict.mhealthsurvellance;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class wekaDetails extends AppCompatActivity implements View.OnClickListener {

    public static final String ARG_UserID = "userID";
    private Bundle extras;

    private ImageButton next;

    private String user;

    private EditText d1,d2,d3,d4,d5,d6;

    private String d11,d22,d33,d44,d55,d66;

    private final List<String> diseases=new ArrayList<>();

    private String messageToSend;
    private String SmsToSend;

    private Spinner mySpinner;
    //private String[] weeks={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52"};
    List<String> weeks= new ArrayList<String>();
    private String selectedweek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weka_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mySpinner = (Spinner) findViewById(R.id.mySpinner);

            for(int j=1;j<53;j++)
                {
                    weeks.add(String.valueOf(j));
                }
        ArrayAdapter weeksdata=new ArrayAdapter(this,R.layout.my_simple_spinner_item,weeks);
        weeksdata.setDropDownViewResource(R.layout.my_simple_spinner_dropdown_item);
        mySpinner.setAdapter(weeksdata);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedweek = weeks.get(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        extras = getIntent().getExtras();
        if (extras != null) {
            user = extras.getString(ARG_UserID);
        }
        d1 = (EditText) findViewById(R.id.d1);
        d2 = (EditText) findViewById(R.id.d2);
        d3 = (EditText) findViewById(R.id.d3);
        d4 = (EditText) findViewById(R.id.d4);
        d5 = (EditText) findViewById(R.id.d5);
        d6 = (EditText) findViewById(R.id.d6);

        next=(ImageButton)findViewById(R.id.btnDetails);
        next.setOnClickListener(this);
        //int diseases[]={d11,d22,d33,d44,d55,d66};

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weka_details, menu);
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


            d11=d1.getText().toString();
            d22=d2.getText().toString();
            d33=d3.getText().toString();
            d44=d4.getText().toString();
            d55=d5.getText().toString();
            d66=d6.getText().toString();


            diseases.add(d11);
            diseases.add(d22);
            diseases.add(d33);
            diseases.add(d44);
            diseases.add(d55);
            diseases.add(d66);
            diseases.add(user);
            diseases.add(selectedweek);

        messageToSend= TextUtils.join(",",diseases);



        sendSMSMessage();


    }

    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        //String phoneNo = txtphoneNo.getText().toString();
        //String message = txtMessage.getText().toString();
        //String diseases[]={d11,d22,d33,d44,d55,d66};
        String phoneNo="+211924295254";
        String message=messageToSend;

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();

            Intent main=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(main);
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
