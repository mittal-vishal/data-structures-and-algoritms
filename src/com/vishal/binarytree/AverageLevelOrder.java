package com.vishal.binarytree;

import java.util.*;

public class AverageLevelOrder {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageLevelList = new ArrayList<>();

        if(root == null){
            return averageLevelList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int qSize = queue.size();
            double levelSum = 0;
            for(int i = 0; i < qSize; i++){
                TreeNode polled = queue.poll();
                levelSum += polled.val;
                if(polled.left != null){
                    queue.offer(polled.left);
                }
                if(polled.right != null){
                    queue.offer(polled.right);
                }
            }
            double lineAvg = levelSum / qSize;
            averageLevelList.add(lineAvg);
        }
        return averageLevelList;
    }

    public List<Double> averageOfLevelsUsineNull(TreeNode root) {
        List<Double> levelAverageList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> levelList = new ArrayList<>();

        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()){
            TreeNode polled = queue.poll();
            if(polled == null){
                double levelSize = levelList.size();
                double lineSum = 0;
                for(int levelNum: levelList){
                    lineSum += levelNum;
                }
                double lineAvg = lineSum/levelSize;
                levelAverageList.add(lineAvg);
                levelList = new ArrayList<>();
                if(queue.size() > 0){
                    queue.offer(null);
                }
            }else{
                levelList.add(polled.val);
                if(polled.left != null){
                    queue.offer(polled.left);
                }
                if(polled.right != null){
                    queue.offer(polled.right);
                }
            }
        }
        return levelAverageList;
    }

}
