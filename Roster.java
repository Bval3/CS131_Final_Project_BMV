
public class Roster<E> {
    private E[] array;
    private int currentItem;
    private int size;

    public Roster() {
        currentItem = 0;
        size = 10;
        array = (E[]) new Object[size];
    }

    public Roster(int size) {
        currentItem = 0;
        this.size = size;
        array = (E[]) new Object[this.size];
    }

    public void addItem(E item) {
        if (getItem(array.length - 1) != null) {
            currentItem = array.length;
            doubleListSize();
        }
        array[currentItem] = item;
        currentItem++;
    }

    public void addItem(E item, int index) {
        if (getItem(array.length - 1) != null) {
            doubleListSize();
        }

        if (getItem(index) != null) {
            int tempInd = index;
            int numInFrontOf = 0;

            while (tempInd < array.length - 1 && array[tempInd] != null) {
                ++tempInd;
                ++numInFrontOf;
            }

            for (int i = index + numInFrontOf; i > index; --i) {
                array[i] = array[i - 1];
            }
        }
        array[index] = item;
        currentItem++;
    }

    public E getItem(int index) {
        return array[index];
    }

    public int getLength() {
        return array.length;
    }

    public int getCurrentItem() {
        return currentItem;
    }

    public E[] getArray() {
        return array;
    }

    private void doubleListSize() {
        E[] newArray = (E[]) new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
