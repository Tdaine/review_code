package work.DFS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author abaka
 * @date 2019/7/30 11:33
 */
public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}

class Solution {

    public int DFS(Map<Integer,Employee> map,int id){
        int count = 0;

        count += map.get(id).importance;

        for (int n : map.get(id).subordinates){
             count += DFS(map,n);
        }
        return count;
    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null)
            return 0;
        Map<Integer,Employee> map = new HashMap<Integer, Employee>();
        for (int i = 0; i < employees.size(); i++){
            map.put(employees.get(i).id,employees.get(i));
        }

        return DFS(map,id);
    }
}