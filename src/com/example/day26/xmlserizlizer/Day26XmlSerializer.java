package com.example.day26.xmlserizlizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import com.example.day26.R;
import com.example.entity.Note;

import android.app.Activity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Day26XmlSerializer extends Activity implements OnClickListener {
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
			Note note = new Note("��������" + i, System.currentTimeMillis() + "",
					"136" + i + i + i + i, "1");
			noteList.add(note);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.day26_backups:
			// ʹ��xml���л�������xml�ļ�
			// 1.�õ����л�������
			XmlSerializer xs = Xml.newSerializer();
			// 2.��ʼ��
			File file = new File("sdcard/noteserializer.xml");
			try {
				FileOutputStream fos = new FileOutputStream(file);
				xs.setOutput(fos, "utf-8");
				// 3.��ʼ����xml�ļ�
				xs.startDocument("utf-8", true);// ͷ�ڵ�
				xs.startTag(null, "messages");
				for (Note note : noteList) {
					xs.startTag(null, "note");
					xs.startTag(null, "body");
					xs.text(note.getBody()+"<body>");
					xs.endTag(null, "body");
					xs.startTag(null, "date");
					xs.text(note.getDate());
					xs.endTag(null, "date");
					xs.startTag(null, "address");
					xs.text(note.getAddress());
					xs.endTag(null, "address");
					xs.startTag(null, "type");
					xs.text(note.getType());
					xs.endTag(null, "type");
					xs.endTag(null, "note");
				}
				xs.endTag(null, "messages");
				// �������л������ļ��������
				xs.endDocument();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
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
