package ning.zhou.study.springboot.studyspringboot;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    private String node;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(String node) {
        this.node = node;
    }

    public TreeNode right(String node) {
        TreeNode rightNode = new TreeNode(node);
        this.right = rightNode;
        return rightNode;
    }

    public TreeNode left(String node) {
        TreeNode leftNode = new TreeNode(node);
        this.left = leftNode;
        return leftNode;
    }

    public static TreeNode mockTree() {
        TreeNode A = new TreeNode("A");
        TreeNode B = A.left("B");
        TreeNode C = A.right("C");
        TreeNode D = B.left("D");
        TreeNode E = B.right("E");
        TreeNode F = C.left("F");
        TreeNode G = C.right("G");
        return A;
    }

    public void preOrderTree(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.node);
            preOrderTree(root.left);
            preOrderTree(root.right);
        }

    }

    public void midOrderTree(TreeNode root) {
        if (root == null) {
            return;
        } else {
            midOrderTree(root.left);
            System.out.print(root.node);
            midOrderTree(root.right);
        }
    }

    public void postOrderTree(TreeNode root) {
        if (root == null) {
            return;
        } else {
            postOrderTree(root.left);
            postOrderTree(root.right);
            System.out.print(root.node);
        }
    }

    public void levelOrderTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = mockTree();
        System.out.println("前序遍历结果");
        treeNode.preOrderTree(treeNode);
        System.out.println("后序遍历结果");
        treeNode.postOrderTree(treeNode);
        System.out.println("中序遍历结构");
        treeNode.midOrderTree(treeNode);
        System.out.println("层序遍历结果");
        treeNode.levelOrderTree(treeNode);
    }
}
