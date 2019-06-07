package com.example.bottom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapter.SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapter.SliderAdapterVH viewHolder, int position) {

        switch (position){
            case 0:
                Glide.with(viewHolder.itemView)
                        .load("https://images.unsplash.com/photo-1555089439-9edb4b4b8dfb?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80")
                        .into(viewHolder.iv);
                break;

            case 1:
                Glide.with(viewHolder.itemView)
                        .load("https://images.unsplash.com/photo-1547854760-f580559a870e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80")
                        .into(viewHolder.iv);
                break;

            case 2:
                Glide.with(viewHolder.itemView)
                        .load("https://i1.wp.com/digital-photography-school.com/wp-content/uploads/2013/07/ar-12.jpg?resize=600%2C338&ssl=1")
                        .into(viewHolder.iv);
                break;

            case 3:
                Glide.with(viewHolder.itemView)
                        .load("https://i.pinimg.com/originals/6c/db/4b/6cdb4bfe644c483c97ba978b979c6a14.jpg")
                        .into(viewHolder.iv);

        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    public class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView iv;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imageView2);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            this.itemView = itemView;

        }
    }
}
