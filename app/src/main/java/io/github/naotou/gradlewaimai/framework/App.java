package io.github.naotou.gradlewaimai.framework;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;

import io.github.naotou.gradlewaimai.global.Configs;

/**
 * Create by Android Studio
 * User: FuQiang(fuqiang@uniqueway.com)
 * Date: 2015-10-27
 * Time: 13-55
 */
public class App extends Application {

    public static Context mContext;

    @Override public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
        ImagePipelineConfig frescoConfig = ImagePipelineConfig.newBuilder(getApplicationContext()).setProgressiveJpegConfig(new ProgressiveJpegConfig() {
            @Override public int getNextScanNumberToDecode(int scanNumber) {
                return scanNumber + 1;
            }

            @Override public QualityInfo getQualityInfo(int scanNumber) {
                boolean isGood = (scanNumber >= 3);
                return ImmutableQualityInfo.of(scanNumber, isGood, false);
            }
        }).build();
        Fresco.initialize(getApplicationContext(), frescoConfig);

        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        Configs.SCREEN_WIDTH = metrics.widthPixels;
        Configs.SCREEN_HEIGHT = metrics.heightPixels;
    }

    public static Context getContext() {
        return mContext;
    }


    @Override
    public void onLowMemory() {
        android.os.Process.killProcess(android.os.Process.myPid());
        super.onLowMemory();
    }

    public void exitApp() {
        System.gc();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
