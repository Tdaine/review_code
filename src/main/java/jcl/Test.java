package jcl;

import java.util.*;

/**
 * @author abaka
 * @date 2019/7/21 7:47
 */
class Person{
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (!(obj instanceof Person))
            return false;
        //此时obj确实是Person的对象且与当前对象不是一个地址
        Person person = (Person) obj;
        return this.name.equals(person.name) && this.age.equals(person.age);
    }
}


public class Test {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        list.add("hello");
//        list.add("bit");
//        list.add("java");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String str = iterator.next();
//            if (str.equals("bit")){
//                list.remove("bit");
//            }
//            System.out.println(str);
//        }

//        Person per1 = new Person(20,"zs");
//        Person per2 = new Person(20,"zs");
//        System.out.println(per1.equals(per2));
        Set<String> set = new TreeSet<String>();
        set.add("b");
        set.add("a");
        set.add("c");
        System.out.println(set);
    }

}
