package com.introid.videostreaming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class SlidePagerAdapter extends PagerAdapter {
    private Context mContext;
    List<Slide> mList= new ArrayList<>();


    public SlidePagerAdapter(Context mContext, List<Slide> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate( R.layout.slider_item,container,false );

        ImageView slideImg= view.findViewById( R.id.slide_img );
        TextView slideTxt= view.findViewById( R.id.slide_title );

        slideImg.setImageResource( mList.get( position ).getImage() );
        slideTxt.setText( mList.get( position ).getTitle() );

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView( (View) object );
    }
}
