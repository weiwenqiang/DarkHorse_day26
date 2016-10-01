package com.example.day26.xmlnote;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.day26.R;
import com.example.entity.Note;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Day26XmlNote extends Activity implements OnClickListener {
	List<Note> noteList;
	Button backups;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day26_xmlnote);
		init();
		backups = (Button) findViewById(R.id.day26_backups);
		backups.setOnClickListener(this);
	}

	private void init() {
		noteList = new ArrayList<Note>();
		for (int i = 0; i < 10; i++) {
			Note note = new Note("短信内容" + i, System.currentTimeMillis() + "",
					"136" + i + i + i + i, "1");
			noteList.add(note);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.day26_backups:
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version='1.0' encoding='utf-8' standalone='yes' ?>");
			sb.append("<Messages>");

			for (Note note : noteList) {
				sb.append("<Note>");
				sb.append("<body>");
				sb.append(note.getBody());
				sb.append("</body>");
				sb.append("<date>");
				sb.append(note.getDate());
				sb.append("</date>");
				sb.append("<address>");
				sb.append(note.getAddress());
				sb.append("</address>");
				sb.append("<type>");
				sb.append(note.getType());
				sb.append("</type>");
				sb.append("</Note>");
			}
			sb.append("</Messages>");

			File file = new File("sdcard/notebackups.xml");
			//需要SD卡写的权限
			try {
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(sb.toString().getBytes());
				fos.close();
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
