package com.example.day26;

import com.example.day26.layout.Day26Layout;
import com.example.day26.logcat.Day26LogCat;
import com.example.day26.preference.Day26Preference;
import com.example.day26.pullparser.Day26PullParser;
import com.example.day26.userfile.Day26UserFile;
import com.example.day26.usersd.Day26UserSD;
import com.example.day26.usershared.Day26SharedPreferences;
import com.example.day26.visitlimits.Day26VisitLimits;
import com.example.day26.xmlnote.Day26XmlNote;
import com.example.day26.xmlserizlizer.Day26XmlSerializer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1 = (Button) findViewById(R.id.day26_b1);
		b2 = (Button) findViewById(R.id.day26_b2);
		b3 = (Button) findViewById(R.id.day26_b3);
		b4 = (Button) findViewById(R.id.day26_b4);
		b5 = (Button) findViewById(R.id.day26_b5);
		b6 = (Button) findViewById(R.id.day26_b6);
		b7 = (Button) findViewById(R.id.day26_b7);
		b8 = (Button) findViewById(R.id.day26_b8);
		b9 = (Button) findViewById(R.id.day26_b9);
		b10 = (Button) findViewById(R.id.day26_b10);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		b9.setOnClickListener(this);
		b10.setOnClickListener(this);
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.day26_b1:
			startActivity(new Intent(MainActivity.this, Day26Layout.class));
			break;
		case R.id.day26_b2:
			startActivity(new Intent(MainActivity.this, Day26LogCat.class));
			break;
		case R.id.day26_b3:
			startActivity(new Intent(MainActivity.this, Day26UserFile.class));
			break;
		case R.id.day26_b4:
			startActivity(new Intent(MainActivity.this, Day26UserSD.class));
			break;
		case R.id.day26_b5:
			startActivity(new Intent(MainActivity.this, Day26Preference.class));
			break;
		case R.id.day26_b6:
			startActivity(new Intent(MainActivity.this, Day26VisitLimits.class));
			break;
		case R.id.day26_b7:
			startActivity(new Intent(MainActivity.this,
					Day26SharedPreferences.class));
			break;
		case R.id.day26_b8:
			startActivity(new Intent(MainActivity.this, Day26XmlNote.class));
			break;
		case R.id.day26_b9:
			startActivity(new Intent(MainActivity.this,
					Day26XmlSerializer.class));
			break;
		case R.id.day26_b10:
			startActivity(new Intent(MainActivity.this, Day26PullParser.class));
			break;
		default:
			break;
		}
	}
}
