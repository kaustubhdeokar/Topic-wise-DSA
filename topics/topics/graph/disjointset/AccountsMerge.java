package graph.disjointset;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {
    public static void main(String[] args) {

        AccountsMerge accountsMerge = new AccountsMerge();
        String[][] list = new String[][]{
                {"John","johnsmith@mail.com","john_newyork@mail.com"},
                {"John","johnsmith@mail.com","john00@mail.com"},
                {"Mary","mary@mail.com"},
                {"John","johnnybravo@mail.com"}
        };

        List<List<String>> collect = Arrays.stream(list).map(Arrays::asList).collect(Collectors.toList());
        accountsMerge.accountsMerge(collect);

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Integer> mapEmailToIndex = new HashMap<>();
        int n = accounts.size();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
        }

        for (int i = 0; i < accounts.size(); i++) {
            List<String> accountEmails = accounts.get(i);

            for (int j = 1; j < accountEmails.size(); j++) {
                String email = accountEmails.get(j);
                if (mapEmailToIndex.get(email) != null) {
                    int u = mapEmailToIndex.get(email);
                    int v = i;
                    merge(v, u, parent, size);
                    break;
                }
                mapEmailToIndex.put(email, i);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (int p = 0; p < parent.length; p++) {
            int currParent = parent[p];
            System.out.print(currParent + " ");
            while (res.size() <= currParent) {
                res.add(new ArrayList<>());
            }
            List<String> strings = accounts.get(p);
            res.get(currParent).addAll(strings);
        }

//        List<List<String>> result = new ArrayList<>();
//        for(List<String> strings: res){
//            if(!strings.isEmpty()){
//                Set<String> setString = new HashSet<>(strings);
//
//                Collections.sort(strings);
//                result.add(new ArrayList<>());
//            }
//        }

        System.out.println(res);

        return res;

    }

    public int findParent(int node, int[] parent) {
        if (parent[node] == node) return node;
        int newParent = findParent(parent[node], parent);
        parent[node] = newParent;
        return newParent;
    }

    public void merge(int u, int v, int[] parent, int[] size) {
        int upar = findParent(u, parent);
        int vpar = findParent(v, parent);

        if (upar == vpar) return;

        else if (size[upar] > size[vpar]) {
            size[upar] += size[vpar];
            parent[vpar] = upar;
        } else {
            size[vpar] += size[upar];
            parent[upar] = vpar;
        }
    }


}
