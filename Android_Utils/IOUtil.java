package com.rya.weishang.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Yan on 2017/5/22.
 * <p>
 * Reach me : http://ryanyans.github.io
 * Email : ryanyans32@gmail.com
 * <p>
 * 微型流关闭工具类
 */

public class IOUtil {
	/** 关闭流 */
	public static boolean close(Closeable io) {
		if (io != null) {
			try {
				io.close();
			} catch (IOException e) {
				LogUtil.e(e);
			}
		}
		return true;
	}
}
