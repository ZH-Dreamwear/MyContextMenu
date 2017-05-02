package com.example.administrator.mycontextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        registerForContextMenu(textView);//2.把上下文菜单注册到textView上
    }

    private void init() {
        textView = (TextView)findViewById(R.id.textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.main,menu);//1.装填R.menu.main对应的菜单，并添加到menu中
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red:
                textView.setTextColor(Color.RED);
                Toast.makeText(MainActivity.this, "你选择了红色字体", Toast.LENGTH_SHORT).show();
                break;
            case R.id.green:
                textView.setTextColor(Color.GREEN);
                Toast.makeText(MainActivity.this, "你选择了绿色字体", Toast.LENGTH_SHORT).show();
                break;
            case R.id.blue:
                textView.setTextColor(Color.BLUE);
                Toast.makeText(MainActivity.this, "你选择了蓝色字体", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
}
