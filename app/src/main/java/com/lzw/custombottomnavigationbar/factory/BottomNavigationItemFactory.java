package com.lzw.custombottomnavigationbar.factory;

import android.content.Context;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.lzw.custombottomnavigationbar.Constant.ItemStatus;

import java.util.ArrayList;
import java.util.Map;

/**
 * 描述：
 *
 * @author luzhaowei
 * @email luzhaowei@hztianque.com
 * @time 2017/8/25
 */
public class BottomNavigationItemFactory {

    private Context mContext;
    private BottomNavigationBar mBottomNavigationBar;
    private int mIconResource;
    private int mTitle;
    private int mActiveColor;
    private ArrayList<Integer> mIconResourceList;
    private ArrayList<Integer> mTitleList;
    private Map<Integer,Integer> mIconTitleItemMap;//key是mIconResourceList，value是mTitleList

    public BottomNavigationItemFactory(Context context, BottomNavigationBar navigationBar,
                                       int iconResource, int title, int activeColor) {
        this.mContext = context;
        this.mBottomNavigationBar = navigationBar;
        this.mIconResource = iconResource;
        this.mTitle = title;
        this.mActiveColor = activeColor;
    }


    public BottomNavigationItemFactory(Context context, BottomNavigationBar navigationBar,
                                       ArrayList iconResourceList, ArrayList titleList, int activeColor) {
        this.mContext = context;
        this.mBottomNavigationBar = navigationBar;
        this.mIconResourceList = iconResourceList;
        this.mTitleList = titleList;
        this.mActiveColor = activeColor;
    }


    public BottomNavigationItemFactory(Context context, BottomNavigationBar navigationBar,
                                       Map iconTitleItemMap, int activeColor) {
        this.mContext = context;
        this.mBottomNavigationBar = navigationBar;
        this.mIconTitleItemMap = iconTitleItemMap;
        this.mActiveColor = activeColor;
    }


    public BottomNavigationBar getItemFactory(int statusNumber){
        BottomNavigationBar navigationBar = null;
        switch (statusNumber){
            case ItemStatus.ITEM_NORMAL:
                navigationBar = addItems(mIconResource, mTitle, mActiveColor);
                break;
             case ItemStatus.ITEM_WITH_LIST:
                 navigationBar = addItems(mIconResourceList, mTitleList, mActiveColor);
            break;
             case ItemStatus.ITEM_WITH_MAP:
                 navigationBar = addItems(mIconTitleItemMap, mActiveColor);
            break;
        }
        return navigationBar;
    }


    private BottomNavigationBar addItems(int iconResource, int title, int activeColor) {
        return this.mBottomNavigationBar
                        .addItem(setBottomNavigationItems(iconResource,title)
                        .setActiveColor(activeColor));
    }


    private BottomNavigationBar addItems(ArrayList<Integer> iconResourceList, ArrayList<Integer> titleList, int activeColor) {
        BottomNavigationBar navigationBar = null;
        for(int i = 0;i< iconResourceList.size(); i++){
            BottomNavigationItem item = setBottomNavigationItems(iconResourceList, titleList);
            navigationBar = mBottomNavigationBar.addItem(item).setActiveColor(activeColor);
        }
        return navigationBar;
    }


    private BottomNavigationBar addItems(Map<Integer, Integer> iconTitleItemMap, int activeColor) {
        BottomNavigationBar navigationBar = null;
        for(Map.Entry<Integer,Integer> entry : iconTitleItemMap.entrySet()){
            int key = entry.getKey();
            String result = mContext.getResources().getString(entry.getValue());
            BottomNavigationItem item = new BottomNavigationItem(key, result);
            navigationBar = mBottomNavigationBar.addItem(item).setActiveColor(activeColor);
        }
        return navigationBar;
    }


    private BottomNavigationItem setBottomNavigationItems(int iconResource, int title) {
        return new BottomNavigationItem(iconResource, setTitleText(title));
    }


    private BottomNavigationItem setBottomNavigationItems(ArrayList<Integer> iconResourceList,
                                          ArrayList<Integer> titleList) {
        BottomNavigationItem navigationItem = null;
        for(int i = 0;i< iconResourceList.size(); i++){
            navigationItem = new BottomNavigationItem(iconResourceList.get(i), setTitleText(titleList));
        }
        return navigationItem;
    }


    private String setTitleText(int title) {
        return mContext.getResources().getString(title);
    }


    private String setTitleText(ArrayList<Integer> titleList) {
        String result = "";
        for(int i = 0;i< titleList.size(); i++){
            result = mContext.getResources().getString(titleList.get(i));
        }
        return result;
    }


}
