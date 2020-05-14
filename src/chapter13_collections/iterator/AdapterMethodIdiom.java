package chapter13_collections.iterator;

import java.util.*;

/**
 *@program: TIJ4
 *@description: 适配器模式简单使用
 *@author: 韩东明
 *@date: 2020/05/14 14:35
 */
public class AdapterMethodIdiom {

    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList(("To be or not to be").split(" ")));
        for (String s : ral) {
            System.out.print(s + " ");
        }

        System.out.println();
        for (String s : ral.revers()) {
            System.out.print(s + " ");
        }
    }

}


class ReversibleArrayList<T> extends ArrayList<T> {
    ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> revers() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}