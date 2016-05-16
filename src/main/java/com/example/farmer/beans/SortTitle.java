package com.example.farmer.beans;

import java.io.Serializable;

/**
 * Created by jqchen on 2016/5/16.
 * 此类用来描述分类一级标题
 */
public class SortTitle implements Serializable {
    private String content;
    private boolean isSeltcted;

    public SortTitle(String content, boolean isSeltcted) {
        this.content = content;
        this.isSeltcted = isSeltcted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSeltcted() {
        return isSeltcted;
    }

    public void setSeltcted(boolean seltcted) {
        isSeltcted = seltcted;
    }
}
