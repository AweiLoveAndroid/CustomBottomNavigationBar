package com.lzw.custombottomnavigationbar.interfaces;

import android.content.Context;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

import java.util.ArrayList;
import java.util.Map;

/**
 * 写一个工厂的接口
 * 这里写了三个抽象方法，分别是普通方式，list集合，map集合形式传参数进来
 * @author luzhaowei
 * @time 2017/8/25
 */
public interface IBottomBarFactory {

    /**
     *
     * @param context 上下文
     * @param navigationBar BottomNavigationBar对象
     * @param iconResource tab图标
     * @param title  tab文字
     * @param activeColor
     * @return  BottomNavigationBar对象
     */
     BottomNavigationBar createItemViewNormal(Context context,BottomNavigationBar navigationBar,
                                                    int iconResource, int title, int activeColor);


    /**
     *
     * @param context 上下文
     * @param navigationBar BottomNavigationBar对象
     * @param iconResourceList tab的图标集合
     * @param titleList tab的文字集合
     * @param activeColor
     * @return BottomNavigationBar对象
     */
     BottomNavigationBar createItemViewWithList(Context context, BottomNavigationBar navigationBar,
                                                ArrayList iconResourceList, ArrayList titleList, int activeColor);


    /**
     *
     * @param context 上下文
     * @param navigationBar BottomNavigationBar对象
     * @param iconTitleItemMap tab的图标和文字的集合
     * @param activeColor
     * @return BottomNavigationBar对象
     */
     BottomNavigationBar createItemViewWithMap(Context context, BottomNavigationBar navigationBar,
                                               Map iconTitleItemMap, int activeColor);


}
