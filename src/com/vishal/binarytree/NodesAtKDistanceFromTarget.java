package com.vishal.binarytree;

import java.util.*;

public class NodesAtKDistanceFromTarget {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(K == 0){
            return new ArrayList<>(Arrays.asList(target.val));
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        dfs(root, null, parentMap);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        List<Integer> retList = new ArrayList<>();
        Set<TreeNode> seen = new HashSet<>();

        while(!queue.isEmpty() && K >= 0){
            int queueSize = queue.size();
            TreeNode polled = null;
            for(int i = 0; i < queueSize; i++){
                polled = queue.poll();
                if(K == 0){
                    retList.add(polled.val);
                }
                if(polled.left != null && !seen.contains(polled.left)){
                    queue.offer(polled.left);
                }
                if(polled.right != null && !seen.contains(polled.right)){
                    queue.offer(polled.right);
                }
                if(parentMap.get(polled) != null && !seen.contains(parentMap.get(polled))){
                    queue.offer(parentMap.get(polled));
                }
                seen.add(polled);
            }
            K--;
        }

        return retList;
    }

    private void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap){
        if(root == null){
            return;
        }
        parentMap.put(root, parent);
        dfs(root.left, root, parentMap);
        dfs(root.right, root, parentMap);
    }

}
