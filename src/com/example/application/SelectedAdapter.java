package com.example.application;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class SelectedAdapter extends BaseAdapter{

	List<prp_Select> list;
	Context context;
	Activity activity;

	TextView txt_name, txt_number;
	CheckBox chkBox;

	

	public SelectedAdapter(Context context1, List<prp_Select> list1,
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
		convertView = inflater.inflate(R.layout.list_select, null);

		// retreive id's
		txt_name = (TextView) convertView.findViewById(R.id.textView_nameSelect);
		txt_number = (TextView) convertView.findViewById(R.id.textView_numberSelect);

		// set values
		txt_name.setText(list.get(position).name);
		txt_number.setText(list.get(position).number);
		
	

		return convertView;
	}
}
