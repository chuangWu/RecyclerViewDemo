package com.example.administrator.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/5/9.
 */
public class RecyclerListViewAdapter extends RecyclerView.Adapter<RecyclerListViewAdapter.ListViewHolder> {
    private int mIcons[] = {R.drawable.img_01,R.drawable.img_02,R.drawable.img_03,R.drawable.img_04,R.drawable.img_05};
    private String mNames[] = {"Cloud", "Movie", "Laptop", "Loop", "Menu"};
    private Context mContext;
    private boolean mFlag;

    public RecyclerListViewAdapter(Context context, boolean flag) {
        mContext = context;
        mFlag = flag;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mFlag ? R.layout.list_item : R.layout.list_item_h, parent, false);
        ListViewHolder listViewHolder = new ListViewHolder(view);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return 1000;
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        TextView subName;

        public ListViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            name = (TextView) itemView.findViewById(R.id.name);
            subName = (TextView) itemView.findViewById(R.id.subname);
        }

        public void setData(int position) {
            icon.setImageDrawable(mContext.getResources().getDrawable(mIcons[position % 5]));
            name.setText(mNames[position % 5]);
            subName.setText("This is position " + position);
        }
    }
}
