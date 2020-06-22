package org.ddd.yzf.strategy.chart.components.impl;

import org.ddd.yzf.strategy.chart.components.BaseChart;
import org.ddd.yzf.strategy.chart.tools.ChartUtils;
import org.ddd.yzf.util.MyTool;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * 柱状图3D
 */
@Component("barChart3D")
public class BarChart3D implements BaseChart {

    private String title = null; // 图表标题
    private String categoryAxisLabel = null; // 目录轴的显示标签--横轴
    private String valueAxisLabel = null; // 数值轴的显示标签--纵轴
    private CategoryDataset dataset = null; // 数据集
    private PlotOrientation plotOrientation = null; // 图表方向
    private Boolean isShowLegend = null; // 是否显示图例
    private Integer width; // 图片宽度
    private Integer height; // 图片高度

    @Override
    public BufferedImage getChart(Map<String, Object> dataMap) {

        if (injectData(dataMap)) {
            ChartUtils.setChartTheme();

            // 生成图表
            JFreeChart chart = ChartFactory.createBarChart3D(
                    title,
                    categoryAxisLabel,
                    valueAxisLabel,
                    dataset,
                    plotOrientation,
                    isShowLegend,
                    false,
                    false);

            // 返回图片
            return chart.createBufferedImage(width, height);

        }
        return null;
    }

    /**
     * 将数据从map注入到对应的字段
     *
     * @param dataMap 数据map
     * @return 重要数据是否注入成功
     */
    private boolean injectData(Map<String, Object> dataMap) {
        dataset = MyTool.cast(dataMap.get("dataset"));
        if (dataset == null) {
            return false;
        }
        title = MyTool.cast(dataMap.get("title"));
        if (title == null) {
            return false;
        }
        categoryAxisLabel = MyTool.cast(dataMap.get("categoryAxisLabel"));
        if (categoryAxisLabel == null) {
            return false;
        }
        valueAxisLabel = MyTool.cast(dataMap.get("valueAxisLabel"));
        if (valueAxisLabel == null) {
            return false;
        }
        plotOrientation = MyTool.cast(dataMap.get("plotOrientation"));
        if (plotOrientation == null) {
            plotOrientation = PlotOrientation.VERTICAL;
        }
        isShowLegend = MyTool.cast(dataMap.get("isShowLegend"));
        if (isShowLegend == null) {
            isShowLegend = true;
        }
        width = MyTool.cast(dataMap.get("width"));
        if (width == null) {
            width = 400;
        }
        height = MyTool.cast(dataMap.get("height"));
        if (height == null) {
            height = 300;
        }
        return true;
    }

}
