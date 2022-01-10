package com.vishal.microsoft;

public class RoadPotholes {

    public static int solution(String L1, String L2, boolean isFirstLane, int idx, boolean isLineChange) {
        if(idx == L1.length()){
            return 0;
        }
        char ch1 = L1.charAt(idx);
        char ch2 = L2.charAt(idx);
        if(ch1 == '.' && ch2 == '.' && !isLineChange && isFirstLane){
            return Math.max(solution(L1, L2, true, idx + 1, false),
                    solution(L1, L2, false, idx + 1, true));
        }else if(ch1 == '.' && ch2 == '.' && !isLineChange && !isFirstLane){
            return Math.max(solution(L1, L2, true, idx + 1, true),
                    solution(L1, L2, false, idx + 1, false));
        }else if(ch1 == '.' && ch2 == '.' && isLineChange && isFirstLane){
            return solution(L1, L2, true, idx + 1, true);
        }else if(ch1 == '.' && ch2 == '.' && isLineChange && !isFirstLane){
            return solution(L1, L2, false, idx + 1, true);
        }else if(ch1 == 'x' && ch2 == 'x' && !isLineChange && isFirstLane){
            return 1 + Math.max(solution(L1, L2, true, idx + 1, false),
                    solution(L1, L2, false, idx + 1, true));
        }else if(ch1 == 'x' && ch2 == 'x' && !isLineChange && !isFirstLane){
            return 1 + Math.max(solution(L1, L2, true, idx + 1, true),
                    solution(L1, L2, false, idx + 1, false));
        }else if(ch1 == 'x' && ch2 == 'x' && isLineChange && isFirstLane){
            return 1 + solution(L1, L2, true, idx + 1, true);
        }else if(ch1 == 'x' && ch2 == 'x' && isLineChange && !isFirstLane){
            return 1 + solution(L1, L2, false, idx + 1, true);
        }else if(ch1 == '.' && ch2 == 'x' && isFirstLane && isLineChange){
            return 1 + solution(L1, L2, true, idx + 1, true);
        }else if(ch1 == '.' && ch2 == 'x' && isFirstLane && !isLineChange){
            return 1 + solution(L1, L2, true, idx + 1, false);
        }else if(ch2 == '.' && ch1 == 'x' && !isFirstLane && isLineChange){
            return 1 + solution(L1, L2, false, idx + 1, true);
        }else if(ch2 == '.' && ch1 == 'x' && !isFirstLane && !isLineChange){
            return 1 + solution(L1, L2, false, idx + 1, false);
        }else if(ch1 == '.' && ch2 == 'x' && !isFirstLane && isLineChange){
            return solution(L1, L2, false, idx + 1, true);
        }else if(ch1 == '.' && ch2 == 'x' && !isFirstLane && !isLineChange){
            return solution(L1, L2, false, idx + 1, false);
        }else if(ch2 == '.' && ch1 == 'x' && isFirstLane && isLineChange){
            return solution(L1, L2, true, idx + 1, true);
        }else if(ch2 == '.' && ch1 == 'x' && isFirstLane && !isLineChange){
            return solution(L1, L2, true, idx + 1, false);
        }
        return 0;
    }

    public static void main(String[] args) {
        String l1 = "x...x";
        String l2 = "..x..";
        int x = Math.max(solution(l1, l2, true, 0, false),
                solution(l1, l2, false, 0, false));
        System.out.println(x);
    }

}
