package wang.yeting.jdraw;

import wang.yeting.jdraw.graph.MultiGeometry;
import wang.yeting.jdraw.graph.OrthogonalCell;
import wang.yeting.jdraw.graph.Rectangle;
import wang.yeting.jdraw.graph.SimpleGeometry;
import wang.yeting.jdraw.util.FileUtil;

/**
 * @author : weipeng
 * @since : 2021-11-15 7:00 下午
 */

public class TestDraw {
    public static void main(String[] args) {
        GraphModel graphModel = GraphModel.builder().dx("1000").dy("1111").build();
        graphModel.addCell(
                Rectangle.builder().id("111").value("测试").geometry(
                        SimpleGeometry.builder().y("1").x("1").width("100").height("100").build()
                ).build()
        );
        graphModel.addCell(
                Rectangle.builder().id("112").value("测试222").geometry(
                        SimpleGeometry.builder().y("200").x("200").width("100").height("100").build()
                ).build()
        );

        graphModel.addCell(
                OrthogonalCell.builder().id("11222").source("111").target("112").geometry(
                        MultiGeometry.builder().build()
                ).build()
        );

        String test = HtmlGraph.toHtml(graphModel, "test");
        FileUtil.initFile("data/test.html");
        FileUtil.writeStr("data/test.html", test);

    }
}
