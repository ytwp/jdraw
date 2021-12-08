package wang.yeting.jdraw.graph;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author : weipeng
 * @since : 2021-11-16 4:45 下午
 */
@SuperBuilder(toBuilder = true)
@Getter
@Setter
public class GraphCell extends Cell {

    private String value;

    private String style;

}
