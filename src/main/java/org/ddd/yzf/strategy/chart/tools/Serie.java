package org.ddd.yzf.strategy.chart.tools;

import java.io.Serializable;
import java.util.Vector;

/**
 * @author 袁泽锋
 * @since 2019年12月17日 20:30
 * Description: 系列:名字和数据集合 构成一条曲线
 *              可以将serie看作一根线或者一根柱子：
 */
public class Serie implements Serializable {

    private String name;// 名字
    private Vector<Object> data;// 数据值

    /**
     * @param name 名称（线条名称）
     * @param data 数据（线条上的所有数据值）
     */
    public Serie(String name, Vector<Object> data) {
        this.name = name;
        this.data = data;
    }

    /**
     * @param name  名称（线条名称）
     * @param array 数据（线条上的所有数据值）
     */
    public Serie(String name, Object[] array) {
        this.name = name;
        if (array != null) {
            data = new Vector<Object>(array.length);
            for (int i = 0; i < array.length; i++) {
                data.add(array[i]);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Object> getData() {
        return data;
    }

    public void setData(Vector<Object> data) {
        this.data = data;
    }

}
