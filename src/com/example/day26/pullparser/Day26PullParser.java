package com.example.day26.pullparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.example.day26.R;
import com.example.entity.City;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Day26PullParser extends Activity implements OnClickListener {
	Button pullparser;
	TextView pulltext;
	List<City> cityList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day26_pullparser);
		pullparser = (Button) findViewById(R.id.day26_pullparser);
		pulltext = (TextView) findViewById(R.id.day26_pulltext);
		pullparser.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.day26_pullparser:
			// ��ȡsrc�µ���Դ�ļ�
			InputStream is = getClassLoader()
					.getResourceAsStream("weather.xml");
			// �õ�pull����������
			XmlPullParser xp = Xml.newPullParser();
			// ��ʼ��
			try {
				xp.setInput(is, "utf-8");
				// ��ȡ��ǰ�ڵ���¼�����,ͨ���¼����͵��жϣ����ǿ���֪����ǰ�ڵ���ʲô�ڵ㣬�Ӷ�ȷ������Ӧ����ʲô����
				int type = xp.getEventType();
				City city = null;
				while (type != XmlPullParser.END_DOCUMENT) {
					// ���ݽڵ����ͣ�Ҫ����ͬ�Ĳ���
					switch (type) {
					case XmlPullParser.START_TAG:
						if ("weather".equals(xp.getName())) {
							// ����city���϶������ڴ��city��javabean
							cityList = new ArrayList<City>();
						} else if ("city".equals(xp.getName())) {
							// ����city��javabean����
							city = new City();
						} else if ("name".equals(xp.getName())) {
							// ��ȡ��ǰ�ڵ����һ���ڵ���ı�������ָ���ƶ�����ǰ�ڵ�Ľ����ڵ�
							String name = xp.nextText();
							city.setName(name);
						} else if ("temp".equals(xp.getName())) {
							String temp = xp.nextText();
							city.setTemp(temp);
						} else if ("pm".equals(xp.getName())) {
							String pm = xp.nextText();
							city.setPm(pm);
						}
						break;
					case XmlPullParser.END_TAG:
						if ("city".equals(xp.getName())) {
							// ��city��javabean���뼯����
							cityList.add(city);
						}
						break;
					default:
						break;
					}
					// ��ָ���ƶ�����һ���ڵ㣬�����ظýڵ���¼�����
					type = xp.next();
				}

				for (City c : cityList) {
					Log.i("city", c.toString());
				}

			} catch (XmlPullParserException e) {
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
