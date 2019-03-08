package io.makershive.multiviewrecyclersample.Model;

public class ServerModel {
    private String reportName, reportDate;

    public ServerModel(String reportName, String reportDate) {
        this.reportName = reportName;
        this.reportDate = reportDate;
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
