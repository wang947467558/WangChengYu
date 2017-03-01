package com.wcy.education.entity;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class ImageInfo {

    private String topId;
    private String topImage;
    private String linkAddress;
    private String topStatus;

    public String getLinkAddress() {
        return linkAddress;
    }

    public String getTopId() {
        return topId;
    }

    public String getTopImage() {
        return topImage;
    }

    public String getTopStatus() {
        return topStatus;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public void setTopId(String topId) {
        this.topId = topId;
    }

    public void setTopImage(String topImage) {
        this.topImage = topImage;
    }

    public void setTopStatus(String topStatus) {
        this.topStatus = topStatus;
    }
}
