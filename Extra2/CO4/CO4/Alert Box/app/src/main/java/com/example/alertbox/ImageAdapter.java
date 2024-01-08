package com.example.alertbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c)
    {
        mContext=c;
    }
    @Override
    public int getCount() {
        return thumbimages.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView=new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(200,200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8,8,8,8);
        imageView.setImageResource(thumbimages[i]);
        return  imageView;

    }

    public  Integer[] thumbimages=
            {
                    R.drawable.cl1,
                    R.drawable.cl2,
                    R.drawable.cl3,
                    R.drawable.cl4,
                    R.drawable.cl5,
                    R.drawable.cl6

            };
}
