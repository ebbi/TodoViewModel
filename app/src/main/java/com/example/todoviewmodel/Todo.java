package com.example.todoviewmodel;

import java.util.Date;

public class Todo {

    private int mId;
    private String mTitle;
    private String mDetail;
    private Date mDate;
    private boolean mIsComplete;
    private boolean mIsPending;

    public int getId() {
        return mId;
    }

    public void setId(int todoId) {
        this.mId = todoId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getDetail() {
        return mDetail;
    }

    public void setDetail(String detail) {
        this.mDetail = detail;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        this.mDate = date;
    }

    public boolean isComplete() {
        return mIsComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.mIsComplete = isComplete;
    }

    public boolean isPending() {
        return mIsPending;
    }

    public void setIsPending(boolean isPending) {
        this.mIsPending = isPending;
    }
}
