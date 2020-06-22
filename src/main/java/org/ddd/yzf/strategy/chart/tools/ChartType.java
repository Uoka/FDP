package org.ddd.yzf.strategy.chart.tools;


public enum ChartType {

    BarChart("barChart"),
    BarChart3D("barChart3D"),
    ColumnChart("columnChart"),
    LineChart("lineChart"),
    PieChart("pieChart"),
    PieChart3D("pieChart3D"),
    ScatterPlots("scatterPlots");


    ChartType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
