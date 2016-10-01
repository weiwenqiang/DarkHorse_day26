package com.example.day26.layout;

import com.example.day26.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Day26Layout extends Activity implements OnClickListener {
	Button l1, l21, l22, l3, l41, l42, l5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day26_layout);
		l1 = (Button) findViewById(R.id.day26_l1);
		l21 = (Button) findViewById(R.id.day26_l21);
		l22 = (Button) findViewById(R.id.day26_l22);
		l3 = (Button) findViewById(R.id.day26_l3);
		l41 = (Button) findViewById(R.id.day26_l41);
		l42 = (Button) findViewById(R.id.day26_l42);
		l5 = (Button) findViewById(R.id.day26_l5);
		l1.setOnClickListener(this);
		l21.setOnClickListener(this);
		l22.setOnClickListener(this);
		l3.setOnClickListener(this);
		l41.setOnClickListener(this);
		l42.setOnClickListener(this);
		l5.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.day26_l1:
			startActivity(new Intent(Day26Layout.this, Day26Frame.class));
			break;
		case R.id.day26_l21:
			startActivity(new Intent(Day26Layout.this, Day26Linear.class));
			break;
		case R.id.day26_l22:
			startActivity(new Intent(Day26Layout.this, Day26Colour.class));
			break;
		case R.id.day26_l3:
			startActivity(new Intent(Day26Layout.this, Day26Table.class));
			break;
		case R.id.day26_l41:
			startActivity(new Intent(Day26Layout.this, Day26Relative.class));
			break;
		case R.id.day26_l42:
			startActivity(new Intent(Day26Layout.this, Day26RelativeDemo.class));
			break;
		case R.id.day26_l5:
			startActivity(new Intent(Day26Layout.this, Day26Absolute.class));
			break;

		default:
			break;
		}
	}
}
