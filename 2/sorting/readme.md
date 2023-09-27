### Selection Sort 
    ```
    O(n2)
    --------------------------
    for index i-> (0, n-1).
        selecting the minimum and swapping with ith index.
        i+=1
    ```
### Bubble sort
    ```
    O(n2)
    --------------------------
    for i -> (0, n-1)
        for j -> (i, n-1)
            swapping any two index when value[lower_index] > value[higher_index]
    ```

### Insertion sort
    ```
    O(n2)
    --------------------------
    for i -> (1, n-1)
        comparing with j->(0,i) -> to find the correct spot and placing in the correct index ranging(0,i].
    ```

### Merge sort
    ```
    O(nlogn)
    --------------------------
    divide the array into half each time. create copies of those arrays & merge them.
    while merging manipulate the original array, as anyways copies have the info.
    

    