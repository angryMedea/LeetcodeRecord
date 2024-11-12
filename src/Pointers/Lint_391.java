package Pointers;

import sun.jvm.hotspot.utilities.Interval;

import java.util.*;

public class Lint_391 {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(2, 8);
        Interval interval3 = new Interval(3, 7);
        Interval interval4 = new Interval(4, 5);
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);
        System.out.println(new Lint_391().countOfAirplanes(list));
    }

    /**
     * start: when the plane takes off
       end: when the plane lands
     */
    static class Interval{
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Node {
        //if the time is start time, then cost = 1
        //if the time is land time, then cost = -1
        //cost is used to calculate the total number in the sky
        int time;
        int cost;

        public Node() {
        }

        public Node(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }
        //sort time in increasing order, if times are same, compare the cost, put the smaller one in the first
        static Comparator<Node> cNode = (o1, o2) -> {
            if (o1.time != o2.time){
                return o1.time - o2.time;
            }
            return o1.cost - o2.cost;
        };

        public int countOfAirplanes(List<Interval> airplanes){

            List<Node> room = new ArrayList<>();
            for (int i = 0; i < airplanes.size(); i++) {
                room.add(new Node(airplanes.get(i).start,1));
                room.add(new Node(airplanes.get(i).end,-1));
            }
            Collections.sort(room,cNode);
            int ans = 0;
            int tmp = 0;
            for (int i = 0; i < room.size(); i++) {
                tmp += room.get(i).cost;
                ans = Math.max(ans,tmp);
            }
            return ans;
        }
    }

