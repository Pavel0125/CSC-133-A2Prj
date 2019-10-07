package com.mycompany.a2.collection;

public interface ICollection<E>
{
    public void add(E element);
    public IIterator<E> getIterator();
}
