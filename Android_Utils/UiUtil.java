package com.rya.weishang.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.rya.weishang.global.GlobalApplication;

import java.util.Random;

/**
 * Created by Yan on 2017/5/10.
 * <p>
 * Reach me : http://ryanyans.github.io
 * Email : ryanyans32@gmail.com
 * <p>
 * 常用UI辅助类
 */

public class UiUtil {

    public static Context getContext() {
        return GlobalApplication.getContext();
    }

    public static Handler getHandler() {
        return GlobalApplication.getHandler();
    }

    public static int getMainThreadId() {
        return GlobalApplication.getMainThreadId();
    }

    public static String getString(int id) {
        return GlobalApplication.getContext().getResources().getString(id);
    }

    public static String[] getStringArr(int id) {
        return GlobalApplication.getContext().getResources().getStringArray(id);
    }

    public static int getColor(int id) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return GlobalApplication.getContext().getResources().getColor(id, null);
            }
        return GlobalApplication.getContext().getResources().getColor(id);
    }

    public static Drawable getDrawerable(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return GlobalApplication.getContext().getResources().getDrawable(id, null);
        }
        return GlobalApplication.getContext().getResources().getDrawable(id);
    }

    public static int getDimen(int id) {
        return (int) GlobalApplication.getContext().getResources().getDimension(id);

    }

    public static View inflate(int resource) {
        return View.inflate(GlobalApplication.getContext(), resource, null);
    }

    public static int dip2px(int dip) {
        float density = GlobalApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5);
    }

    public static float px2dip(int px) {
        float density = GlobalApplication.getContext().getResources().getDisplayMetrics().density;
        return px / density;
    }

    public static boolean isRunOnUIThread() {

        int myTid = Process.myTid();
        return GlobalApplication.getMainThreadId() == myTid;
    }

    public static void runOnUIThread(Runnable r) {
        if (isRunOnUIThread()) {
            r.run();
        } else {
            getHandler().post(r);
        }

    }


    public static int getRandomColor() {
        Random random = new Random();
        int randomRed = 30 + random.nextInt(200);
        int randomgreen = 30 + random.nextInt(200);
        int randomblue = 30 + random.nextInt(200);

        return Color.rgb(randomRed, randomgreen, randomblue);
    }

    public static float getRandomSize() {
        Random random = new Random();
        return (float) (12 + random.nextInt(16));
    }
}
