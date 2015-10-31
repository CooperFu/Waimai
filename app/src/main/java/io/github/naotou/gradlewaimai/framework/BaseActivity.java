package io.github.naotou.gradlewaimai.framework;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import io.github.naotou.gradlewaimai.R;


/**
 * Created by gaopengfei on 15/6/24.
 */
public abstract class BaseActivity extends AppCompatActivity{


    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initToolbar();
        initViews();
        initEvents();
    }

    protected void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            mToolbar.setContentInsetsAbsolute(0, 0);
        }
    }

    protected void initViews() {
    }

    protected void initEvents() {
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            back();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void back() {
        finish();
    }


}
