package org.ddd.yzf.chartTest;

import org.ddd.yzf.strategy.chart.ChartBuilder;
import org.ddd.yzf.strategy.chart.tools.ChartType;
import org.ddd.yzf.strategy.chart.tools.ChartUtils;
import org.ddd.yzf.strategy.chart.tools.Serie;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChartTest {

    @Autowired
    ChartBuilder chartBuilder;

    @Test
    public void barChart() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("title", "水果产量图");
        dataMap.put("categoryAxisLabel", "");
        dataMap.put("valueAxisLabel", "产量");

        Vector<Serie> series = new Vector<>();
        series.add(new Serie("苹果", new Double[] {1522.1, 1542.5, 1532.4}));
        series.add(new Serie("香蕉", new Double[] {1232.2, 1261.1, 1232.3}));
        series.add(new Serie("葡萄", new Double[] {1422.3, 1522.3, 1422.3}));
        series.add(new Serie("荔枝", new Double[] {1332.3, 1232.3, 1435.9}));
        DefaultCategoryDataset dataset = ChartUtils.createDefaultCategoryDataset(series, new String[] {"2017", "2018", "2019"});


        dataMap.put("dataset", dataset);
        BufferedImage bufferedImage = chartBuilder.getChart(ChartType.BarChart, dataMap);
        if (bufferedImage != null) {
            File file = new File("./barChart.png");
            try {
                ImageIO.write(bufferedImage, "png", file);
            } catch (IOException e) {
                System.out.println("保存出错");
            }
        } else {
            System.out.println("生成出错");
        }
    }

    @Test
    public void barChart3D() {

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("title", "this is title");
        dataMap.put("categoryAxisLabel", "水量");
        dataMap.put("valueAxisLabel", "产量");
        dataMap.put("width", 600);
        dataMap.put("height", 400);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "北京", "苹果");
        dataset.addValue(200, "上海", "苹果");
        dataset.addValue(300, "广州", "苹果");
        dataset.addValue(400, "北京", "梨子");
        dataset.addValue(500, "上海", "梨子");
        dataset.addValue(600, "广州", "梨子");
        dataset.addValue(700, "北京", "葡萄");
        dataset.addValue(800, "上海", "葡萄");
        dataset.addValue(900, "广州", "葡萄");
        dataset.addValue(800, "北京", "香蕉");
        dataset.addValue(700, "上海", "香蕉");
        dataset.addValue(600, "广州", "香蕉");
        dataset.addValue(500, "北京", "荔枝");
        dataset.addValue(400, "上海", "荔枝");
        dataset.addValue(300, "广州", "荔枝");
        dataMap.put("dataset", dataset);
        BufferedImage bufferedImage = chartBuilder.getChart(ChartType.BarChart3D, dataMap);

        if (bufferedImage != null) {
            File file = new File("./barChart3D.png");
            try {
                ImageIO.write(bufferedImage, "png", file);
            } catch (IOException e) {
                System.out.println("保存出错");
            }
        } else {
            System.out.println("生成出错");
        }
    }

    @Test
    public void lineChart() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("title", "this is title");
        dataMap.put("categoryAxisLabel", "");
        dataMap.put("valueAxisLabel", "产量");
        dataMap.put("width", 600);
        dataMap.put("height", 400);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "北京", "苹果");
        dataset.addValue(200, "上海", "苹果");
        dataset.addValue(300, "广州", "苹果");
        dataset.addValue(400, "北京", "梨子");
        dataset.addValue(500, "上海", "梨子");
        dataset.addValue(600, "广州", "梨子");
        dataset.addValue(700, "北京", "葡萄");
        dataset.addValue(800, "上海", "葡萄");
        dataset.addValue(900, "广州", "葡萄");
        dataset.addValue(800, "北京", "香蕉");
        dataset.addValue(700, "上海", "香蕉");
        dataset.addValue(600, "广州", "香蕉");
        dataset.addValue(500, "北京", "荔枝");
        dataset.addValue(400, "上海", "荔枝");
        dataset.addValue(300, "广州", "荔枝");
        dataMap.put("dataset", dataset);
        BufferedImage bufferedImage = chartBuilder.getChart(ChartType.LineChart, dataMap);

        if (bufferedImage != null) {
            File file = new File("./lineChart.png");
            try {
                ImageIO.write(bufferedImage, "png", file);
            } catch (IOException e) {
                System.out.println("保存出错");
            }
        } else {
            System.out.println("生成出错");
        }
    }

    @Test
    public void pieChart() {

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("title", "绩效组成");
        dataMap.put("width", 600);
        dataMap.put("height", 400);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("基础工作", 1);
        dataset.setValue("绩效工作", 2);
        dataset.setValue("项目", 0.8);
        dataset.setValue("公共服务", 0);
        dataMap.put("dataset", dataset);
        BufferedImage bufferedImage = chartBuilder.getChart(ChartType.PieChart, dataMap);
        if (bufferedImage != null) {
            File file = new File("./pieChart.png");
            try {
                ImageIO.write(bufferedImage, "png", file);
            } catch (IOException e) {
                System.out.println("保存出错");
            }
        } else {
            System.out.println("生成出错");
        }

    }


    @Test
    public void pieChart3D() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("title", "this is title");
        dataMap.put("width", 600);
        dataMap.put("height", 400);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("苹果", 250);
        dataset.setValue("桔子", 350);
        dataset.setValue("梨子", 200);
        dataset.setValue("香蕉", 50);
        dataset.setValue("荔枝", 150);
        dataMap.put("dataset", dataset);
        BufferedImage bufferedImage = chartBuilder.getChart(ChartType.PieChart3D, dataMap);

        if (bufferedImage != null) {
            File file = new File("./pieChart3D.png");
            try {
                ImageIO.write(bufferedImage, "png", file);
            } catch (IOException e) {
                System.out.println("保存出错");
            }
        } else {
            System.out.println("生成出错");
        }

    }

    @Test
    public void columnChart() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("title", "this is title");
        dataMap.put("categoryAxisLabel", "水量");
        dataMap.put("valueAxisLabel", "产量");
        dataMap.put("width", 600);
        dataMap.put("height", 400);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "北京", "苹果");
        dataset.addValue(100, "上海", "苹果");
        dataset.addValue(100, "广州", "苹果");
        dataset.addValue(200, "北京", "梨子");
        dataset.addValue(200, "上海", "梨子");
        dataset.addValue(200, "广州", "梨子");
        dataset.addValue(300, "北京", "葡萄");
        dataset.addValue(300, "上海", "葡萄");
        dataset.addValue(300, "广州", "葡萄");
        dataset.addValue(400, "北京", "香蕉");
        dataset.addValue(400, "上海", "香蕉");
        dataset.addValue(400, "广州", "香蕉");
        dataset.addValue(500, "北京", "荔枝");
        dataset.addValue(500, "上海", "荔枝");
        dataset.addValue(500, "广州", "荔枝");
        dataMap.put("dataset", dataset);
        BufferedImage bufferedImage = chartBuilder.getChart(ChartType.ColumnChart, dataMap);

        if (bufferedImage != null) {
            File file = new File("./columnChart.png");
            try {
                ImageIO.write(bufferedImage, "png", file);
            } catch (IOException e) {
                System.out.println("保存出错");
            }
        } else {
            System.out.println("生成出错");
        }

    }


}
