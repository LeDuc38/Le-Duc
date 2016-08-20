package com.example.dell.twmusic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.twmusic.Navi;
import com.example.dell.twmusic.R;

import java.util.List;

/**
 * Created by DELL on 8/20/2016.
 */
public class AdapterNavigation extends BaseAdapter {
    private List<Navi> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterNavigation(Context context, List<Navi> listData) {
        this.listData = listData;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        if (listData == null || listData.isEmpty())
            return 0;
        return listData.size();
    }

    @Override
    public Object getItem(int position) {

        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_row_navi, null);
            holder = new ViewHolder();
            holder.ivicon = (ImageView) view.findViewById(R.id.ivicon);
            holder.tvitem = (TextView) view.findViewById(R.id.tvitem);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Navi navi = this.listData.get(position);
        holder.ivicon.setImageResource(navi.getI());
        holder.tvitem.setText(navi.getStr());

        return view;
    }

    static class ViewHolder {
        ImageView ivicon;
        TextView tvitem;
    }
}
