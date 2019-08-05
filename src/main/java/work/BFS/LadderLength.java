package work.BFS;

import java.util.*;

/**
 * @author abaka
 * @date 2019/8/5 18:31
 */
public class LadderLength {
    class Solution {
        private int BFS(String beginWord, String endWord, Set<String> wordList){
            int num = 0;
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
                            if (!wordList.contains(newWord.toString()) || book.contains(newWord.toString())){
                                continue;
                            }
                            if (newWord.equals(endWord))
                                return num++;
                            //如果还没有转换为endWord就加入队列
                            ((LinkedList<String>) queue).addLast(newWord.toString());
                            book.add(newWord.toString());
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
}
