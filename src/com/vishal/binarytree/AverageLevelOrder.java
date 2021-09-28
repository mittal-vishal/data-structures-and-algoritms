package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelOrder {

    public List<Double> averageOfLevels(TreeNode root) {
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
                levelList.add(polled.data);
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
