package wang.yeting.jdraw.graph;

import lombok.Builder;
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
public class Cell {

    private String id;
    @Builder.Default
    private String parent = "r1";

}
