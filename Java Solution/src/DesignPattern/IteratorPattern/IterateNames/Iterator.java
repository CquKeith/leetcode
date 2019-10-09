package DesignPattern.IteratorPattern.IterateNames;

/**
 * @author chenmengliang
 * @date 2019/10/919:37
 **/
public interface Iterator<T> {

    T next();

    boolean hasNext();

}
