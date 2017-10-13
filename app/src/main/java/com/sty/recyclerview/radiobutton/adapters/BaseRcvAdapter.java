package com.sty.recyclerview.radiobutton.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by Steven.T on 2017/10/12/0012.
 */

public abstract class BaseRcvAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickListener<T>{
        void onItemClick(View view, int position, T item);
    }

    protected OnItemClickListener mOnItemClickListener;
    protected Context mContext;
    protected List<T> mData;

    public BaseRcvAdapter(Context context, List<T> data){
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public int getItemCount() {
        if(null == mData || mData.isEmpty()) {
            return 0;
        }
        return mData.size();
    }

    public void bindOnItemClickListener(final RecyclerView.ViewHolder holder, int position, final T item){
        if(null == holder){
            return;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(null != mOnItemClickListener){
                    mOnItemClickListener.onItemClick(view, holder.getLayoutPosition(), item);
                }
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
}
