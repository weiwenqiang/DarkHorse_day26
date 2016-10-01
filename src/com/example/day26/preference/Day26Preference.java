package com.example.day26.preference;

import java.io.File;

import com.example.day26.R;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.text.format.Formatter;

public class Day26Preference extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.day26_preference);

		Preference p = findPreference("pre");
		Preference sum = findPreference("sum");
		Preference available = findPreference("available");

		p.setSummary("ͨ��setSummary�޸Ĺ����ժҪ");
		sum.setTitle("SD���ܿռ�");
		available.setTitle("SD��ʣ��ռ�");

		File path = Environment.getExternalStorageDirectory();
		StatFs stat = new StatFs(path.getPath());// StatFs��ȡ�ļ�ϵͳ�洢�ռ����Ϣ
		long blockSize;// �����С
		long totalBlocks;// ��������
		long availeableBlock;// ��������

		// ��ȡ��ǰϵͳ�汾�ĵȼ�
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
			blockSize = stat.getBlockSize();
			totalBlocks = stat.getBlockCount();
			availeableBlock = stat.getAvailableBlocks();
		} else {
			blockSize = stat.getBlockSize();
			totalBlocks = stat.getBlockCount();
			availeableBlock = stat.getAvailableBlocks();
		}

		sum.setSummary(formatSize(totalBlocks * blockSize));
		available.setSummary(formatSize(availeableBlock * blockSize));
	}

	private String formatSize(long size) {
		return Formatter.formatFileSize(this, size);
	}

}
