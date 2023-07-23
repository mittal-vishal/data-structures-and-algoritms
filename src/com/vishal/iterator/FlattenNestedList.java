package com.vishal.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlattenNestedList {

    interface NestedInteger{
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private LinkedList<Integer> flattenList;

        public NestedIterator(List<NestedInteger> nestedList) {
            flattenList = new LinkedList<>();
            flatten(nestedList);
        }

        private void flatten(List<NestedInteger> nestedList){
            for(NestedInteger nestedInteger: nestedList){
                if(nestedInteger.isInteger()){
                    flattenList.add(nestedInteger.getInteger());
                }else{
                    flatten(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            Integer curr = flattenList.removeFirst();
            return curr;
        }

        @Override
        public boolean hasNext() {
            return flattenList.size() > 0;
        }
    }

}
