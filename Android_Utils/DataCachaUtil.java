package com.rya.weishang.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Yan on 2017/7/22.
 * <p>
 * Reach me : http://ryanyans.github.io
 * Email : ryanyans32@gmail.com
 * <p>
 * 微型缓存工具类
 */

public class DataCachaUtil {

    /*public T getData(int index) {
        T data = null;
        // 先查看是否存在缓存文件
        String cacheData = getDataFromCache(index);
        if (cacheData != null) {

            data = parseData(cacheData);

        } else {
            String fromServerData = getDataFromServer(index);
            if (fromServerData != null) {
                setDataToCache(fromServerData, index);
                data = parseData(fromServerData);
            } else {
                LogUtil.w("服务器返回数据为空！");
            }
        }
        return data;
    }*/

    public static String getDataFromCache(String userId, String key) {
        File file = new File(UiUtil.getContext().getExternalCacheDir(), userId + key);

        if (!file.exists()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = null;
        char[] buff = new char[1024];
        int length;

        try {
            fileReader = new FileReader(file);
            while ((length = fileReader.read(buff)) > 0) {
                stringBuilder.append(buff, 0, length);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(fileReader);
        }
        return null;
    }

    public static void setDataToCache(String data, String userId, String key) {
        File file = new File(UiUtil.getContext().getExternalCacheDir(), userId + key);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);

            fileWriter.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(fileWriter);
        }
    }
}
