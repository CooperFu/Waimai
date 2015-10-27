package io.github.naotou.gradlewaimai.fragment;

import io.github.naotou.gradlewaimai.R;
import io.github.naotou.gradlewaimai.framework.BaseFrag;

/**
 * Create by Android Studio
 * User: FuQiang(fuqiang@uniqueway.com)
 * Date: 2015-10-27
 * Time: 15-14
 */
public class MyFrag extends BaseFrag {

    @Override public int createViewById() {
        return R.layout.frag_my;
    }

    @Override protected void initViews() {
        super.initViews();
        //设置返回箭头不显示
        setBackHomeIndicator(false);
    }
}
