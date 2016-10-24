package seminar1.collections;

import java.util.Iterator;

public class LinkedStack<Item> implements IStack<Item> {

    private Node<Item> head;
    private int size;

    @Override
    public void push(Item item) {
        /* TODO: implement it */
        Node add = new Node<>(item, head);
        head = add;
        size++;
    }

    @Override
    public Item pop() {
        /* TODO: implement it */
        if (!isEmpty()) {
            Node<Item> get = head;
            head = get.next;
            size--;
            return get.item;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            /* TODO: implement it */
            return cursor < size();
        }

        @Override
        public Item next() {
            /* TODO: implement it */
            cursor++;
            return pop();
        }
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}
