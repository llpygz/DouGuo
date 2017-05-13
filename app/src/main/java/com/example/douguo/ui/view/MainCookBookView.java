package com.example.douguo.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.douguo.R;
import com.example.douguo.app.AppContext;
import com.example.douguo.bean.main.MainHeader;
import com.example.douguo.widget.CircleImageView;

/**
 * Created by Administrator on 2016/11/5.
 */

public class MainCookBookView extends RelativeLayout {
    private ImageView mImageView;
    private TextView mTitleView, mUserTextView;
    private CircleImageView mUserImageView;

    public MainCookBookView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_main_cook_book, this, true);
        init(context);
    }

    private void init(Context context) {
        mImageView = (ImageView) findViewById(R.id.iv_bg);
        mTitleView = (TextView) findViewById(R.id.tv_title);
        mUserTextView = (TextView) findViewById(R.id.tv_name);
        mUserImageView = (CircleImageView) findViewById(R.id.civ_user);
    }

    public void initDate(MainHeader mainHeader) {
        AppContext.getLoader().load(mainHeader.getB().getI()).into(mImageView);
        AppContext.getLoader().load(mainHeader.getU().getP()).asBitmap().into(mUserImageView);
        mTitleView.setText(mainHeader.getT());
        mUserTextView.setText(mainHeader.getU().getN());
    }
}
