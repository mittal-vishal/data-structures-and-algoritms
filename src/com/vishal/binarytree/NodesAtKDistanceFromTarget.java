package com.vishal.binarytree;

import java.util.*;

public class NodesAtKDistanceFromTarget {

    private HashMap<TreeNode,TreeNode> parentMap;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        parentMap = new HashMap<>();
        getParent(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int dist = 0;
        HashSet<TreeNode> visited = new HashSet<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(visited.contains(curr)){
                    continue;
                }
                visited.add(curr);
                if(dist == k){
                    result.add(curr.val);
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
                TreeNode parent = parentMap.get(curr);
                if(parent != null){
                    queue.offer(parent);
                }
            }
            dist++;
        }
        return result;
    }

    private void getParent(TreeNode root, TreeNode parent){
        if(root == null){
            return;
        }
        parentMap.put(root, parent);
        getParent(root.left, root);
        getParent(root.right, root);
    }

}
