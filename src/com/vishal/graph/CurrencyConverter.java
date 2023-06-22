package com.vishal.graph;


/*

Given historical currency conversions, design a tool to convert any given currencies.

100.00,USD,8500.00,INR

1000.00,USD,1500.00,EURO

50.00,EURO,400.00,SGD

float getConvertedAmount(float sourceAmount, Currency source, Currency target)

getConvertedAmount(100.00, USD, INR) ==> 8500.00


GraphNode{
    String srcCurrency;
    String destCurrency;
    float conversionRate;
}

{USD, INR, 85}
{USD, EURO, 15}
{EURO, SGD, 8}

1USD = 15 EURO
1EURO - 8SGD = X

USD-SGD

T(N) = O(K)
S(N) = O(K)

USD,INR = 85
USD,EURO = 15
HashMap<Pair,Float>


100.00,USD,8500.00,INR

1000.00,USD,1500.00,EURO

50.00,EURO,400.00,SGD

*
*
* */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CurrencyConverter {

    private List<CurrencyConversionData> historicalData;
    private HashMap<String, Integer> currencyNodesMap;

    class CurrencyConversionData{
        String srcCurrency;
        float srcRate;
        String targetCurrency;
        float destRate;
        CurrencyConversionData(String srcCurrency, float srcRate, String targetCurrency, float destRate){
            this.srcCurrency = srcCurrency;
            this.srcRate = srcRate;
            this.targetCurrency = targetCurrency;
            this.destRate = destRate;
        }
    }

    static class GraphNode{
        String currency;
        float conversionRate;
        public GraphNode(String currency, float rate){
            this.currency = currency;
            this.conversionRate = rate;
        }
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        float result = converter.getConvertedAmount(1000,"USD", "INR");
        System.out.println(result);
    }

    private float getConvertedAmount(float sourceAmount, String source, String target){
        List<List<GraphNode>> graph = new ArrayList<>();
        getHistoricalData();
        initializeGraph(graph);
        HashSet<String> visitedSet = new HashSet<>();
        float finalRate =  dfs(source, target, graph, -1, visitedSet);
        float finalAmount = sourceAmount * finalRate;
        return finalAmount;
    }

    private float dfs(String source, String target, List<List<GraphNode>> graph, float rate, HashSet<String> visitedSet) {
        if(source.equals(target)){
            return rate;
        }
        for(GraphNode neighbour: graph.get(currencyNodesMap.get(source))){
            if(!visitedSet.contains(neighbour)){
                float conversionRate = rate != -1 ? rate * neighbour.conversionRate: neighbour.conversionRate;
                return dfs(neighbour.currency, target, graph, conversionRate, visitedSet);
            }
        }
        return 0f;
    }

    /*
    1000.00,USD,1500.00,EURO
    50.00,EURO,400.00,SGD
    * */

    private void initializeGraph(List<List<GraphNode>> graph) {
        for(int i = 0; i < historicalData.size(); i++){
            graph.add(new ArrayList<>());
        }
        currencyNodesMap = new HashMap<>();
        int node = 0;
        for(CurrencyConversionData currencyConversionData: historicalData){
            String srcCurrency = currencyConversionData.srcCurrency;
            String destCurrency = currencyConversionData.targetCurrency;
            float conversionRate = currencyConversionData.destRate/currencyConversionData.srcRate;
            if(!currencyNodesMap.containsKey(srcCurrency)){
                currencyNodesMap.put(srcCurrency, node++);
            }
            graph.get(currencyNodesMap.get(srcCurrency)).add(new GraphNode(destCurrency, conversionRate));
        }
    }

    private void getHistoricalData() {
        historicalData = new ArrayList<>();
        historicalData.add(new CurrencyConversionData("USD", 100, "INR", 8500));
        historicalData.add(new CurrencyConversionData("USD", 1000, "EURO", 1500));
        historicalData.add(new CurrencyConversionData("EURO", 50, "SGD", 400));
    }

}
