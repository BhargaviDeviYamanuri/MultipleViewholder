package io.makershive.multiviewrecyclersample.Model;

public class DisplayModel {
    private int viewType;
    private String monthName, reportName, reportDate;

    public DisplayModel(int viewType, String monthName, String reportName, String reportDate) {
        this.viewType = viewType;
        this.monthName = monthName;
        this.reportName = reportName;
        this.reportDate = reportDate;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }
}
