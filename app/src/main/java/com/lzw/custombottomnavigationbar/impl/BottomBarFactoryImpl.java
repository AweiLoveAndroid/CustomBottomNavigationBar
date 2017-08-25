package com.lzw.custombottomnavigationbar.impl;

import android.content.Context;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.lzw.custombottomnavigationbar.Constant.ItemStatus;
import com.lzw.custombottomnavigationbar.factory.BottomNavigationItemFactory;
import com.lzw.custombottomnavigationbar.interfaces.IBottomBarFactory;

import java.util.ArrayList;
import java.util.Map;

/**
 * 写一个工厂类的实现类,封装具体的操作
 *
 * @author luzhaowei
 * @time 2017/8/25
 */
public class BottomBarFactoryImpl implements IBottomBarFactory {


    @Override
    public BottomNavigationBar createItemViewNormal(Context context, BottomNavigationBar navigationBar,
                                                    int iconResource, int title, int activeColor) {
        return new BottomNavigationItemFactory(context, navigationBar, iconResource,
                title, activeColor).getItemFactory(ItemStatus.ITEM_NORMAL);
    }

    @Override
    public BottomNavigationBar createItemViewWithList(Context context, BottomNavigationBar navigationBar,
                                                      ArrayList iconResourceList, ArrayList titleList, int activeColor) {
        return new BottomNavigationItemFactory(context, navigationBar, iconResourceList,
                titleList, activeColor).getItemFactory(ItemStatus.ITEM_WITH_LIST);
    }

    @Override
    public BottomNavigationBar createItemViewWithMap(Context context, BottomNavigationBar navigationBar,
                                                     Map iconTitleItemMap, int activeColor) {
        return new BottomNavigationItemFactory(context, navigationBar,
                iconTitleItemMap, activeColor).getItemFactory(ItemStatus.ITEM_WITH_MAP);
    }


}
