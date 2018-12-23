package com.sports.yue.UI.UI.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.sports.yue.R;


/**
 * A simple {@link AppCompatActivity} subclass.
 */
public class GroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_detail);

        TextView textView1=(TextView)findViewById(R.id.details_box);
        textView1.setMovementMethod(ScrollingMovementMethod.getInstance());

        TextView textView2=(TextView)findViewById(R.id.message_box);
        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
