package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args){
        PriorityQueue<Integer> pq =  new PriorityQueue<Integer>(5, new StudentComparator());
/*
        Student student1 =  new Student("Nandhini",3.2);
        pq.add(student1);
        Student student2 =  new Student("Radha",4.8);
        pq.add(student2);
        Student student3 =  new Student("kavya",2.2);
        pq.add(student3);*/

        pq.add(8);
        pq.add(70);
        pq.add(6);

        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

    static class StudentComparator implements Comparator<Integer>{
/*
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.cpga > o2.cpga) return 1;
            else if(o1.cpga < o2.cpga) return -1;
            return 0;
        }*/

        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 > o2) return 1;
            else if(o1 < o2) return -1;
            return 0;
        }
    }

   static class Student {
        public String name;
        public double cpga;

        public Student(String name, double c){
            this.name = name;
            this.cpga = c;
        }

        public String getName(){
            return name;
        }
    }
}
