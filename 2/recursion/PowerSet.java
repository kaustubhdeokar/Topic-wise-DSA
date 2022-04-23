//https://www.geeksforgeeks.org/powet-set-lexicographic-order/

 public LinkedHashSet<String> powerSet(String processed, String unprocessed) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add(processed);
        if (unprocessed.isEmpty()) {
            return set;
        }
        LinkedHashSet<String> combination1 = combination(processed + unprocessed.charAt(0), unprocessed.substring(1));
        set.addAll(combination1);
        LinkedHashSet<String> combination2 = combination(processed, unprocessed.substring(1));
        set.addAll(combination2);
        return set;
    }
