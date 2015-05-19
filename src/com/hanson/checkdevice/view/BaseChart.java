package com.hanson.checkdevice.view;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

public class BaseChart {
	public View execute(Context context) {
		  int[] colors = new int[] { Color.RED, Color.YELLOW, Color.BLUE };
		  DefaultRenderer renderer = buildCategoryRenderer(colors);
		  CategorySeries categorySeries = new CategorySeries("Vehicles Chart");
		  categorySeries.add("总装", 30);
		  categorySeries.add("热交换", 20);
		  categorySeries.add("配管", 60);
		  return ChartFactory.getPieChartView(context, categorySeries, renderer);
	 }
	 protected DefaultRenderer buildCategoryRenderer(int[] colors) {
		  DefaultRenderer renderer = new DefaultRenderer();
		  for (int color : colors) {
		   SimpleSeriesRenderer r = new SimpleSeriesRenderer();
		   r.setColor(color);
		   renderer.addSeriesRenderer(r); 
	  }
	  //显示标签
	  renderer.setShowLabels(true);
	  //底部说明
	  renderer.setShowLegend(true);
	  //设置标签字体大小
	  renderer.setLabelsTextSize(28);
	  renderer.setLegendTextSize(33);
	  renderer.setLabelsColor(Color.BLACK);
//	  renderer.setZoomEnabled(false);
//	  renderer.setPanEnabled(false);
	  return renderer;
	 }
}
