package com.example.application;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class ContactAdapter extends BaseAdapter {

	List<prp_Contact> list;
	Context context;
	Activity activity;

	TextView txt_name, txt_number;
	CheckBox chkBox;

	

	public ContactAdapter(Context context1, List<prp_Contact> list1,
			Activity act) {

		context = context1;
		list = list1;
		activity = act;

		

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return list.indexOf(list.get(position));
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.list_contact, null);

		// retreive id's
		txt_name = (TextView) convertView.findViewById(R.id.textView_name);
		txt_number = (TextView) convertView.findViewById(R.id.textView_number);
		chkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

		// set values
		txt_name.setText(list.get(position).name);
		txt_number.setText(list.get(position).number);
		
		//set checked status
		if(ContactActivity.chklist.get(position) == true)
		{
			chkBox.setChecked(true);
		}
		else
		{
			chkBox.setChecked(false);
		}
		

		chkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buttonView.isChecked()) {

					ContactActivity.chklist.set(position, true);

					
				} else {

					ContactActivity.chklist.set(position, false);

				}
				
				notifyDataSetChanged();

			}
		});

		return convertView;
	}

}
