package wang.yeting.jdraw.graph;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import wang.yeting.jdraw.util.CollUtil;
import wang.yeting.jdraw.util.IdWorker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : weipeng
 * @since : 2021-12-09 4:55 下午
 */
@Getter
@Setter
@Builder(toBuilder = true)
public class TableCellBuilder<T> {

    private Integer x;

    private Integer y;

    private Integer columnsNum;

    private String title;

    private List<Integer> columnWidthList;

    @Builder.Default()
    private Integer rowHeight = 40;

    /**
     * T 必须重写 toString
     * List<T> 为 一行的数据
     * 外层list是行
     */
    private List<List<T>> data;

    private List<List<String>> dataCellId;

    private String tableId;

    public List<Cell> genTableCell() {
        if (columnWidthList == null) {
            columnWidthList = CollUtil.newArrayList(columnsNum, 60);
        }

        ArrayList<Cell> cellList = new ArrayList<>();
        tableId = IdWorker.getIdStr();
        dataCellId = new ArrayList<>();

        String tableHeight = Integer.toString(30 + rowHeight * data.size());
        String tableWidth = Long.toString(columnWidthList.stream().collect(Collectors.summarizingInt(i -> i)).getSum());

        TableCell table = TableCell.builder().id(tableId).value(title).geometry(
                SimpleGeometry.builder().x(x.toString()).y(y.toString()).height(tableHeight).width(tableWidth).build()
        ).build();
        cellList.add(table);

        for (int i = 0; i < data.size(); i++) {
            List<String> rowDataCellId = new ArrayList<>();
            dataCellId.add(rowDataCellId);
            List<T> rowData = data.get(i);
            String rowId = IdWorker.getIdStr();
            String rowHeightStr = Integer.toString(rowHeight);
            TableRowCell row = TableRowCell.builder().id(rowId).parent(tableId).geometry(
                    SimpleGeometry.builder().y(Integer.toString(30 + rowHeight * i)).height(rowHeightStr).width(tableWidth).build()
            ).build();
            cellList.add(row);
            int cellX = 0;
            for (int j = 0; j < rowData.size(); j++) {
                T cellData = rowData.get(i);
                Integer columnWidth = columnWidthList.get(i);
                String cellId = IdWorker.getIdStr();
                rowDataCellId.add(cellId);
                PartialRectangleCell cell = PartialRectangleCell.builder().id(cellId).parent(rowId).value(cellData.toString()).geometry(
                        SimpleGeometry.builder().x(Integer.toString(cellX)).height(rowHeightStr).width(Integer.toString(columnWidth)).build()
                ).build();
                cellList.add(cell);
                cellX += columnWidth;
            }
        }

        return cellList;
    }
}
