package programmers;

public class Combination {
  
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        boolean[] visited = new boolean[arr.length];
        int n = arr.length;
        int r = 2;
        System.out.println("=====recursive=====");
        recursiveCombination(arr, visited, 0, n, r);
        System.out.println("=====backtracking=====");
        backtrackingCombination(arr, visited, 0, n, r);
    }
    static void recursiveCombination(int[] arr, boolean[] visited
    		, int depth, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }
        if (depth == n) {
        	return;
        }
        visited[depth] = true;
        System.out.println("true : "+depth + " "+r+" ");
        recursiveCombination(arr, visited, depth + 1, n, r - 1);
       
        visited[depth] = false;
        System.out.println("false : "+ depth + " "+r+" ");
        recursiveCombination(arr, visited, depth + 1, n, r);
    }
  
    /**
     * 백트래킹 사용
     * nCr : n개의 항목에서 r개를 뽑는다.
     * n : 전체 크기 혹은 길이
     * r : 뽑을 갯수
     */
    static void backtrackingCombination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }
  
        for (int i = start; i < n; i++) {
            visited[i] = true;
            backtrackingCombination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
  
    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}