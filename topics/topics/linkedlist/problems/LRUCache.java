package linkedlist.problems;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LRUCache {

    class KeyToTimeStamp {
        int key;
        int timeStamp;

        public KeyToTimeStamp(int key, int timeStamp) {
            this.key = key;
            this.timeStamp = timeStamp;
        }

        public int getKey() {
            return key;
        }

        public int getTimeStamp() {
            return timeStamp;
        }
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, KeyToTimeStamp> mapKeyToTSObject = new HashMap<>();
    PriorityQueue<KeyToTimeStamp> queue = new PriorityQueue<>((c1, c2) -> Integer.compare(c1.getTimeStamp(), c2.getTimeStamp()));
    int capacity = 3;
    int time = -1;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.time = 0;
    }

    public int get(int key) {
        int answer = -1;
        if (map.containsKey(key)) {
            answer = map.get(key);
        } else {
            return answer;
        }
        KeyToTimeStamp keyToTimeStamp = mapKeyToTSObject.get(key);
        queue.remove(keyToTimeStamp);

        KeyToTimeStamp keyToTimeStamp1 = new KeyToTimeStamp(key, time);
        queue.add(keyToTimeStamp1);
        mapKeyToTSObject.put(key, keyToTimeStamp1);

        incrementTime();

        return answer;
    }

    public void put(int key, int value) {

        if (queue.size() == capacity && !map.containsKey(key)) {
            //remove.
            KeyToTimeStamp keyToTimeStamp = queue.remove();
            mapKeyToTSObject.remove(keyToTimeStamp.getKey());
            map.remove(keyToTimeStamp.getKey());
        } else if (map.containsKey(key)) {
            //remove from queue - as new entry will come.
            KeyToTimeStamp keyToTimeStamp = mapKeyToTSObject.get(key);
            mapKeyToTSObject.remove(key);
            queue.remove(keyToTimeStamp);
        }

        map.put(key, value);
        KeyToTimeStamp keyTimeStampObject = new KeyToTimeStamp(key, time);
        queue.add(keyTimeStampObject);
        mapKeyToTSObject.put(key, keyTimeStampObject);

        incrementTime();
    }

    private void incrementTime() {
        time += 1;
    }

    class DLLNode {
        int key;
        int data;
        DLLNode left;
        DLLNode right;

        public DLLNode(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    DLLNode head;
    DLLNode tail;
    int size = 0;
    HashMap<Integer, DLLNode> mapKeyToNode = new HashMap<>();
    public void LRUCacheDLL(int capacity) {
        this.capacity = capacity;
        head.right = tail;
        tail.left = head;
    }

    // h -> 2 > 3 > t
    public void putDLL(int key, int value) {
        if(size == capacity && !mapKeyToNode.containsKey(key)) {
            //delete the last entry.
            DLLNode lastNode = tail.left;
            DLLNode secondLastNode = lastNode.left;
            secondLastNode.right = tail;
            tail.left = secondLastNode;
            mapKeyToNode.remove(lastNode.key);
        }
        else if(mapKeyToNode.containsKey(key)){
            //deletion.
            DLLNode dllNode = mapKeyToNode.get(key);
            DLLNode left = dllNode.left;
            DLLNode right = dllNode.right;
            left.right = right;
            right.left = left;
        }

        DLLNode newNode = new DLLNode(key, value);
        DLLNode firstNode = head.right;
        firstNode.left = newNode;
        newNode.right = firstNode;
        head.right = newNode;
        newNode.left = head;

        incrementTime();
    }

    public int getDLL(int key) {
        int answer = -1;
        DLLNode node;
        if(mapKeyToNode.containsKey(key)){
            node = mapKeyToNode.get(key);
            answer = node.data;
        }
        else{
            return answer;
        }

//        mapKeyToNode.
        return answer;
    }


    public static void main(String[] args) {

        String[] operations = {"LRUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put",
                "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get",
                "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put",
                "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put",
                "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put",
                "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put",
                "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};

        int[][] inputs = new int[][]{{10}, {10, 13}, {3, 17}, {6, 11}, {10, 5}, {9, 10}, {13}, {2, 19}, {2}, {3}, {5, 25}, {8}, {9, 22}, {5, 5},
                {1, 30}, {11}, {9, 12}, {7}, {5}, {8}, {9}, {4, 30}, {9, 3}, {9}, {10}, {10}, {6, 14}, {3, 1}, {3}, {10, 11}, {8}, {2, 14}, {1}, {5},
                {4}, {11, 4}, {12, 24}, {5, 18}, {13}, {7, 23}, {8}, {12}, {3, 27}, {2, 12}, {5}, {2, 9}, {13, 4}, {8, 18}, {1, 7}, {6}, {9, 29}, {8, 21},
                {5}, {6, 30}, {1, 12}, {10}, {4, 15}, {7, 22}, {11, 26}, {8, 17}, {9, 29}, {5}, {3, 4}, {11, 30}, {12}, {4, 29}, {3}, {9}, {6}, {3, 4}, {1},
                {10}, {3, 29}, {10, 28}, {1, 20}, {11, 13}, {3}, {3, 12}, {3, 8}, {10, 9}, {3, 26}, {8}, {7}, {5}, {13, 17}, {2, 27}, {11, 15}, {12},
                {9, 19}, {2, 15}, {3, 16}, {1}, {12, 17}, {9, 1}, {6, 19}, {4}, {5}, {5}, {8, 1}, {11, 7}, {5, 2}, {9, 28}, {1}, {2, 2}, {7, 4},
                {4, 22}, {7, 24}, {9, 26}, {13, 28}, {11, 26}};

        Integer[] expected = new Integer[]{null, null, null, null, null, null, -1, null, 19, 17, null, -1, null, null, null, -1, null, -1, 5, -1, 12,
                null, null, 3, 5, 5, null, null, 1, null, -1, null, 30, 5, 30, null, null, null, -1, null, -1, 24, null, null, 18, null, null, null,
                null, -1, null, null, 18, null, null, -1, null, null, null, null, null, 18, null, null, -1, null, 4, 29, 30, null, 12, -1, null,
                null, null, null, 29, null, null, null, null, 17, 22, 18, null, null, null, -1, null, null, null, 20, null, null, null, -1, 18,
                18, null, null, null, null, 20, null, null, null, null, null, null, null};

        LRUCache lruCache = new LRUCache(inputs[0][0]);

        for (int i = 1; i < operations.length; i++) {
            if (operations[i].equals("put")) {

                lruCache.put(inputs[i][0], inputs[i][1]);
            } else {
                int input = inputs[i][0];
                int answer = lruCache.get(input);
                if (answer != expected[i]) {
                    System.out.println("input:" + input + ", answer:" + answer + ", expected:" + expected[i]);
                    return;
                } else {
                    System.out.println("answer:" + answer);
                }
            }
        }

    }

}
