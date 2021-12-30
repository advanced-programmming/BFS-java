package com.co.pa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

// Busqueda por anchura -> (BFS -> breadth-first search)
public class Main {

    static int MAX = 5;
    static int MIN = 0;
    static List<List<Integer>> listAdjacent = getDataFake(); // La adjacent list
    static long visited[] = new long[MAX + 1];
    static Queue<Integer> controlQueue = new LinkedList<>(); // Control queue for visited nodes.

    public static void main(String[] args) {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int startNode = tlr.nextInt(MIN, (MAX + 1));
        bfs(startNode);
    }

    public static void bfs(int startNode){
        controlQueue.add(startNode); // Add startNode in queue
        visited[startNode] = 1; // startNode in there moment was visited
        int actualNode, index, nextNode;

        while (!controlQueue.isEmpty()){ //while the queue is empty
            actualNode = controlQueue.poll(); // get out the next node
            validateAdjacent(actualNode); // validate adjacent nodes
        }
    }

    public static void validateAdjacent(int actualNode){
        int nextNode;
        for(int i = 0; i < listAdjacent.get(actualNode).size(); i++){
            nextNode = listAdjacent.get(actualNode).get(i);

            if(visited[nextNode] == 0){
                visited[nextNode] = 1;
                controlQueue.add(nextNode);
            }
        }
    }

    public static List<List<Integer>> getDataFake(){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        list0.add(5);

        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(4);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(3);

        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(5);
        list3.add(4);

        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(2);
        list4.add(3);

        List<Integer> list5 = new ArrayList<>();
        list5.add(0);
        list5.add(3);
        list5.add(2);

        result.add(list0);
        result.add(list1);
        result.add(list2);
        result.add(list3);
        result.add(list4);
        result.add(list5);
        return result;
    }
}
