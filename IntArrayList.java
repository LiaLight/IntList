package com.li;

import java.util.Arrays;

public class IntArrayList implements IntList {

    private int[] array;
    private int size;
    static final int ARRAY_DEF_LENGTH = 10;

    public IntArrayList (int length) {
        size = 0;
        if (length>0) {
            array = new int[length];
        }
        else{ //Exception??? throw new NegativeArraySizeException();????
            array = new int[ARRAY_DEF_LENGTH]; //exception!!! length must be >0
        }
    }

    public IntArrayList () {
        this(ARRAY_DEF_LENGTH);
    }

    private boolean outOfBounds (int i){ //????? void or boolean, exception???
    /*    if ((i<0)||(i>=size)) {
            throw new IndexOutOfBoundsException();
        }
      */  //return true; //void???
        return ((i<0)||(i>=size)) ? true : false;// exception outofbounds??
    }


    protected void sizeInc(){
        if (size>=array.length) {
            int[] array2 = array.clone();
            array = new int[size / 2 * 3 + 1];
            for (int i=0;i<size;i++) {
                array[i] = array2[i];
            }
        }
        size++;

    }

    @Override
    public void add(int element) {
        sizeInc();
        array[size-1]=element;
    }

    @Override
    public boolean add(int index, int element) {
        if ((outOfBounds(index))){ //exception outOfBounds
            return false;
        }
        sizeInc();
        for(int i=size-1;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=element;
        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if ((outOfBounds(index))) {
            throw new IndexOutOfBoundsException();          //exception!!!!!!return???
        }
        else {
            return array[index];
        }
    }

    @Override
    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    @Override
    public boolean remove(int index) { //exception out of Bounds
        if ((outOfBounds(index))) {
            return false;
        }
        for (int i=index; i<size-1;i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        for (int i=0;i<size;i++){
            if (array[i]==value){
                remove(i);
                return true; //delete first
            }
        }
        return false; //not found
    }

    @Override
    public boolean set(int index, int element) {// exception outofbounds
        if (outOfBounds(index)) return false; //return ostavit'???
        array[index]=element;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntArrayList subList(int fromIndex, int toIndex) {
        if (fromIndex>toIndex||outOfBounds(fromIndex)||outOfBounds(toIndex)) {
            return null; //exception? outOfBounds
        }
        IntArrayList arrayList = new IntArrayList(toIndex-fromIndex+1);
        for (int i=fromIndex;i<=toIndex;i++){
            arrayList.add(array[i]);
        }
        return arrayList;
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[size];
        for (int i=0; i<size; i++) {
            arr[i]=array[i];
        }
        return arr;
    }

    @Override
    public String toString(){
 /*       String s="";
        for (int i=0; i<size; i++) {
            s = s + array[i] + " ";
        }*/
        return Arrays.toString(toArray());
    }
}
