package org.ddd.yzf.strategy.chart;

import org.ddd.yzf.strategy.chart.components.BaseChart;
import org.ddd.yzf.strategy.chart.tools.ChartType;
import org.ddd.yzf.strategy.chart.tools.ChartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 图表生成器
 */
@Component("chartBuilder")
public class ChartBuilder {

    private final Map<String, BaseChart> chartMap = new ConcurrentHashMap<>();

    static {
        ChartUtils.setChartTheme();
    }

    @Autowired
    public ChartBuilder(Map<String, BaseChart> chartMap) {
        chartMap.forEach(this.chartMap::put);
    }

    public BufferedImage getChart(ChartType chartType, Map<String, Object> dataMap){
        return this.chartMap.get(chartType.getType()).getChart(dataMap);
    }

}
