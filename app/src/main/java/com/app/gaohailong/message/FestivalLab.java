package com.app.gaohailong.message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donglinghao on 2015-10-13.
 */
public class FestivalLab {

    public static FestivalLab mInstance;

    private List<Festival> mFestivals = new ArrayList<Festival>();

    private FestivalLab() {
        mFestivals.add(new Festival(1,"国庆节"));
        mFestivals.add(new Festival(1,"中秋节"));
        mFestivals.add(new Festival(1,"七夕节"));
        mFestivals.add(new Festival(1,"端午"));
        mFestivals.add(new Festival(1,"儿童节"));
        mFestivals.add(new Festival(1,"劳动节"));
        mFestivals.add(new Festival(1,"圣诞"));
        mFestivals.add(new Festival(1,"春节"));
    }

    public List<Festival> getFestivals(){
        return new ArrayList<Festival>(mFestivals);
    }

    public Festival getFestivalById(int festivalId){
        for (Festival festival : mFestivals){
            if (festival.getId() == festivalId){
                return festival;
            }
        }
        return null;
    }

    public static FestivalLab getInstance(){
        if (mInstance == null){
            synchronized (FestivalLab.class){
                if (mInstance == null){
                    mInstance = new FestivalLab();
                }
            }
        }
        return mInstance;
    }
}
