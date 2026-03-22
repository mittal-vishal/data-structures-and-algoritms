package com.vishal.atlassian.codedesign;

import java.util.HashMap;

public class ShardedRouter {

    private HashMap<String,RouterWithWildcard> domainRouter;

    public ShardedRouter(){
        domainRouter = new HashMap<>();

    }

    public void addRoute(String path, String data){
        String[] paths = path.split("\\/", 2);
        String domain = paths[0];
        String remPath = paths[1];
        domainRouter.putIfAbsent(domain, new RouterWithWildcard());
        RouterWithWildcard router = domainRouter.get(domain);
        router.addRoute(path, data);
    }

    public String route(String path){
        String[] paths = path.split("\\/", 2);
        String domain = paths[0];
        String remPath = paths[1];
        RouterWithWildcard router = domainRouter.get(domain);
        return router.route(path);
    }

    public void deleteRoute(String path){
        String[] paths = path.split("\\/", 2);
        String domain = paths[0];
        String remPath = paths[1];
        domainRouter.putIfAbsent(domain, new RouterWithWildcard());
        RouterWithWildcard router = domainRouter.get(domain);
        router.deleteRoute(path);
    }

}
