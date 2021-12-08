package wang.yeting.jdraw;

import lombok.Builder;
import lombok.Getter;
import wang.yeting.jdraw.graph.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : weipeng
 * @since : 2021-11-16 2:42 下午
 */

@Builder
@Getter
public class GraphModel {

    private String dx;
    private String dy;
    @Builder.Default
    private String grid = "1";
    @Builder.Default
    private String gridSize = "10";
    @Builder.Default
    private String guides = "1";
    @Builder.Default
    private String tooltips = "1";
    @Builder.Default
    private String connect = "1";
    @Builder.Default
    private String arrows = "1";
    @Builder.Default
    private String fold = "1";
    @Builder.Default
    private String page = "1";
    @Builder.Default
    private String pageScale = "1";
    @Builder.Default
    private String pageWidth = "108000";
    @Builder.Default
    private String pageHeight = "108000";
    @Builder.Default
    private String math = "0";
    @Builder.Default
    private String shadow = "0";

    private final List<Cell> cellList = initCellList();

    private static List<Cell> initCellList() {
        List<Cell> cells = new ArrayList<>();
        cells.add(Cell.builder().id("r0").parent("").build());
        cells.add(Cell.builder().id("r1").parent("r0").build());
        return cells;
    }

    public GraphModel addCell(Cell cell) {
        cellList.add(cell);
        return this;
    }

}
