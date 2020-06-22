package org.ddd.yzf.strategy.chart.components.impl;

import org.ddd.yzf.strategy.chart.components.BaseChart;
import org.ddd.yzf.util.MyTool;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * @author 袁泽锋
 * @since 2019年12月15日 19:44
 * Description: 柱状图
 */
@Component("columnChart")
public class ColumnChart implements BaseChart {

    private String title = null; // 图表标题
    private DefaultCategoryDataset dataset = null; // 数据集
    private PlotOrientation plotOrientation = PlotOrientation.VERTICAL; // 取向
    private String categoryAxisLabel = null; //标题
    private String valueAxisLabel = null; // 数值
    private Integer width; // 图片宽度
    private Integer height; // 图片高度

    @Override
    public BufferedImage getChart(Map<String, Object> dataMap) {

        if (injectData(dataMap)) {

            JFreeChart chart = ChartFactory.createBarChart(
                    title,
                    categoryAxisLabel,
                    valueAxisLabel,
                    dataset,
                    plotOrientation,
                    true,
                    true,
                    true);

            return chart.createBufferedImage(width, height);
        }
        return null;
    }

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
        Boolean useVERTICAL = MyTool.cast(dataMap.get("useVERTICAL"));
        if (useVERTICAL != null && !useVERTICAL) {
            plotOrientation = PlotOrientation.HORIZONTAL;
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
