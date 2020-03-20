package ning.zhou.study.springboot.studyspringboot;

public class LinkedChain {

    private String name;

    private LinkedChain next;

    public LinkedChain(String name) {
        this.name = name;
    }

    public LinkedChain next(String name) {
        this.next = new LinkedChain(name);
        return next;
    }

    public static LinkedChain mock() {
        LinkedChain one = new LinkedChain("1");
        LinkedChain two = one.next("2");
        LinkedChain three = two.next("3");
        LinkedChain four = three.next("4");
        LinkedChain five = four.next("5");
        return one;
    }

    public static LinkedChain inverse(LinkedChain linkedChain) {
        if (linkedChain == null || linkedChain.next == null) {
            return linkedChain;
        }
        LinkedChain pre = null;
        LinkedChain cur = linkedChain;
        LinkedChain next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void order(LinkedChain linkedChain) {
        if (linkedChain == null) {
            return;
        }
        do {
            System.out.print(linkedChain.name);
            linkedChain = linkedChain.next;
        } while (linkedChain != null);
    }


    public static void main(String[] args) {
        LinkedChain linkedChain = LinkedChain.mock();
        LinkedChain.order(linkedChain);
        System.out.println();
        LinkedChain.order(LinkedChain.inverse(linkedChain));
        System.out.println();
    }
}
