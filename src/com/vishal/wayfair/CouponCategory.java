package com.vishal.wayfair;

import java.util.HashMap;

/*
*
* /*
Given the following data set, find the coupon to display for a given category.
Note: Category structure is hierarchical. Categories without coupons inherit their parent’s coupon.

# data

Coupons = [
    {"CategoryName":"Comforter Sets", "CouponName":"Comforters Sale"},
    {"CategoryName":"Bedding", "CouponName":"Savings on Bedding"},
    {"CategoryName":"Bed & Bath", "CouponName":"Low price for Bed & Bath"}
]

Categories = [
    {"CategoryName":"Comforter Sets", "CategoryParentName":"Bedding"},
    {"CategoryName":"Bedding", "CategoryParentName":"Bed & Bath"},
    {"CategoryName":"Bed & Bath", "CategoryParentName":null},
    {"CategoryName":"Soap Dispensers", "CategoryParentName":"Bathroom Accessories"},
    {"CategoryName":"Bathroom Accessories", "CategoryParentName":"Bed & Bath"},
    {"CategoryName":"Toy Organizers", "CategoryParentName":"Baby And Kids"},
    {"CategoryName":"Baby And Kids", "CategoryParentName":null}
]

# tests: input(CategoryName) => output(CouponName)

"Comforter Sets"       => "Comforters Sale"
"Bedding"              => "Savings on Bedding"
"Bathroom Accessories" => "Low price for Bed & Bath"
"Soap Dispensers"      => "Low price for Bed & Bath"
"Toy Organizers"       => null

HashMap<Category,Coupon>
HashMap<Node, Parent_Node>

class CategoryNode{
    String name;
    CategoryNode left;
    CategoryNode right;

}

*/
public class CouponCategory {

    private static HashMap<String, String> categoryCouponsMap;
    private static HashMap<CategoryNode, CategoryNode> nodeParentMap;

    static class CategoryNode{
        String name;
        CategoryNode left;
        CategoryNode right;
        String coupon;
        CategoryNode(String name){
            this.name = name;
        }
        CategoryNode(String name, String coupon){
            this.name = name;
            this.coupon = coupon;
        }
    }

    public static void main(String[] args) {
        CategoryNode root = new CategoryNode("Bed & Bath", "Low price for Bed & Bath");
        root.left = new CategoryNode("Bedding", "Savings on Bedding");
        root.left.left = new CategoryNode("Comforter Sets","Comforters Sale");
        root.right = new CategoryNode("Bathroom Accessories");
        root.right.left = new CategoryNode("Soap Dispensers");
        CategoryNode root2 = new CategoryNode("Baby And Kids");
        root2.left = new CategoryNode("Toy Organizers");
        System.out.println(getCategoryCoupons(root, "Toy Organizers"));
    }

    private static String getCategoryCoupons(CategoryNode root, String categoryName){
        categoryCouponsMap = new HashMap<>();
        nodeParentMap = new HashMap<>();
        dfs(root);
        initializeParent(root, null);
        CategoryNode categoryNode = getCategoryNode(root, categoryName);
        String result = getResult(categoryNode);
        return result;
    }

    private static String getResult(CategoryNode node){
        if(node == null){
            return null;
        }else if(node.coupon != null){
            return node.coupon;
        }
        CategoryNode parentCategory = nodeParentMap.get(node);
        return getResult(parentCategory);
    }

    private static void dfs(CategoryNode root){
        if(root == null){
            return;
        }
        categoryCouponsMap.put(root.name, root.coupon);
        dfs(root.left);
        dfs(root.right);
    }

    private static void initializeParent(CategoryNode root, CategoryNode parent){
        if(root == null){
            return;
        }
        nodeParentMap.put(root, parent);
        initializeParent(root.left, root);
        initializeParent(root.right, root);
    }

    private static CategoryNode getCategoryNode(CategoryNode root, String categoryName){
        if(root == null){
            return null;
        }else if(root.name.equals(categoryName)){
            return root;
        }
        CategoryNode left = getCategoryNode(root.left, categoryName);
        CategoryNode right = getCategoryNode(root.right, categoryName);
        return left != null? left: right;
    }
}
