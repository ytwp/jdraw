package wang.yeting.jdraw.graph;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author : weipeng
 * @since : 2021-11-16 4:48 下午
 * 多样的 图形属性
 */
@SuperBuilder(toBuilder = true)
@Getter
@Setter
public class MultiGeometry extends Geometry {

    @Builder.Default()
    private String relative = "1";
}
