package io.github.naotou.gradlewaimai.framework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.reflect.Field;

import io.github.naotou.gradlewaimai.R;

/**
 * Created by gaopengfei on 15/7/17.
 */
public abstract class BaseFrag extends Fragment {


    protected View mRootView;

    protected ViewGroup mToolbar;

    protected View mBackView;

    protected ImageView mBackIcon;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(createViewById(), container, false);
        initToolbar();
        initViews();
        initEvents();
        return mRootView;
    }

    public abstract int createViewById();

    protected void initViews() {
    }

    protected void initToolbar() {
        if (mRootView != null) {
            mToolbar = (ViewGroup) find(R.id.toolbar);
            mBackView = find(android.R.id.home);
            mBackIcon = (ImageView) find(android.R.id.home);
        }
    }

    /**
     * 设置返回键
     */
    public void setBackHomeIndicator(boolean visible) {
        if (mBackView != null)
            if (visible==true) {
                mBackView.setVisibility(View.VISIBLE);

            } else {
                mBackView.setVisibility(View.GONE);
            }
    }


    protected void initEvents() {
    }

    protected View find(int id) {
        if (mRootView == null) {
            return null;
        }
        return mRootView.findViewById(id);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
