package io.github.naotou.gradlewaimai.adapter;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

import io.github.naotou.gradlewaimai.R;

/**
 * Create by Android Studio
 * User: FuQiang(fuqiang@uniqueway.com)
 * Date: 2015-10-27
 * Time: 17-03
 */
public class ListViewSimpleAdapter extends BaseAdapter {

    private int count = 10;


    @Override public int getCount() {
        return count;
    }

    @Override public Object getItem(int position) {
        return null;
    }

    @Override public long getItemId(int position) {
        return 0;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.item_rent_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mAskImageView.setImageURI(Uri.parse("http://img4.imgtn.bdimg.com/it/u=3847441787,808720527&fm=21&gp=0.jpg"));
        return convertView;
    }

    public class ViewHolder {


        private SimpleDraweeView mAskImageView;

        public ViewHolder(View itemView) {
            mAskImageView = (SimpleDraweeView) itemView.findViewById(R.id.item_image);
        }
    }
}
