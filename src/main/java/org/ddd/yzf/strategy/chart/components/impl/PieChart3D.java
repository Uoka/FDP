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
 * @author 袁泽锋
 * @since 2019年12月15日 19:13
 * Description: TODO
 */
@Component("pieChart3D")
public class PieChart3D implements BaseChart {

    private String title = null; // 图表标题
    private DefaultPieDataset dataset = null; // 数据集
    private Integer width; // 图片宽度
    private Integer height; // 图片高度

    @Override
    public BufferedImage getChart(Map<String, Object> dataMap) {
        if (injectData(dataMap)) {

            JFreeChart chart = ChartFactory.createPieChart3D(
                    title,
                    dataset,
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

