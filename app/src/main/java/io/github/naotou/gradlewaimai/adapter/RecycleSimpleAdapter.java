package io.github.naotou.gradlewaimai.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import io.github.naotou.gradlewaimai.R;

/**
 * Create by Android Studio
 * User: FuQiang(fuqiang@uniqueway.com)
 * Date: 2015-10-27
 * Time: 17-03
 */
public class RecycleSimpleAdapter extends RecyclerView.Adapter<RecycleSimpleAdapter.ViewHolder> {

    private int count = 10;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(parent.getContext(), R.layout.item_rent_layout, null));
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mAskImageView.setImageURI(Uri.parse("http://img4.imgtn.bdimg.com/it/u=3847441787,808720527&fm=21&gp=0.jpg"));
    }

    @Override public int getItemCount() {
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private SimpleDraweeView mAskImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mAskImageView = (SimpleDraweeView) itemView.findViewById(R.id.item_image);
        }
    }
}
