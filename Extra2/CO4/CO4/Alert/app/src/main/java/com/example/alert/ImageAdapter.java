package com.example.alert;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.net.ConnectException;

public class ImageAdapter extends BaseAdapter {

    private Context mcontext;

    public ImageAdapter(Context c)
    {
        mcontext=c;
    }
    @Override
    public int getCount() {
        return images.length;
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
        ImageView imageView=new ImageView(mcontext);
        imageView.setLayoutParams(new GridView.LayoutParams(200,200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8,8,8,8);
        imageView.setImageResource(images[i]);
        return imageView;
    }

    public Integer images[]=
            {
                    R.drawable.cl1,R.drawable.cl2,R.drawable.cl3,R.drawable.cl4,
                    R.drawable.cl5,R.drawable.cl6};
}
