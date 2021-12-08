package wang.yeting.jdraw;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import wang.yeting.jdraw.graph.Cell;
import wang.yeting.jdraw.graph.Geometry;

import java.util.List;
import java.util.Map;

/**
 * @author : weipeng
 * @since : 2021-11-16 9:22 上午
 */

public class XmlGraph {

    public static Document toXml(GraphModel graphModel) {
        Document document = XmlUtil.createXml();
        Element gxGraphModel = document.createElement("mx" + graphModel.getClass().getSimpleName());
        document.appendChild(gxGraphModel);
        Element root = document.createElement("root");
        Map<String, Object> graphModelMap = BeanUtil.beanToMap(graphModel);
        gxGraphModel.appendChild(root);
        for (Map.Entry<String, Object> entry : graphModelMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                gxGraphModel.setAttribute(key, "");
            } else if (value instanceof String) {
                gxGraphModel.setAttribute(key, value.toString());
            } else if (value instanceof List) {
                List<Cell> cellList = (List<Cell>) value;
                for (Cell cell : cellList) {
                    Map<String, Object> cellMap = BeanUtil.beanToMap(cell);
                    Element cellElement = document.createElement("mxCell");
                    root.appendChild(cellElement);
                    for (Map.Entry<String, Object> cellEntry : cellMap.entrySet()) {
                        String cellKey = cellEntry.getKey();
                        Object cellValue = cellEntry.getValue();
                        if (cellValue == null) {
                            cellElement.setAttribute(cellKey, "");
                        } else if (cellValue instanceof String) {
                            cellElement.setAttribute(cellKey, cellValue.toString());
                        } else if (cellValue instanceof Geometry) {
                            Geometry geometry = (Geometry) cellValue;
                            Map<String, Object> geometryMap = BeanUtil.beanToMap(geometry);
                            Element geometryElement = document.createElement("mxGeometry");
                            cellElement.appendChild(geometryElement);
                            for (Map.Entry<String, Object> geometryEntry : geometryMap.entrySet()) {
                                String geometryKey = geometryEntry.getKey();
                                Object geometryValue = geometryEntry.getValue();
                                if (geometryKey == null) {
                                    geometryElement.setAttribute(geometryKey, "");
                                } else if (geometryValue instanceof String) {
                                    geometryElement.setAttribute(geometryKey, geometryValue.toString());
                                }
                            }
                        }
                    }
                }
            }
        }
        return document;
    }

    public static String toXmlStr(GraphModel graphModel) {
        return XmlUtil.toStr(toXml(graphModel));
    }
}
