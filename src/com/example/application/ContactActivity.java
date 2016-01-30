package com.example.application;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ContactActivity extends Activity {

	ListView list;
	Button btn_next;
	List<prp_Contact> listContact=new ArrayList<prp_Contact>();
	
	public static List<Boolean> chklist = new ArrayList<Boolean>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
		setContentView(R.layout.activity_contact);
		
		//retreiving id's
		list=(ListView)findViewById(R.id.listView1);
		btn_next=(Button)findViewById(R.id.button_next);
		 
		//load contacts to listview
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
        	prp_Contact p=new prp_Contact();
        	
          String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
          String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

          System.out.println("Name is : "+name);
          System.out.println("Phone is : "+phoneNumber);
          
          
          p.name=name;
          p.number=phoneNumber;
          
          listContact.add(p);
          
        }
        
        for (int i = 0; i < listContact.size(); i++) {
			chklist.add(false);
		}
        
        list.setAdapter(new ContactAdapter(getApplicationContext(), listContact, ContactActivity.this));
        
        phones.close();
        
        
        
        btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectedActivity.listSelect.clear();
				for(int i=0;i<listContact.size();i++)
				{
					if(chklist.get(i) == true)
					{
						prp_Select p =new prp_Select();
						
						p.name=listContact.get(i).name;
						p.number=listContact.get(i).number;
						
						SelectedActivity.listSelect.add(p);
					}
				}
				
				if(SelectedActivity.listSelect.size()>0)
				{
					 Intent i = new Intent(ContactActivity.this, SelectedActivity.class);
		                startActivity(i);
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No item selected !", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact, menu);
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
