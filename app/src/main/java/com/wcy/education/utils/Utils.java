package com.wcy.education.utils;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.gson.Gson;

import java.io.File;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static void showInputMethod(Context context, View view,
                                       boolean show_type) {
        InputMethodManager im = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (show_type) {
            im.showSoftInput(view, 0);
        } else {
            im.hideSoftInputFromWindow(view.getWindowToken(), 0); // ǿ�����ؼ���
        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int intToDip(Context context, int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                value, context.getResources().getDisplayMetrics());
    }

    /**
     * 判断�?个数是否是奇数：
     *
     * @param i
     * @return
     */
    public static boolean isOdd(int i) {
        return (i & 1) != 0;
    }

    public static String getStrVal(Object o) {
        String result = (o != null) ? o.toString() : "";
        return result;
    }

    public static String getStrDefaultVal(Object o, String defaultVal) {
        String result = (o != null) ? o.toString() : defaultVal;
        return result;
    }

    public static int getIntVal(Object o, int defaultVal) {
        String resultStr = (o != null) ? o.toString() : "";
        int result = isNum(resultStr) ? Integer.parseInt(resultStr)
                : defaultVal;
        return result;
    }

    public static Float getFloatVal(Object o, Float defaultVal) {
        String resultStr = (o != null) ? o.toString() : "";
        Float result = isDecimal(resultStr) ? Float.parseFloat(resultStr)
                : defaultVal;
        return result;
    }

    public static Double getDoubleVal(Object o, Double defaultVal) {
        String resultStr = (o != null) ? o.toString() : "";
        Double result = isDecimal(resultStr) ? Double.parseDouble(resultStr)
                : defaultVal;
        return result;
    }

    public static boolean isNum(String str) {
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(str).matches();
    }

    public static boolean isDecimal(String str) {
        if (str == null || "".equals(str))
            return false;
        Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 验证邮箱地址是否正确
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }

        return flag;
    }

    /**
     * 验证手机号码
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^(13[0-9]|15[012356789]|17[3678]|18[0-9]|14[57])[0-9]{8}$");
            Matcher m = p.matcher(mobiles);
            flag = m.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static String toJson(Object obj) {

        String jsonStr = "{}";

        if (obj != null) {

            Gson gson = new Gson();

            jsonStr = gson.toJson(obj);

            jsonStr = jsonStr.replace("\\u003d", "=").replace("\\u0026", "&")
                    .replace("\\u0027", "'");
        }

        return jsonStr;
    }

    public static String numFormat(int len, int num) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(len);
        formatter.setGroupingUsed(false);
        String numStr = formatter.format(num);
        return numStr;
    }

    public static Boolean isEmpty(String contant) {
        if (contant == null || contant.equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 清除本应用内部缓存(/data/data/com.xxx.xxx/cache) *
     *
     * @param context
     */
    public static void cleanInternalCache(Context context) {
        deleteFilesByDirectory(context.getCacheDir());
    }


    /**
     * 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理
     *
     * @param directory
     */
    private static void deleteFilesByDirectory(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            for (File item : directory.listFiles()) {
                item.delete();
            }
        }
    }

}
