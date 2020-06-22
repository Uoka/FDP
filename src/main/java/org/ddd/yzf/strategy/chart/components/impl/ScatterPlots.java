package org.ddd.yzf.strategy.chart.components.impl;

import org.ddd.yzf.strategy.chart.components.BaseChart;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * 散点图
 */
@Component("scatterPlots")
public class ScatterPlots implements BaseChart {

    @Override
    public BufferedImage getChart(Map<String, Object> dataMap) {
        return null;
    }

}
