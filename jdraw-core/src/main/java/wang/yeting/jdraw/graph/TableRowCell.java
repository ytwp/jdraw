package wang.yeting.jdraw.graph;

/**
 * @author : weipeng
 * @since : 2021-12-08 3:48 下午
 */

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 表格 行
 * 依赖 {@link TableCell}
 * 下游 {@link PartialRectangleCell}
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class TableRowCell extends GraphCell {

    @Builder.Default()
    private String style = "shape=partialRectangle;html=1;whiteSpace=wrap;collapsible=0;dropTarget=0;pointerEvents=0;fillColor=none;top=0;left=0;bottom=0;right=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;";
    @Builder.Default()
    private String vertex = "1";

    private SimpleGeometry geometry;

}
