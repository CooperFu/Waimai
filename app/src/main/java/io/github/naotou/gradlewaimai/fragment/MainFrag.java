package io.github.naotou.gradlewaimai.fragment;

import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import io.github.naotou.gradlewaimai.R;
import io.github.naotou.gradlewaimai.adapter.ListViewSimpleAdapter;
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
    private ListView mListView;
    private View header;


    @Override public int createViewById() {
        return R.layout.frag_main;
    }


    @Override protected void initViews() {
        mListView = (ListView) find(R.id.main_listview);
        header = LayoutInflater.from(getActivity()).inflate(R.layout.listview_header, null);

        mViewPager = (ViewPager) header.findViewById(R.id.main_viewpager);
        mIndicator = (CirclePageIndicator) header.findViewById(R.id.main_indicator);
    }

    @Override protected void initEvents() {

        mImage = new String[]{
                "http://ww1.sinaimg.cn/large/7a8aed7bjw1exe9ssy2gsj20qo0hndjr.jpg",
                "http://ww3.sinaimg.cn/large/7a8aed7bjw1ex9nm11pbnj20hs0qo0u2.jpg",
                "http://ww2.sinaimg.cn/large/7a8aed7bjw1exfffnlf2gj20hq0qoju9.jpg"};


        mListView.addHeaderView(header, null, false);
        mViewPager.setAdapter(new PicAdapter());
        mIndicator.setViewPager(mViewPager);
        mListView.setAdapter(new ListViewSimpleAdapter());
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
