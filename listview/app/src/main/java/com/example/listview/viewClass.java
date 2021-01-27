package com.example.listview;

public class viewClass {

    private String mPlayer;
    private int mPoint;
    private int mAssist;
    private int mRebound;
    private int mSteal;
    private int mBlock;
    private int mTurnOver;

    public viewClass(String player, int point, int assist, int rebound, int steal, int block, int turnover) {
        mPlayer = player;
        mPoint = point;
        mAssist = assist;
        mRebound = rebound;
        mSteal = steal;
        mBlock = block;
        mTurnOver = turnover;
    }

    public String getmPlayer() {
        return mPlayer;
    }
    public int getmPoint() { return ++mPoint; }
    public int getmAssist() { return ++mAssist; }
    public int getmRebound() { return ++mRebound; }
    public int getmSteal() { return ++mSteal; }
    public int getmBlock() { return ++mBlock; }
    public int getmTurnOver() { return ++mTurnOver; }







}
