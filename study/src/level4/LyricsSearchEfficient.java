package level4;


import java.util.*;

public class LyricsSearchEfficient {
    /**
     * Trie Class
     */
    private static class Trie {
        Node prefix;
        Node suffix;

        Trie() {
            this.prefix = new Node();
            this.suffix = new Node();
        }

        /**
         * 삽입
         * @param str
         */
        public void insert(String str,int opt) {
            Node front = prefix;
            Node back = suffix;
            if (opt == 0) {
                for (char ch : str.toCharArray()) {
                    front.count++;
                    front = front.childNodes.computeIfAbsent(ch, c -> new Node());
                }
            }
            if (opt == 1) {
                for (char ch : str.toCharArray()) {
                    back.count++;
                    back = back.childNodes.computeIfAbsent(ch, c -> new Node());
                }
            }
        }


        private int getCount(String query) {
            Node node = null;

            if(query.charAt(0) == '?'){
                node = suffix;
                query = new StringBuffer(query).reverse().toString();
            }else{
                node = prefix;
            }

            for (char ch : query.toCharArray()) {
                if (ch == '?') break;
                if (!node.childNodes.containsKey(ch)) return 0;
                node = node.childNodes.get(ch);
            }
            return node.count;
        }

    }

    /**
     * Node Class
     */
    private static class Node {
        int count = 0;
        HashMap<Character, Node> childNodes = new HashMap<>();
    }

    private static String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
    private static String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

    private static int[] solution(String[] words, String[] queries){
        //Trie 배열 words 자릿수
        Trie[] tries = new Trie[100001];
        int[] answer = new int[queries.length];

        //문자열 입력
        for (String word : words) {
            if(tries[word.length()]==null) tries[word.length()] = new Trie();
            String reverseWord  = new StringBuffer(word).reverse().toString();
            tries[word.length()].insert(word, 0);
            tries[word.length()].insert(reverseWord, 1);
        }

        //검색 동일 개수 카운트
        for (int i = 0; i < queries.length; i++) {
            int len = queries[i].length();
            if (tries[len] == null) answer[i] = 0;
            else answer[i] = tries[len].getCount(queries[i]);
        }

        return answer;
    }
    public static void main(String[] args) {
        for(int i : solution(words,queries)){
            System.out.print(i);
        }
    }
}
