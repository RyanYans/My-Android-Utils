package com.rya.weishang.utils;


import java.util.Map;

public class StringUtil {
	/** 判断字符串是否有值，如果为null或者是空字符串或者只有空格或者为"null"字符串，则返回true，否则则返回false */
	public static boolean isEmpty(String value) {
		if (value != null && !"".equalsIgnoreCase(value.trim())
				&& !"null".equalsIgnoreCase(value.trim())) {
			return false;
		} else {
			return true;
		}
	}

	/** 把map参数 拼接成 get请求的 url格式 ,最后和 传过来的url一起拼接 */
	public static String paramsCastUrl(String url, Map<String, String> map) {
		if (map != null) {
			String params = "&";
			/** 遍历map，把 键值对应 */
			for (Map.Entry<String, String> entry : map.entrySet()) {
				params += entry.getKey() + "=" + entry.getValue() + "&";
			}
			/** 把一个字符串 从 0 一直截取到 字符串减一个长度处 */
			params = params.substring(0, params.length() - 1);
			return url + params;
		}
		return url;
	}

	public static double formatNum(double num) {
		return (double)(Math.round(num*100))/100;
	}

	public static float formatNum(float num) {
		return (float) (Math.round(num*100))/100;
	}

	public static String getEnd4Num(String bankCardId) {
		return bankCardId.substring(bankCardId.length() - 4, bankCardId.length());
	}
}
