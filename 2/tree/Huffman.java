package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Huffman {

    class HuffmanNode {
        public char c;
        public int freq;
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public void huffmanCoding(char[] chars, int[] frequencies) {

        ArrayList<HuffmanNode> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(new HuffmanNode(chars[i], frequencies[i]));
        }



    }

}
