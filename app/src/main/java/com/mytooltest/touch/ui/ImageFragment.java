package com.mytooltest.touch.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mytooltest.R;


public class ImageFragment extends Fragment {

    private Context mContext;
    ImageView mIV;

    public static final String KEY = "imageId";
    private int mImageId = -1;

    public static ImageFragment newInstance(int imageId) {
        ImageFragment imageFragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY, imageId);
        imageFragment.setArguments(bundle);
        return imageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mContext = container.getContext();
        View view = View.inflate(mContext, R.layout.fragment_image, null);
        mIV = view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mImageId = arguments.getInt(KEY, -1);
            if (mImageId != -1) {
                mIV.setImageResource(mImageId);
            }
        }
    }
}
