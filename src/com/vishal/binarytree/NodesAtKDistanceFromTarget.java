package com.vishal.binarytree;

import java.util.*;

public class NodesAtKDistanceFromTarget {

    Map<TreeNode,TreeNode> parentMap;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();
        getParent(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                TreeNode polled = queue.poll();
                if(polled.left != null && !visited.contains(polled.left)){
                    queue.offer(polled.left);
                }
                if(polled.right != null && !visited.contains(polled.right)){
                    queue.offer(polled.right);
                }
                if(parentMap.get(polled) != null && !visited.contains(parentMap.get(polled))){
                    queue.offer(parentMap.get(polled));
                }
                visited.add(polled);
                if(k == 0){
                    result.add(polled.val);
                }
            }
            k--;
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
