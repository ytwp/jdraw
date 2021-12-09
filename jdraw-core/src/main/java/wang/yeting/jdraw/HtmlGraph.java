package wang.yeting.jdraw;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONUtil;
import lombok.Builder;
import lombok.Data;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import wang.yeting.jdraw.util.RandomCodeUtil;

import java.util.Date;

/**
 * @author : weipeng
 * @since : 2021-11-16 9:22 上午
 * 图 转成 html 格式
 */

public class HtmlGraph {

    public static String toHtml(GraphModel graphModel, String htmlTitle) {
        Document document = XmlGraph.toXml(graphModel);
        Element mxfile = document.createElement("mxfile");
        mxfile.setAttribute("modified", new Date().toString());
        mxfile.setAttribute("compressed", "false");
        mxfile.setAttribute("type", "device");
        mxfile.setAttribute("host", "Electron");
        mxfile.setAttribute("etag", RandomCodeUtil.genUUID());
        Element diagram = document.createElement("diagram");
        mxfile.appendChild(diagram);
        diagram.setAttribute("id", RandomCodeUtil.genUUID());
        diagram.setAttribute("name", "第 1 页");
        diagram.appendChild(document.getDocumentElement());
        DataMxgraph dataMxgraph = DataMxgraph.builder().xml(XmlUtil.toStr(mxfile)).build();
        String s = htmlEncode(JSONUtil.toJsonStr(dataMxgraph));
        String html = "" +
                "<!--[if IE]><meta http-equiv=\"X-UA-Compatible\" content=\"IE=5,IE=9\" ><![endif]-->\n" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>" + htmlTitle + "</title>\n" +
                "<meta charset=\"utf-8\"/>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"mxgraph\" style=\"max-width:100%;border:1px solid transparent;\" data-mxgraph=\"" + s + "\"></div>\n" +
                "<script type=\"text/javascript\" src=\"https://app.diagrams.net/js/viewer-static.min.js\"></script>\n" +
                "</body>\n" +
                "</html>";
        return html;
    }

    @Data
    @Builder
    static class DataMxgraph {

        @Builder.Default
        private String highlight = "#0000ff";
        @Builder.Default
        private Boolean nav = true;
        @Builder.Default
        private Boolean resize = true;

        private String xml;
        @Builder.Default
        private String toolbar = "pages zoom layers lightbox";
        @Builder.Default
        private Integer page = 0;
    }

    public static String htmlEncode(String str) {
        int length = str.length();
        int newLength = length;
        boolean someCharacterEscaped = false;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            int cint = 0xffff & c;
            if (cint < 32) {
                switch (c) {
                    case 11:
                    default:
                        newLength--;
                        someCharacterEscaped = true;
                        break;

                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                        break;
                }
            } else {
                switch (c) {
                    case '"':
                        newLength += 5;
                        someCharacterEscaped = true;
                        break;

                    case '&':
                    case '\'':
                        newLength += 4;
                        someCharacterEscaped = true;
                        break;

                    case '<':
                    case '>':
                        newLength += 3;
                        someCharacterEscaped = true;
                        break;
                    default:
                        break;
                }
            }
        }
        if (!someCharacterEscaped) {
            return str;
        }

        StringBuilder sb = new StringBuilder(newLength);
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            int cint = 0xffff & c;
            if (cint < 32) {
                switch (c) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                        sb.append(c);
                        break;
                    default:
                        break;
                }
            } else {
                switch (c) {
                    case '"':
                        sb.append("&quot;");
                        break;

                    case '\'':
                        sb.append("&apos;");
                        break;

                    case '&':
                        sb.append("&amp;");
                        break;

                    case '<':
                        sb.append("&lt;");
                        break;

                    case '>':
                        sb.append("&gt;");
                        break;

                    default:
                        sb.append(c);
                        break;
                }
            }
        }
        return sb.toString();
    }
}
