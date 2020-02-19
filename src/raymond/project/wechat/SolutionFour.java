package raymond.project.wechat;

import raymond.project.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionFour {

    public void printPath(BinaryTreeNode root, int val) {
        List<Integer> ans = new ArrayList<>();
        printPath(root, val, ans);

        System.out.println(ans);

    }

    public boolean printPath(BinaryTreeNode root, int val, List<Integer> list) {
        if(root == null) {
            return false;
        }

        boolean result = false;
        list.add(root.val);
        if(root.val == val) {
            return true;
        } else {
            result = printPath(root.left, val, list);
            if(!result) {
                result = printPath(root.right, val, list);
            }
        }

        if(!result) {
            list.remove(list.size() - 1);
        }

        return result;
    }

    public static void main(String[] args) throws Exception{
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);

        SolutionFour solutionFour = new SolutionFour();
        solutionFour.printPath(root, 8);
    }
}
