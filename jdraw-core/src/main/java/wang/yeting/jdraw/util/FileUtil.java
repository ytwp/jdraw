package wang.yeting.jdraw.util;

import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : weipeng
 * @since : 2021-07-05 4:13 下午
 */

public class FileUtil {

    public static <T> List<T> readJsonList(String path, Class<T> clazz) {
        try {
            if (new File(path).exists()) {
                String read = IoUtil.read(new FileInputStream(path), StandardCharsets.UTF_8);
                return JSONUtil.toList(JSONUtil.parseArray(read), clazz);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static <T> List<T> readLineJsonList(String path, Class<T> clazz) {
        try {
            if (new File(path).exists()) {
                ArrayList<String> lineList = new ArrayList<>();
                IoUtil.readLines(new FileInputStream(path), "UTF-8", lineList);
                return lineList.stream().map(line -> {
                    try {
                        return JSONUtil.toBean(line, clazz);
                    } catch (Throwable e) {
                        e.printStackTrace();
                        return null;
                    }
                }).filter(Objects::nonNull).collect(Collectors.toList());
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static <T> T readJson(String path, Class<T> clazz) {
        try {
            if (new File(path).exists()) {
                String read = IoUtil.read(new FileInputStream(path), StandardCharsets.UTF_8);
                return JSONUtil.toBean(read, clazz);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeJson(String path, Object obj) {
        initFile(path);
        try {
            IoUtil.writeUtf8(new FileOutputStream(path), true, JSONUtil.toJsonStr(obj));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeStr(String path, String str) {
        initFile(path);
        try {
            IoUtil.writeUtf8(new FileOutputStream(path), true, str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void initFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
