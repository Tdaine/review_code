package work.BFS;

import java.util.*;

/**
 * @author abaka
 * @date 2019/7/27 19:06
 */


// Employee info

/**
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 *
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

public class GetImportance {
    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            int res = 0;
            //队列中存储的是员工id
            Queue<Integer> queue = new LinkedList<Integer>();
            //使用map记录员工信息
            Map<Integer,Employee> map = new HashMap<Integer, Employee>();
            for (int i = 0; i < employees.size(); i++){
                map.put(employees.get(i).id,employees.get(i));
            }
            ((LinkedList<Integer>) queue).addLast(id);
            while (!queue.isEmpty()){
                int n = queue.poll();
                res += map.get(n).importance;
                //读取List集合存储的员工id
                for (int num : map.get(n).subordinates){
                    ((LinkedList<Integer>) queue).addLast(num);
                }
            }
            return res;
        }
    }
}
