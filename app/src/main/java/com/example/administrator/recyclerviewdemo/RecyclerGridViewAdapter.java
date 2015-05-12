package com.example.administrator.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/5/9.
 */
public class RecyclerGridViewAdapter extends RecyclerView.Adapter<RecyclerGridViewAdapter.GridViewHolder> {

    private Context mContext;
    private ArrayList<GridItem> mDatas;

    public RecyclerGridViewAdapter(Context context,ArrayList<GridItem> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_item, null);
        GridViewHolder viewHolder = new GridViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;

        public GridViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.pic);
            name = (TextView) itemView.findViewById(R.id.name);
        }

        public void setData(int position) {
            GridItem item = mDatas.get(position);
            icon.setImageResource(item.getImgRes());
            name.setText(item.getDesc());
        }
    }

    public void addData(int position){

        mDatas.add(position,new GridItem(R.drawable.img_01,"新添加"));
        notifyItemInserted(position);
    }

    public void removeData(int position){
        mDatas.remove(position);
        notifyItemRemoved(position);
    }
}
