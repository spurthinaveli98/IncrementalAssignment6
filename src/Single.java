class SList<E> {
    Link<E> headLink = new Link<E>(null);
    SListIterator<E> iterator() { return new SListIterator<E>(headLink); }
    public String toString() {
        if(headLink.next == null) return "SList: []";
        System.out.print("SList: [");
        SListIterator<E> it = this.iterator();
        StringBuilder s = new StringBuilder();
        while(it.hasNext()) {
            s.append(it.next() + (it.hasNext() ? ", " : ""));
        }
        return s + "]";
    }
}

class SListIterator<E> {
    Link<E> current;
    SListIterator(Link<E> link) {
        current = link;
    }
    public boolean hasNext() {
        return current.next != null;
    }
    public Link<E> next() {
        current = current.next;
        return current;
    }
    public void insert(E e) {
        current.next = new Link<E>(e, current.next);
        current = current.next;
    }
    public void remove() {
        if(current.next != null) {
            current.next = current.next.next;
        }
    }
}

class Link<E> {
    E e;
    Link<E> next;
    Link(E e, Link<E> next) {
        this.e = e;
        this.next = next;
    }
    Link(E e) {
        this(e, null);
    }
    public String toString() {
        if(e == null) return "null";
        return e.toString();
    }
}

public class Single {
    public static void main(String[] args) {
        SList<String> sl = new SList<String>();
        System.out.println(sl);

        //Inserting elements

        SListIterator<String> slIter = sl.iterator();
        System.out.println("inserting: hello");
        slIter.insert("hello");
        System.out.println(sl);
        System.out.println("inserting: world");
        slIter.insert("world");
        System.out.println(sl);

        //Removing elements

        SListIterator<String> slIter2 = sl.iterator();
        System.out.println("removing: hello");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("removing world");
        slIter2.remove();
        System.out.println(sl);
    }
}
