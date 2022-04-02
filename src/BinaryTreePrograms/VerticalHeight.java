package BinaryTreePrograms;

import java.util.ArrayList;

/*public class VerticalHeight {

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right)
     {
         this.val = val;
         this.left = left;
         this.right = right;
     }
  }


    public ArrayList<ArrayList<Integer>> vertical_order(TreeNode root)
    {
        int[] minMax= new int[2];

        rec(root,0,minMax);
    }
    public void rec(TreeNode root, int level, int[] minMax)
    {
        if(root==null) return;

        minMax[0]=Math.min(minMax[0],level);
        minMax[1]=Math.max(minMax[1],level);

        rec(root.left,level-1, minMax);
        rec(root.right, level+1, minMax);

    }

    public fill_vo(ArrayList<ArrayList<Integer>> ans, TreeNode root, int level, int min)
    {
        if(root==null) return;

        int index=level-min;

        ans.get(index).add(root.val);

        fill_vo(ans, root.left, level-1,min);
        fill_vo(ans,root.right,level+1, min);
    }

    public ArrayList<ArrayList<Integer>> vertical_order(TreeNode root)
    {
        int[] minMax=new int[2];

        rec(root, 0, minMax);

        int width=minMax[1]-minMax[0];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=0;i<width;i++)
        {
            ans.add(new ArrayList<>());
        }

        fill_vo(ans,root,0,minMax[0]);

        return

    }


}*/
