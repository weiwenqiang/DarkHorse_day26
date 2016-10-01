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
			// 获取src下的资源文件
			InputStream is = getClassLoader()
					.getResourceAsStream("weather.xml");
			// 拿到pull解析器对象
			XmlPullParser xp = Xml.newPullParser();
			// 初始化
			try {
				xp.setInput(is, "utf-8");
				// 获取当前节点的事件类型,通过事件类型的判断，我们可以知道当前节点是什么节点，从而确定我们应该做什么操作
				int type = xp.getEventType();
				City city = null;
				while (type != XmlPullParser.END_DOCUMENT) {
					// 根据节点类型，要做不同的操作
					switch (type) {
					case XmlPullParser.START_TAG:
						if ("weather".equals(xp.getName())) {
							// 创建city集合对象，用于存放city的javabean
							cityList = new ArrayList<City>();
						} else if ("city".equals(xp.getName())) {
							// 创建city的javabean对象
							city = new City();
						} else if ("name".equals(xp.getName())) {
							// 获取当前节点的下一个节点的文本，并把指针移动至当前节点的结束节点
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
							// 把city的javabean放入集合中
							cityList.add(city);
						}
						break;
					default:
						break;
					}
					// 把指针移动到下一个节点，并返回该节点的事件类型
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
