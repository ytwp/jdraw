package wang.yeting.jdraw.graph;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author : weipeng
 * @since : 2021-12-08 3:22 下午
 * 表格图形
 * <p>
 * 顺序 {@link TableCell} {@link TableRowCell} {@link PartialRectangleCell}
 * <p>
 * 行 geometry 需完善 y="30" width="310" height="40" //y必须30开始，有表头
 * 每行的单元格 geometry 需完善 x="0" width="310" height="40"  //0开始
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class TableCell extends GraphCell {


    @Builder.Default()
    private String style = "shape=table;startSize=30;container=1;collapsible=0;childLayout=tableLayout;fontStyle=1;align=center;pointerEvents=1;";
    @Builder.Default()
    private String vertex = "1";

    private SimpleGeometry geometry;

    /**
     * 行
     */
    @Getter
    @Setter
    @SuperBuilder(toBuilder = true)
    public static class TableRowCell extends GraphCell {

        @Builder.Default()
        private String style = "shape=partialRectangle;html=1;whiteSpace=wrap;collapsible=0;dropTarget=0;pointerEvents=0;fillColor=none;top=0;left=0;bottom=0;right=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;";
        @Builder.Default()
        private String vertex = "1";

        private SimpleGeometry geometry;

    }

}
