package wang.yeting.jdraw.graph;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author : weipeng
 * @since : 2021-11-17 11:51 上午
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class OrthogonalCell extends Cell {

    private String source;
    private String target;
    @Builder.Default
    private String style = "edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;";
    @Builder.Default
    private String edge = "1";

    private MultiGeometry geometry;

}
