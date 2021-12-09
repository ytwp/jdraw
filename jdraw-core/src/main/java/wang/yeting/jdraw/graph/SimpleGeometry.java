package wang.yeting.jdraw.graph;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author : weipeng
 * @since : 2021-11-16 4:48 下午
 * 简单的 图形属性
 */
@SuperBuilder(toBuilder = true)
@Getter
@Setter
public class SimpleGeometry extends Geometry {

    private String x;
    private String y;

}
