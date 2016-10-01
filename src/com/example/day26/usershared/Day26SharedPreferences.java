package com.example.day26.usershared;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.day26.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Day26SharedPreferences extends Activity implements OnClickListener {
	EditText ed_name, ed_password;
	Button login;
	CheckBox cb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day26_userlogin);
		ed_name = (EditText) findViewById(R.id.day26_username);
		ed_password = (EditText) findViewById(R.id.day26_userpassword);
		login = (Button) findViewById(R.id.day26_login);
		cb = (CheckBox) findViewById(R.id.day26_checkbox);

		readAccount();

		login.setOnClickListener(this);
	}

	public void readAccount() {
		SharedPreferences sp = getSharedPreferences("shared", MODE_PRIVATE);
		ed_name.setText(sp.getString("name", ""));
		ed_password.setText(sp.getString("password", ""));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.day26_login: {
			String name = ed_name.getText().toString();
			String password = ed_password.getText().toString();
			if (cb.isChecked()) {
				SharedPreferences sp = getSharedPreferences("shared",
						MODE_PRIVATE);
				Editor ed = sp.edit();// ÄÃµ½±à¼­Æ÷
				ed.putString("name", name);
				ed.putString("password", password);
				ed.commit();
			} else {
				Toast.makeText(this, "µÇÂ¼³É¹¦", 0).show();
			}
			break;
		}
		default:
			break;
		}
	}
}
