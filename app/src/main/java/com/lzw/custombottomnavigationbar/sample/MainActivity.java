package com.lzw.custombottomnavigationbar.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.lzw.custombottomnavigationbar.R;
import com.lzw.custombottomnavigationbar.impl.BottomBarFactoryImpl;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationBar mBottomNavigationBar;
    private BottomNavigationBar mBottomNavigationBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar2 = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar2);

        //普通用法如下：
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT)
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home").setInActiveColor(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Books").setInActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music").setInActiveColor(R.color.brown))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "MoviesTV").setInActiveColor(R.color.green))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "Games").setInActiveColor(R.color.orange))
                .initialise();

        //封装之后的用法如下：
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(R.drawable.ic_home_white_24dp, R.string.tab1);
        linkedHashMap.put(R.drawable.ic_book_white_24dp, R.string.tab2);
        linkedHashMap.put(R.drawable.ic_music_note_white_24dp,R.string.tab3);
        linkedHashMap.put(R.drawable.ic_tv_white_24dp,R.string.tab4);
        linkedHashMap.put(R.drawable.ic_videogame_asset_white_24dp, R.string.tab5);
        new BottomBarFactoryImpl()
                .createItemViewWithMap(this,mBottomNavigationBar2,linkedHashMap,R.color.brown)
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT)
                .setFirstSelectedPosition(0)
                .initialise();
    }
}
