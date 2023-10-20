package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        int resultListIdx = 0;
        List<List<String>> resultList = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, ArrayList<String>> mapStrMapToStrings = new HashMap<>();


        if(strs.length == 0) return resultList;

        HashMap<Character, Integer> map = createMapForString(strs[0]);
        ArrayList<String> list =new ArrayList<>(); list.add(strs[0]);
        mapStrMapToStrings.put(map, list);

        for(int i=1;i<strs.length;i++){
            HashMap<Character, Integer> strMap = createMapForString(strs[i]);
            if(mapStrMapToStrings.get(strMap)!=null){
                mapStrMapToStrings.get(strMap).add(strs[i]);
            }
            else{
                list =new ArrayList<>(); list.add(strs[i]);
                mapStrMapToStrings.put(strMap, list);
            }
        }

        for(Map.Entry<HashMap<Character, Integer>, ArrayList<String>> entry: mapStrMapToStrings.entrySet()){
            resultList.add(entry.getValue());
        }

        return resultList;

    }

    public HashMap<Character, Integer> createMapForString(String first){

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<first.length();i++){
            char currChar = first.charAt(i);
            if(map.get(currChar)==null){
                map.put(currChar,1);
            }
            else{
                map.put(currChar, map.get(currChar)+1);
            }
        }

        return map;
    }
}
