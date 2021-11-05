package com.vishal.binarytree;

import java.util.*;

public class NodesAtKDistanceFromTarget {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k < 0){
            return new ArrayList<>();
        }else if(k == 0){
            return new ArrayList<>(Arrays.asList(target.val));
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        getParent(root, null, parentMap);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);

        List<Integer> kNodeList = new ArrayList<>();
        Set<TreeNode> visitedSet = new HashSet<>();

        while(!queue.isEmpty() && k >= 0){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                TreeNode polled = queue.poll();
                if(k == 0){
                    kNodeList.add(polled.val);
                }
                if(polled.left != null && !visitedSet.contains(polled.left)){
                    queue.offer(polled.left);
                }
                if(polled.right != null && !visitedSet.contains(polled.right)){
                    queue.offer(polled.right);
                }
                TreeNode parent = parentMap.get(polled);
                if(parent != null && !visitedSet.contains(parent)){
                    queue.offer(parent);
                }
                visitedSet.add(polled);
            }
            k--;
        }
        return kNodeList;
    }

    private void getParent(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap){
        if(root == null){
            return;
        }
        parentMap.put(root, parent);
        getParent(root.left, root, parentMap);
        getParent(root.right, root, parentMap);
    }

}
