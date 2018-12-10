
def maxcount(s,i):
    count_i=s.count(i)
    print('i is:',i,count_i)
    start_index=s.index(i)
    total_count=0
    maxtemp=0
    while(total_count<count_i):
        start_index=s.index(i)
        
        temp=0
        while s[start_index]==i:
            temp+=1
            start_index+=1
            if(start_index)==len(s):
                break
        if(temp>maxtemp):
            maxtemp=temp
        total_count+=temp
        s=s[start_index:]
    return maxtemp

if __name__=="__main__":
    s=input()
    set_s=set(s)
    array=[]
    max_count=0
    result=0
    if(len(s)==len(set_s)):
        print(1)
    else:
        for i in set_s:
            if s.count(i)>1:
                result=maxcount(s,i)
            if(result>max_count):
                max_count=result
        print(max_count)
