package io.makershive.multiviewrecyclersample.Model;

public class DataModel {
    private String titleName, imageLoc, timeStamp;
    private int viewType;

    public DataModel(String titleName, String imageLoc, String timeStamp, int viewType) {
        this.titleName = titleName;
        this.imageLoc = imageLoc;
        this.timeStamp = timeStamp;
        this.viewType = viewType;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getImageLoc() {
        return imageLoc;
    }

    public void setImageLoc(String imageLoc) {
        this.imageLoc = imageLoc;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
