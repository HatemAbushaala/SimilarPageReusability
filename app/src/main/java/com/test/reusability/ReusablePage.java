package com.test.reusability;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

public class ReusablePage extends LinearLayout {

    private TextView titleTv;
    private Button addBtn;
    private ListView listView;

    // this constructor used when creating object by developer
    public ReusablePage(Context context) {
        super(context);
        init("");
    }

    // this constructor used when creating the view by xml layout
    public ReusablePage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // these 3 lines to get attribute from xml
        TypedArray t = getContext().obtainStyledAttributes(attrs,R.styleable.ReusablePage);
        String title = t.getString(R.styleable.ReusablePage_title);
        t.recycle();

        init(title);
    }

    // i don't know when it's used but i think it's called when you pass a style attribute from xml
    public ReusablePage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray t = getContext().obtainStyledAttributes(attrs,R.styleable.ReusablePage);
        String title = t.getString(R.styleable.ReusablePage_title);
        t.recycle();

        init(title);
    }

    // initalize viewsn
    private void init(String title) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_reuseable_page, this);

        titleTv = (TextView) findViewById(R.id.title);
        addBtn = (Button) findViewById(R.id.btn);
        listView = (ListView) findViewById(R.id.lv);

        titleTv.setText(title);
        addBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo what add button should do
            }
        });
    }

    // main layout methods

    public void setTitle(String title)
    {
        titleTv.setText(title);
    }

    // changed to RecycleView.Adapter if you want to use recycle view
    public void setListView(ArrayAdapter<String> adapter, AdapterView.OnItemClickListener listener)
    {
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listener);
    }


}