package com.example.day26.userfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.day26.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Day26UserFile extends Activity implements OnClickListener {
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
		File file = new File(getFilesDir(), "userfile.txt");
		if (file.exists()) {

			try {
				FileInputStream fis = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						fis));
				String text = br.readLine();
				String[] s = text.split("##");

				ed_name.setText(s[0]);
				ed_password.setText(s[1]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.day26_login: {
			String name = ed_name.getText().toString();
			String password = ed_password.getText().toString();
			if (cb.isChecked()) {

				File file = new File(getFilesDir(), "userfile.txt");
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(file);
					fos.write((name + "##" + password).getBytes());
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Log.i("login", "数据存储成功");
			} else {
				Toast.makeText(this, "登录成功", 0).show();
			}
			break;
		}
		default:
			break;
		}
	}

}
