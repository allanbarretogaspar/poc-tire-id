package br.com.sascar.poc.tireid.utils;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {
	public static <T> List<T> getListFromIterable(Iterable<T> itr) {
        List<T> cltn = new ArrayList<T>();
        itr.forEach(cltn::add);

        return cltn;
    }
}
