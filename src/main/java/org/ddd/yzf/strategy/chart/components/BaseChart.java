package org.ddd.yzf.strategy.chart.components;

import java.awt.image.BufferedImage;
import java.util.Map;

public interface BaseChart {

    BufferedImage getChart(Map<String, Object> dataMap);

}
