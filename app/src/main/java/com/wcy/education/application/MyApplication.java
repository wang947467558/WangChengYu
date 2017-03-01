package com.wcy.education.application;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.wcy.education.utils.AppConstant;
import com.wcy.education.utils.FileUtil;

import java.io.IOException;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class MyApplication extends Application {

    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        //图片加载
        initImageLoader(this);
    }

    private void initImageLoader(Context context) {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        //创建自己的图片加载器
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .threadPoolSize(10)
                .memoryCache(new LruMemoryCache(maxMemory / 4))
                .memoryCacheSizePercentage(40);


        try {
            config.diskCache(new LruDiskCache(FileUtil.getFile(AppConstant.IMAGE_SD_PATH), new Md5FileNameGenerator(), 0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageLoader.getInstance().init(config.build());

    }


    //提供外部类得到当前类
    public static MyApplication getContext() {
        if (null == application) {
            application = new MyApplication();
        }
        return application;
    }
}
