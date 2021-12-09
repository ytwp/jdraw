package wang.yeting.jdraw.graph;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author : weipeng
 * @since : 2021-12-08 3:42 下午
 */

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class PartialRectangleCell extends GraphCell {

    @Builder.Default()
    private String style = "shape=partialRectangle;html=1;whiteSpace=wrap;connectable=0;fillColor=none;top=0;left=0;bottom=0;right=0;";
    @Builder.Default()
    private String vertex = "1";

    private SimpleGeometry geometry;

}
