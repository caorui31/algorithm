package raymond.project.wechat;

import raymond.project.BinaryTreeNode;

public class SolutionTwo {

    public int getDistance(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftDistance = 0, rightDistance = 0;
        if(root.left != null) {
            leftDistance = getMaxDistance(root.left) + 1;
        }
        if(root.right != null) {
            rightDistance = getMaxDistance(root.right) + 1;
        }

        return leftDistance + rightDistance;
    }

    public int getMaxDistance(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }

        return Math.max(getMaxDistance(root.left), getMaxDistance(root.right)) +1;
    }

    public static void main(String[] args) throws Exception{
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(1);
        root.left.left = new BinaryTreeNode(1);
        root.left.right = new BinaryTreeNode(1);
        root.right.right = new BinaryTreeNode(1);
        root.right.left = new BinaryTreeNode(1);
        root.right.left.right = new BinaryTreeNode(1);
        root.left.right = new BinaryTreeNode(1);
        root.right.right.right = new BinaryTreeNode(1);
        SolutionTwo solutionTwo = new SolutionTwo();
        System.out.println(solutionTwo.getDistance(root));
    }
}
