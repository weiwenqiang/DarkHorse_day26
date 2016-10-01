package com.example.day26.visitlimits;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.day26.R;

import android.app.Activity;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Day26VisitLimits extends Activity implements OnClickListener {
	Button visit1, visit2, visit3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day26_visitlimits);
		visit1 = (Button) findViewById(R.id.day26_visit1);
		visit2 = (Button) findViewById(R.id.day26_visit2);
		visit3 = (Button) findViewById(R.id.day26_visit3);

		visit1.setOnClickListener(this);
		visit2.setOnClickListener(this);
		visit3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.day26_visit1:
			try {
				File file1 = new File(getFilesDir(), "visit1.txt");
				FileOutputStream fos1 = new FileOutputStream(file1);
				fos1.write("直接使用文件流写的文件权限仅拥有者可以访问".getBytes());
				fos1.close();
				Toast.makeText(this, R.string.day26_visit1, 0).show();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (NotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case R.id.day26_visit2:
			try {
				FileOutputStream fos2 = openFileOutput("visit2.txt",
						MODE_PRIVATE);
				fos2.write("同组成员可以访问的文件".getBytes());
				fos2.close();
				Toast.makeText(this, R.string.day26_visit2, 0).show();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case R.id.day26_visit3:
			try {
				FileOutputStream fos3 = openFileOutput("visit3.txt",
						MODE_WORLD_READABLE | MODE_WORLD_WRITEABLE);
				fos3.write("任何用户都可以读和写，非常危险，已经停止使用".getBytes());
				Toast.makeText(this, R.string.day26_visit3, 0).show();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

}
