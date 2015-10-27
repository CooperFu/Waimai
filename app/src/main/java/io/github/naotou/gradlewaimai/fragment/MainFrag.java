package io.github.naotou.gradlewaimai.fragment;

import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import io.github.naotou.gradlewaimai.R;
import io.github.naotou.gradlewaimai.adapter.RecycleSimpleAdapter;
import io.github.naotou.gradlewaimai.custom.CirclePageIndicator;
import io.github.naotou.gradlewaimai.framework.BaseFrag;

/**
 * Create by Android Studio
 * User: FuQiang(fuqiang@uniqueway.com)
 * Date: 2015-10-27
 * Time: 15-14
 */
public class MainFrag extends BaseFrag {
    private ViewPager mViewPager;
    private CirclePageIndicator mIndicator;
    private String[] mImage;
    private RecyclerView mRecycler;


    @Override public int createViewById() {
        return R.layout.frag_main;
    }


    @Override protected void initViews() {
        setBackHomeIndicator(false);
        mViewPager = (ViewPager) find(R.id.main_viewpager);
        mIndicator = (CirclePageIndicator) find(R.id.main_indicator);
        mRecycler = (RecyclerView) find(R.id.main_recycler);
    }

    @Override protected void initEvents() {

        mImage = new String[]{
                "http://ww1.sinaimg.cn/large/7a8aed7bjw1exe9ssy2gsj20qo0hndjr.jpg",
                "http://ww3.sinaimg.cn/large/7a8aed7bjw1ex9nm11pbnj20hs0qo0u2.jpg",
                "http://ww2.sinaimg.cn/large/7a8aed7bjw1exfffnlf2gj20hq0qoju9.jpg"};

        mViewPager.setAdapter(new PicAdapter());
        mIndicator.setViewPager(mViewPager);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.setAdapter(new RecycleSimpleAdapter());
    }

    private class PicAdapter extends PagerAdapter {
        @Override public int getCount() {
            return mImage.length;
        }

        @Override public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override public Object instantiateItem(ViewGroup container, int position) {
            //设置图片模糊加载模式.
            SimpleDraweeView view = new SimpleDraweeView(getActivity());
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(mImage[position]))
                                                      .setProgressiveRenderingEnabled(true)
                                                      .build();
            DraweeController controller = Fresco.newDraweeControllerBuilder()
                                                .setImageRequest(request)
                                                .setOldController(view.getController())
                                                .build();
            view.setController(controller);
            container.addView(view);
            return view;
        }

        @Override public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
