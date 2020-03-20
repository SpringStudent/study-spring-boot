package ning.zhou.study.springboot.studyspringboot;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private String node;

    private BinaryTree left;

    private BinaryTree right;

    public BinaryTree(String node) {
        this.node = node;
    }

    public BinaryTree right(String node) {
        BinaryTree right = new BinaryTree(node);
        this.right = right;
        return right;
    }

    public BinaryTree left(String node) {
        BinaryTree left = new BinaryTree(node);
        this.left = left;
        return left;
    }

    public static BinaryTree mock() {
        BinaryTree A = new BinaryTree("A");
        BinaryTree B = A.left("B");
        BinaryTree C = A.right("C");
        BinaryTree D = B.left("D");
        BinaryTree E = B.right("E");
        BinaryTree F = C.left("F");
        BinaryTree G = C.right("G");
        return A;
    }

    public void pre(BinaryTree root) {
        if (null == root) {
            return;
        }
        System.out.print(root.node);
        pre(root.left);
        pre(root.right);
    }

    public void mid(BinaryTree root) {
        if (null == root) {
            return;
        }
        mid(root.left);
        System.out.print(root.node);
        mid(root.right);
    }

    public void post(BinaryTree root) {
        if (null == root) {
            return;
        }
        post(root.left);
        post(root.right);
        System.out.print(root.node);
    }

    public void level(BinaryTree root) {
        if(root==null){
            return;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTree bt = queue.poll();
            System.out.print(bt.node);
            if(bt.left!=null){
                queue.offer(bt.left);
            }
            if(bt.right!=null){
                queue.offer(bt.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree root = BinaryTree.mock();
        root.pre(root);
        System.out.println();
        root.mid(root);
        System.out.println();
        root.post(root);
        System.out.println();
        root.level(root);
    }
}
