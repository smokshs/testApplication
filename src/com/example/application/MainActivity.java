package com.example.application;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
	TextView txtvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        
        txtvw=(TextView)findViewById(R.id.textView1);
        
    	// heading font
		Typeface typeFaceboldopt = Typeface.createFromAsset(getAssets(),
						"fonts/Opificio-Bold.ttf");
		txtvw.setTypeface(typeFaceboldopt);
        
        //after delay open next screen
        new Handler().postDelayed(new Runnable() {
        	
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start app's home screen
                Intent i = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, 3000);
        
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
