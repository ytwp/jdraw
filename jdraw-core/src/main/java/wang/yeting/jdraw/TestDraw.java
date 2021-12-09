package wang.yeting.jdraw;

import cn.hutool.core.collection.CollUtil;
import wang.yeting.jdraw.graph.*;
import wang.yeting.jdraw.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : weipeng
 * @since : 2021-11-15 7:00 下午
 */

public class TestDraw {
    public static void main(String[] args) {
        GraphModel graphModel = GraphModel.builder().dx("1000").dy("1111").build();
        graphModel.addCell(
                RectangleCell.builder().id("111").value("测试").geometry(
                        SimpleGeometry.builder().y("1").x("1").width("100").height("100").build()
                ).build()
        );
        graphModel.addCell(
                RectangleCell.builder().id("112").value("测试222").geometry(
                        SimpleGeometry.builder().y("200").x("200").width("100").height("100").build()
                ).build()
        );

        graphModel.addCell(
                OrthogonalCell.builder().id("11222").source("111").target("112").geometry(
                        MultiGeometry.builder().build()
                ).build()
        );

        ArrayList<List<Integer>> data = CollUtil.newArrayList(CollUtil.newArrayList(1, 2, 3), CollUtil.newArrayList(1, 2, 3));
        TableCellBuilder<Integer> table = TableCellBuilder.<Integer>builder()
                .x(111).y(111).columnsNum(data.get(0).size()).title("测试表")
                .data(data)
                .build();
        graphModel.addCell(table.genTableCell());
        System.out.println(table.getDataCellId());

        String test = HtmlGraph.toHtml(graphModel, "test");
        FileUtil.initFile("data/test.html");
        FileUtil.writeStr("data/test.html", test);

    }
}
