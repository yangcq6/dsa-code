package com.yangcq.lovedsa.class02_arraylist;

public class ArrayList<E> {
    private E[] data;
    private int size;

    private static final int DEFAULT_CAPACITY = 5;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        data = (E[]) new Object[capacity];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size = " + size);
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size = " + size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        rangeCheck(index);
        return data[index];
    }

    public E set(int index, E ele) {
        rangeCheck(index);

        E oldEle = data[index];
        data[index] = ele;
        return oldEle;
    }

    public int indexOf(E ele) {
        if (ele == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (ele.equals(data[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(E ele) {
        return indexOf(ele) >= 0;
    }

    /**
     * 控制数据的访问范围即可，将size修改为0
     * 后续无法进行get、set等操作
     * 在操作中都会进行数据范围的校验
     * 保留data数组的空间，后续复用
     */
    public void clear() {
        // gc
        for (int i = 0; i < size; i++) data[i] = null;
        size = 0;
    }

    public void add(E ele) {
        this.add(size, ele);
    }

    public void add(int index, E ele) {
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) data[i] = data[i - 1];

        data[index] = ele;

        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCap = data.length;
        if (capacity <= oldCap) return;

        int newCap = oldCap + (oldCap >> 1);
        E[] newData = (E[]) new Object[newCap];

        for (int i = 0; i < size; i++) newData[i] = data[i];
        data = newData;

        System.out.printf("%d -> %d\n", oldCap, newCap);
    }

    public E remove(int index) {
        rangeCheck(index);

        E oldEle = data[index];

        // 基本数据类型，最后data[size-1]位置的元素不处理
        // 引用数据类型，gc
        for (int i = index + 1; i < size; i++) data[i - 1] = data[i];

        size--;
        // gc
        data[size] = null;

        return oldEle;
    }

    public void remove(E ele) {
        remove(indexOf(ele));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("size: ").append(size).append(", [");

        for (int i = 0; i < size; i++) {
            if (i != 0) sb.append(", ");
            sb.append(data[i]);
        }

        sb.append("]");
        return sb.toString();
    }


}
