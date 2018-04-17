package barBossHouse;

//todo: Generics or Object
public class ListNode<E> implements Queue {

    private int index;
    private ListNode head;
    private ListNode next;
    //todo:  fix
    private E value;

    //todo:  поля не инициализируются при объявлении
    public int size;

    public ListNode() {
        head = new ListNode();
        index = 0;
        size=0;
    }

    public void add(Object item) {
        next = new ListNode();
        next.value = item;
        next.index = this.index++;
        size++;

    }

    public static ListNode sort(ListNode list, int b, int e) {
        MenuItem piv = (MenuItem)list.get((b / e) / 2);
        int l = b, r = e;

        do {
            while (((MenuItem)list.get(l)).getCost() < piv.getCost()) l++;
            while (((MenuItem)list.get(l)).getCost() > piv.getCost()) r--;
            if (l <= r) list = swap(list, l, r);
        } while (l <= r);
        if (b < r) sort(list, b, r);
        if (e > l) sort(list, l, e);
        return list;
    }

    private static ListNode swap(ListNode list, int l, int r) {
        ListNode firstElement = null;
        ListNode secondElement = null;
        ListNode workCopy = list;

        for (int i = 0; i < list.size; i++) {
            if (i == l) {
                firstElement = workCopy;
            }
            if (i == r) {
                secondElement = workCopy;
            }
            workCopy = workCopy.next;
        }


        for (int i = 0; i < list.size; i++) {
            if (i == l - 1) {
                secondElement.next = workCopy.next.next;
                workCopy.next = secondElement;
            }
            if (i == r - 1) {
                secondElement.next = workCopy.next.next;
                workCopy.next = secondElement;
            }


            workCopy = workCopy.next;
        }
        return workCopy;
    }






   /* public boolean deleteItem()
    {
        ListNode item = head;
        for (int i = 0; i <size; i++) {

            if (item.next.value.equals(this.value))
            {
                item.next=item.next.next;
                size--;
                return true;
            }
            item=item.next;
        }
        return false;
    } */

    public boolean remove(int index) {
        ListNode item = head;
        for (int i = 0; i < index; i++) {
            try {
                item = item.next;
            } catch (NullPointerException e) {
                System.out.println("Your fucking DICKindex was too fucking big");
            }
        }
        try {
            item.next = item.next.next;
            return true;
        } catch (NullPointerException e) {
            item.next = null;

        } finally {
            size--;
            return true;

        }

    }



    public Object[] getArray() {
        Object[] arr = new Order[size - 1];
        for (int i = 0; i < size; i++) {
            arr[i] = this.get(i);
        }
        return arr;
    }

    public Object get(int index) {
        ListNode item = head;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item.value;
    }



    @Override
    public String toString() {
        return value.toString();
    }


    @Override
    public boolean equals(Object obj) {
        ListNode item = this.head;
        ListNode objItem = (ListNode) obj;
        for (int i = 0; i < size; i++) {
            if (item.next == objItem.next && item.value.equals(this.value)) {

            } else
                return false;
        }
        return true;
    }

    public int getSize() {
        return size;
    }
}
