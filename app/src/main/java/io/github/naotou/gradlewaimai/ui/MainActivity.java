package io.github.naotou.gradlewaimai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.naotou.gradlewaimai.R;
import io.github.naotou.gradlewaimai.fragment.MainFrag;
import io.github.naotou.gradlewaimai.fragment.MyFrag;
import io.github.naotou.gradlewaimai.fragment.OrderFrag;
import io.github.naotou.gradlewaimai.framework.BaseActivity;

public class MainActivity extends BaseActivity {

    /**
     * @param activity 方便其他类进入
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }


    private RadioGroup mRadioGroup;
    private List<Fragment> mTabFrags = new ArrayList();

    private int mCurPage;

    private FragmentManager mFragManager;


    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("page", mCurPage);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mCurPage = savedInstanceState.getInt("page");
            mRadioGroup.setOnCheckedChangeListener(null);
            mRadioGroup.check(mRadioGroup.getChildAt(mCurPage).getId());
            initEvents();
        } else {
            mRadioGroup.check(mRadioGroup.getChildAt(mCurPage).getId());
        }
    }

    @Override protected void initViews() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_radiogroup);

    }

    @Override protected void initEvents() {
        mFragManager = getSupportFragmentManager();
        mTabFrags.add(new MainFrag());
        mTabFrags.add(new OrderFrag());
        mTabFrags.add(new MyFrag());

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int x = 0; x < group.getChildCount(); x++) {
                    if (((RadioButton) group.getChildAt(x)).isChecked()) {
                        mCurPage = x;
                        break;
                    }
                }
                transFrag(mCurPage, TRANS_TYPE.TRANS);
            }
        });
    }



    /**
     * fragment 切换状态枚举
     */
    public enum TRANS_TYPE {
        OPEN, CLOSE, TRANS
    }

    public void transFrag(int page, TRANS_TYPE type) {
        FragmentTransaction ft = mFragManager.beginTransaction();
        int transit = FragmentTransaction.TRANSIT_FRAGMENT_FADE;
        switch (type) {
            case OPEN:
                transit = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
                break;
            case CLOSE:
                transit = FragmentTransaction.TRANSIT_FRAGMENT_CLOSE;
                break;
            case TRANS:
                transit = FragmentTransaction.TRANSIT_FRAGMENT_FADE;
                break;
        }
        mCurPage = page;
        //noinspection ResourceType
        ft.setTransition(transit);
        ft.replace(R.id.main_centent, mTabFrags.get(page));
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        //如果当前页不在第一页, 则点击返回回到第一页.
        if (mCurPage != 0) {
            mRadioGroup.getChildAt(0).performClick();
            return;
        } else {
            super.onBackPressed();
        }
    }
}
