package com.example.day26.logcat;

import com.example.day26.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Day26LogCat extends Activity implements OnClickListener {
	TextView t1, t2, t3, t4, t5, t6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day26_logcat);
		t1 = (TextView) findViewById(R.id.day26_verbose);
		t2 = (TextView) findViewById(R.id.day26_debug);
		t3 = (TextView) findViewById(R.id.day26_info);
		t4 = (TextView) findViewById(R.id.day26_warn);
		t5 = (TextView) findViewById(R.id.day26_error);
		t6 = (TextView) findViewById(R.id.day26_asser);
		t1.setOnClickListener(this);
		t2.setOnClickListener(this);
		t3.setOnClickListener(this);
		t4.setOnClickListener(this);
		t5.setOnClickListener(this);
		t6.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.day26_verbose:
			Log.v("TAG", "verbose冗余");
			break;
		case R.id.day26_debug:
			Log.d("TAG", "debug调试");
			break;
		case R.id.day26_info:
			Log.i("TAG", "info信息");
			break;
		case R.id.day26_warn:
			Log.w("TAG", "warn警告");
			break;
		case R.id.day26_error:
			Log.e("TAG", "error错误");
			break;
		case R.id.day26_asser:
			break;
		default:
			break;
		}
	}

}
