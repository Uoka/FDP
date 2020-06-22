package org.ddd.yzf.strategy.chart.components.impl;

import org.ddd.yzf.strategy.chart.components.BaseChart;
import org.ddd.yzf.util.MyTool;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * 饼图
 */
@Component("pieChart")
public class PieChart implements BaseChart {


    private String title = null; // 图表标题
    private DefaultPieDataset dataset = null; // 数据集
    private Boolean isShowLegend = null; // 是否显示图例
    private Integer width; // 图片宽度
    private Integer height; // 图片高度



    @Override
    public BufferedImage getChart(Map<String, Object> dataMap) {

        if (injectData(dataMap)) {

            // 生成图表
            JFreeChart chart = ChartFactory.createPieChart(
                    title,
                    dataset,
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
