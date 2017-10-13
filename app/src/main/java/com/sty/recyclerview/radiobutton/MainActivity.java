package com.sty.recyclerview.radiobutton;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sty.recyclerview.radiobutton.adapters.BaseRcvAdapter;
import com.sty.recyclerview.radiobutton.adapters.RcvRadioButtonAdapter;
import com.sty.recyclerview.radiobutton.utils.ScreenMetricUtils;
import com.sty.recyclerview.radiobutton.view.DividerLinearItemDecoration;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private RcvRadioButtonAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        initViews();
        setListeners();
    }

    private void initViews(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        //DividerItemDecoration divider = new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL);
        DividerLinearItemDecoration divider = new DividerLinearItemDecoration(mContext, DividerLinearItemDecoration.VERTICAL_LIST);
        divider.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        //设置分割线的左偏移量
        divider.setDividerLeftOffset((int)getResources().getDimension(R.dimen.rcv_radio_button_item_divider_left_offset));
        mRecyclerView.addItemDecoration(divider);

        adapter = new RcvRadioButtonAdapter(mContext, RcvRadioButtonAdapter.buildList());
        mRecyclerView.setAdapter(adapter);
    }

    private void setListeners() {
        adapter.setOnItemClickListener(new BaseRcvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object item) {
                Toast.makeText(mContext, position + " is clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
