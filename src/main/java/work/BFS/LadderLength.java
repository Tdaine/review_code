package work.BFS;

import java.util.*;

/**
 * @author abaka
 * @date 2019/8/5 18:31
 */
public class LadderLength {
    /**
     * 单词接龙
     */
    class Solution {
        private int BFS(String beginWord, String endWord, Set<String> wordList){
            int num = 1;
            Set<String> book = new HashSet<String>();
            book.add(beginWord);
            Queue<String> queue = new LinkedList<String>();
            ((LinkedList<String>) queue).addLast(beginWord);
            while (!queue.isEmpty()){
                int n = queue.size();
                while (n-- > 0){
                    String curWord = queue.peek();
                    queue.poll();
                    for (int i = 0; i < curWord.length(); i++){
                        char[] newWord = curWord.toCharArray();
                        //每个位置用26个字母分别替换
                        for (char ch = 'a'; ch <= 'z'; ch++){
                            newWord[i] = ch;
                            //如果列表中没有此单词或者这个单词已经访问过了则跳过
                            if (!wordList.contains(new String(newWord)) || book.contains(new String(newWord))){
                                continue;
                            }
                            if (new String(newWord).equals(endWord))
                                return ++num;
                            //如果还没有转换为endWord就加入队列
                            ((LinkedList<String>) queue).addLast(new String(newWord));
                            book.add(new String(newWord));
                        }
                    }
                }
                //完成了一个单词，每个位置的一次转换
                num++;
            }
            return 0;
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<String>(wordList);
            return BFS(beginWord,endWord,set);
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
       int n =  new LadderLength().new Solution().ladderLength(beginWord,endWord,wordList);
        System.out.println(n);
    }
}
