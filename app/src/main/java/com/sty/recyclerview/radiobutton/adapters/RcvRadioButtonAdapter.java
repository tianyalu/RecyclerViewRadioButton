package com.sty.recyclerview.radiobutton.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sty.recyclerview.radiobutton.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Steven.T on 2017/10/12/0012.
 */

public class RcvRadioButtonAdapter extends BaseRcvAdapter<RcvListItem> {

    public RcvRadioButtonAdapter(Context context, List<RcvListItem> data){
        super(context, data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rcv_radio_button_item, parent, false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RcvListItem item = mData.get(position);
        ListItemViewHolder listItemViewHolder = (ListItemViewHolder) holder;
        listItemViewHolder.listIcon.setImageResource(item.getIcon());
        listItemViewHolder.listText.setText(mContext.getResources().getString(item.getName()));
        listItemViewHolder.listRadioButton.setChecked(item.isChecked());

        bindOnItemClickListener(listItemViewHolder, position, item);
    }

    private static class ListItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView listIcon;
        private TextView listText;
        private RadioButton listRadioButton;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            listIcon = itemView.findViewById(R.id.iv_list_icon);
            listText = itemView.findViewById(R.id.tv_list_text);
            listRadioButton = itemView.findViewById(R.id.rb_radio_button);
        }
    }

    @Override
    public void bindOnItemClickListener(final RecyclerView.ViewHolder holder, final int position, final RcvListItem item) {
        if(null == holder){
            return;
        }
        //为RadioButton所在的Item View设置点击监听事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRadioIsChecked(position);
                if(null != mOnItemClickListener){
                    mOnItemClickListener.onItemClick(view, holder.getLayoutPosition(), item);
                }
            }
        });
    }

    private void setRadioIsChecked(int position){
        for(int i = 0; i < mData.size(); i++){
            if(i == position){
                mData.get(i).setChecked(true);
            }else{
                mData.get(i).setChecked(false);
            }
        }
        notifyDataSetChanged();
    }

    public static List<RcvListItem> buildList(){
        return Arrays.asList(
                new RcvListItem(R.string.alipay, R.mipmap.alipay_icon, true),
                new RcvListItem(R.string.wechat_pay, R.mipmap.wechat_icon, false));
    }
}
