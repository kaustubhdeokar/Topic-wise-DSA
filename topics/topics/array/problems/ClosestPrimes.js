var closestPrimes = function(left, right) {
    arr = []
    for(var i=0;i<=right;i++){
        arr.push(true);
    }
    arr[1] = false;
    for(var i=2;i<=right;i++){
        if(arr[i]==false) continue;
        for(var j=i*i;j<=right;j+=i){
            arr[j] = false;
        }
    }

    return findCloseInRange(arr, left, right);
};

function findCloseInRange(arr, left, right){
    let minDiff = right+1;
    let leftNum = -1;
    let rightNum = -1;
    let limits = [leftNum, rightNum];

    for(var i=left;i<=right;i++){
        if(arr[i]==true){
            if(leftNum!=-1 && rightNum!=-1){
                leftNum = rightNum;
                rightNum = i;
            }
            else if(leftNum==-1) leftNum = i;
            else if(rightNum==-1) rightNum = i;

            if(leftNum!=-1 && rightNum!=-1 && ((rightNum-leftNum)< minDiff)){
                limits = [leftNum, rightNum];
                minDiff = rightNum - leftNum;
            }


        }
    }
    return limits
}


console.log(closestPrimes(1,2));
