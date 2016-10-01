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

		p.setSummary("通过setSummary修改过后的摘要");
		sum.setTitle("SD卡总空间");
		available.setTitle("SD卡剩余空间");

		File path = Environment.getExternalStorageDirectory();
		StatFs stat = new StatFs(path.getPath());// StatFs获取文件系统存储空间的信息
		long blockSize;// 区块大小
		long totalBlocks;// 区块数量
		long availeableBlock;// 可用区块

		// 获取当前系统版本的等级
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
