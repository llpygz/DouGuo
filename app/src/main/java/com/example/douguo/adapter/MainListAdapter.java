package com.example.douguo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.douguo.R;
import com.example.douguo.app.AppContext;
import com.example.douguo.bean.main.BaseMainList;
import com.example.douguo.bean.main.M;
import com.example.douguo.bean.main.TA;
import com.example.douguo.widget.CircleImageView;

/**
 * Created by Administrator on 2016/11/5.
 */

public class MainListAdapter extends BaseRecyclerAdapter<BaseMainList> implements BaseRecyclerAdapter.OnLoadingHeaderCallBack {

    public MainListAdapter(Context context, int mode) {
        super(context, mode);
        setOnLoadingHeaderCallBack(this);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new MainListAdapter.CookBookViewHolder(mInflater.inflate(R.layout.item_list_main_list, parent, false));
    }

    @Override
    protected void onBindDefaultViewHolder(RecyclerView.ViewHolder holder, BaseMainList item, int position) {
        CookBookViewHolder holderM = (CookBookViewHolder) holder;
        M m = item.getM();
        TA ta = item.getTa();
        com.example.douguo.bean.main.R r = item.getR();
        if (m != null) {
            AppContext.getLoader().load(m.getB()).into(holderM.mBook);
            holderM.mCountText.setText("共" + m.getC() + "道菜");
            holderM.mTitleText.setText(m.getT());
            holderM.mUserNameText.setText("由" + m.getA().getN() + "创建");
            holderM.ll_ta.setVisibility(View.GONE);
            holderM.ll_user.setVisibility(View.GONE);
            holderM.ll_m.setVisibility(View.VISIBLE);
        } else if (ta != null) {
            holderM.ll_ta.setVisibility(View.VISIBLE);
            holderM.ll_m.setVisibility(View.GONE);
            holderM.ll_user.setVisibility(View.GONE);
            holderM.mTaTitleText.setText(ta.getT());
            holderM.mTaContentText.setText(ta.getC());
            AppContext.getLoader().load(ta.getI()).into(holderM.mBook);
            holderM.mTaContentText.setVisibility(TextUtils.isEmpty(ta.getC()) ? View.GONE:View.VISIBLE);
        }else if(r != null){
            holderM.ll_user.setVisibility(View.VISIBLE);
            holderM.ll_ta.setVisibility(View.VISIBLE);
            holderM.ll_m.setVisibility(View.GONE);
            holderM.mRNameText.setText(r.getA().getN());
            holderM.mTaTitleText.setText(r.getN());
            holderM.mTaContentText.setText(r.getCookstory());
            AppContext.getLoader().load(r.getImg()).into(holderM.mBook);
            AppContext.getLoader().load(r.getA().getP()).asBitmap().into(holderM.mUserImage);
            holderM.mTaContentText.setVisibility(TextUtils.isEmpty(r.getCookstory()) ? View.GONE:View.VISIBLE);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderHolder(ViewGroup parent) {
        return new HeaderViewHolder(mHeaderView);
    }

    @Override
    public void onBindHeaderHolder(RecyclerView.ViewHolder holder, int position) {

    }

    private static class CookBookViewHolder extends RecyclerView.ViewHolder {
        ImageView mBook;
        CircleImageView mUserImage;
        TextView mRNameText;
        TextView mCountText, mTitleText, mUserNameText;
        LinearLayout ll_m, ll_ta, ll_user;
        TextView mTaTitleText, mTaContentText;

        public CookBookViewHolder(View itemView) {
            super(itemView);
            mBook = (ImageView) itemView.findViewById(R.id.iv_book);
            mCountText = (TextView) itemView.findViewById(R.id.tv_count);
            mTitleText = (TextView) itemView.findViewById(R.id.tv_title);
            mUserNameText = (TextView) itemView.findViewById(R.id.tv_user_name);
            ll_m = (LinearLayout) itemView.findViewById(R.id.ll_m);
            ll_ta = (LinearLayout) itemView.findViewById(R.id.ll_ta);
            ll_user = (LinearLayout) itemView.findViewById(R.id.ll_user);
            mTaTitleText = (TextView) itemView.findViewById(R.id.tv_ta_title);
            mTaContentText = (TextView) itemView.findViewById(R.id.tv_ta_content);
            mUserImage = (CircleImageView)itemView.findViewById(R.id.civ_user);
            mRNameText = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
