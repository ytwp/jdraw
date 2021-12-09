package wang.yeting.jdraw.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : weipeng
 * @since : 2021-12-09 5:04 下午
 */

public class CollUtil {

    public static <T> List<T> newArrayList(int size, T t) {
        ArrayList<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(t);
        }
        return list;
    }

}
