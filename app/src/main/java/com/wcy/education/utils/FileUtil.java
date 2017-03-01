package com.wcy.education.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import org.apache.http.util.EncodingUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static final String TAG = "FileUtil";

    public static FileUtil instances;

    private Context mContext;

    public static FileUtil getInstances() {
        if (instances == null) {
            instances = new FileUtil();
        }
        return instances;
    }

    /**
     */
    public void deleteFileByName(String path) {
        Log.d(TAG, "==============path=" + path);
        File file = new File(path); // "my/voice.amr"
        if (file.exists()) {
            Log.d(TAG, "==============pɾ��");
            file.delete();
        }
    }

    /**
     * @param path
     * @param fileName
     * @return
     */
    public String getAmrPath(String path, String fileName) {
        File file = new File(Environment.getExternalStorageDirectory(), path + fileName);
        return file.getAbsolutePath();
    }

    /**
     * @param f
     * @return
     * @throws IOException
     */
    public byte[] getBytesFromFile(File f) throws IOException, FileNotFoundException {
        if (f == null) {
            return null;
        }
        FileInputStream fis = null;
        ByteArrayOutputStream out = null;
        try {
            fis = new FileInputStream(f);
            out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                out.write(b, 0, n);
            }
            return out.toByteArray();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * @return
     */
    public void deleteFolderFile(String filePath, boolean deleteThisPath) throws IOException {
        if (!TextUtils.isEmpty(filePath)) {
            File file = new File(filePath);

            if (file.isDirectory()) {// ����Ŀ¼
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFolderFile(files[i].getAbsolutePath(), true);
                }
            }
            if (deleteThisPath) {
                if (!file.isDirectory()) {// ������ļ���ɾ��
                    file.delete();
                } else {// Ŀ¼
                    if (file.listFiles().length == 0) {// Ŀ¼��û���ļ�����Ŀ¼��ɾ��
                        file.delete();
                    }
                }
            }
        }
    }

    private static List<File> getAllFileFromFileDir(String dirPath) {
        ArrayList<File> fileList = new ArrayList<File>();
        File file = new File(dirPath);
        if (!file.exists()) {
            return fileList;
        }
        if (!file.isDirectory()) {
            fileList.add(file);
        } else if (file.isDirectory()) {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File readfile = new File(dirPath + "/" + filelist[i]);
                if (!readfile.isDirectory()) {
                    fileList.add(readfile);
                } else if (readfile.isDirectory()) {
                    getAllFileFromFileDir(dirPath + "/" + filelist[i]);
                }
            }

        }
        return fileList;
    }

    public static void saveCityWeatherDb(Context context) {
        String DB_PATH = "data/data/com.libokeji.beansass/databases/";
        String DB_NAME = "weather_city_info.db";
        File f = new File(DB_PATH);
        File file = new File(DB_PATH + DB_NAME);

        if (file.exists()) {
            return;
        }
        if (!f.exists()) {
            f.mkdir();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.exists()) {
            try {
                InputStream is = context.getAssets().open("weather/" + DB_NAME);
                OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                // 关闭文件流
                os.flush();
                os.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 判断 sd 卡是否可用
     *
     * @return
     */
    public static boolean ExistSDCard() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else
            return false;
    }

    public static boolean isExistFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return false;
        }
        return true;
    }

    /**
     * 获取 文件，根据文件夹路径，文件名。 </br>
     * 首先判断 文件夹是否存在，然后在 返回 文件File </br>
     * 如果 sdk不可用 则 返回空
     *
     * @param filePath 文件夹路径,
     * @param fileName 文件名
     * @return
     */
    public static File getFile(String filePath, String fileName) {
        if (ExistSDCard()) {
            File fileDir = new File(filePath);
            if (!isExistFile(filePath)) {
                fileDir.mkdirs();
            }
            return new File(filePath, fileName);
        } else {
            return null;
        }
    }

    /**
     * 获取文件格式 ，同 (see {@link #getFile(String filePath, String fileName)}
     *
     * @param filePath
     * @return
     */
    public static File getFile(String filePath) {
        if (ExistSDCard())
            return new File(filePath);
        else
            return null;
    }

    /**
     * 写数据 缓存数据到 读写/data/data/目录上的文件:
     *
     * @param context
     * @param fileName
     * @param writestr
     */
    public static void saveCacheFile(Context context, String fileName, String writestr) {
        try {
            FileOutputStream fout = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            byte[] bytes = writestr.getBytes();
            fout.write(bytes);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读写/data/data/目录上的文件:
     *
     * @param context
     * @param fileName
     * @return
     */
    public static String readCacheFile(Context context, String fileName) {
        String res = "";
        try {
            FileInputStream fin = context.openFileInput(fileName);
            int length = fin.available();
            byte[] buffer = new byte[length];
            fin.read(buffer);
            res = EncodingUtils.getString(buffer, "UTF-8");
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }

    /**
     * 缓存文件是否存在
     *
     * @param context
     * @param fileName
     * @return
     */
    public static boolean isCacheExist(Context context, String fileName) {
        if (!context.getDir(fileName, Context.MODE_PRIVATE).exists()) {
            return false;
        }
        return true;
    }
}
