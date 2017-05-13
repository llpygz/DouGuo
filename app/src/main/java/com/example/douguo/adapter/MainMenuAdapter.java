package com.example.douguo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.douguo.R;
import com.example.douguo.app.AppContext;
import com.example.douguo.bean.main.Main;
import com.example.douguo.bean.main.MainMenu;
import com.example.douguo.widget.CircleImageView;

/**
 * Created by Administrator on 2016/11/5.
 */

public class MainMenuAdapter extends BaseRecyclerAdapter<MainMenu> {
    public MainMenuAdapter(Context context, int mode) {
        super(context, mode);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new MenuViewHolder(mInflater.inflate(R.layout.item_list_main_menu, parent, false));
    }

    @Override
    protected void onBindDefaultViewHolder(RecyclerView.ViewHolder holder, MainMenu item, int position) {
        MenuViewHolder menuViewHolder = (MenuViewHolder) holder;
        menuViewHolder.mMenuText.setText(item.getT());
        AppContext.getLoader().load(item.getI()).asBitmap().into(menuViewHolder.mImageMenu);
    }

    private static class MenuViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView mImageMenu;
        private TextView mMenuText;

        public MenuViewHolder(View itemView) {
            super(itemView);
            mImageMenu = (CircleImageView) itemView.findViewById(R.id.civ_menu);
            mMenuText = (TextView) itemView.findViewById(R.id.tv_menu);
        }
    }
}
