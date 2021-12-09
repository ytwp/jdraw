package wang.yeting.jdraw.graph;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author : weipeng
 * @since : 2021-11-15 6:55 下午
 * 长方形
 */

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class RectangleCell extends GraphCell {

    @Builder.Default()
    private String style = "rounded=0;whiteSpace=wrap;html=1;";
    @Builder.Default()
    private String vertex = "1";

    private SimpleGeometry geometry;

}
