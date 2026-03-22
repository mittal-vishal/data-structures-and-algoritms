package com.vishal.atlassian.dsa;

/*
* You are maintaining the Atlassian employee directory system. The organization is structured hierarchically into groups and sub-groups, and each employee belongs to exactly one group.

Each group may have child groups, forming a tree structure rooted at the company level. Your task is to design a system that, given a list of employees, returns the closest common parent group they all belong to.

🧱 Example Group Hierarchy:
markdown
Copy
Edit
                   Company
                  /       \
               HR          Engg
             /    \      /     \
         Mona   Springs  BE     FE
                           / \   / \
                        Alice Bob Lisa Marley
🧪 Example Queries:
🔹Input: ["Lisa", "Marley"]
🔹Output: "FE"
✅ Because both Lisa and Marley are in the FE group.

🔹Input: ["Alice", "Marley"]
🔹Output: "Engg"
✅ Alice is in BE, Marley is in FE — both are under Engg.

🔹Input: ["Mona", "Lisa", "Bob"]
🔹Output: "Company"
✅ Mona is under HR, Lisa is in FE, and Bob is in BE — their closest common group is the root group Company.
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ClosestParentGroupInOrgTree {

    private static GroupNode root;

    static class GroupNode{
        String name;
        GroupNode parent;
        List<GroupNode> childrens;
        public GroupNode(String name){
            this.name = name;
            childrens = new ArrayList<>();
        }
    }

    private HashMap<String,GroupNode> employeeToGroups;

    public ClosestParentGroupInOrgTree(){
        employeeToGroups = new HashMap<>();
    }

    public static void main(String[] args) {
        ClosestParentGroupInOrgTree closestParentGroupInOrgTree = new ClosestParentGroupInOrgTree();
        GroupNode company = new GroupNode("Company");
        GroupNode hr = new GroupNode("HR");
        GroupNode engg = new GroupNode("Engg");
        GroupNode springs = new GroupNode("Springs");
        GroupNode be = new GroupNode("BE");
        GroupNode fe = new GroupNode("FE");
        closestParentGroupInOrgTree.addGroup(company, hr);
        closestParentGroupInOrgTree.addGroup(company, engg);
        closestParentGroupInOrgTree.addGroup(engg, be);
        closestParentGroupInOrgTree.addGroup(engg, fe);
        closestParentGroupInOrgTree.addGroup(hr, springs);
        closestParentGroupInOrgTree.assignEmployeeToGroup("Mona", hr);
        closestParentGroupInOrgTree.assignEmployeeToGroup("Alice", be);
        closestParentGroupInOrgTree.assignEmployeeToGroup("Bob", be);
        closestParentGroupInOrgTree.assignEmployeeToGroup("Lisa", fe);
        closestParentGroupInOrgTree.assignEmployeeToGroup("Marley", fe);
        root = company;
        System.out.println(closestParentGroupInOrgTree.getClosestCommonGroup(List.of("Lisa", "Marley")));      // Output: FE
        System.out.println(closestParentGroupInOrgTree.getClosestCommonGroup(List.of("Alice", "Marley")));     // Output: Engg
        System.out.println(closestParentGroupInOrgTree.getClosestCommonGroup(List.of("Mona", "Lisa", "Bob"))); // Output: Company
    }

    private void assignEmployeeToGroup(String name, GroupNode group) {
        employeeToGroups.put(name, group);
    }

    private void addGroup(GroupNode parent, GroupNode child) {
        parent.childrens.add(child);
        child.parent = parent;
    }

    public String getClosestCommonGroup(List<String> employees){
        GroupNode resultant = employeeToGroups.get(employees.get(0));;
        for(int i = 1; i < employees.size(); i++){
            String nextEmp = employees.get(i);
            GroupNode nextGroupNode = employeeToGroups.get(nextEmp);
            resultant = getLca(resultant, nextGroupNode);
        }
        return resultant.name;
    }

    private GroupNode getLca(GroupNode a, GroupNode b){
        HashSet<GroupNode> nodes = new HashSet<>();
        while(a != null){
            nodes.add(a);
            a = a.parent;
        }
        while(b != null){
            if(nodes.contains(b)){
                return b;
            }
            b = b.parent;
        }
        return null;
    }

}
