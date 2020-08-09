class NumArray {
public:
    vector<int>addtn;
    vector<int>numscpy;
    NumArray(vector<int>& nums) {
        int total=0;
        for(auto x:nums){
        total+=x;
        addtn.push_back(total);
        numscpy.push_back(x);
        }
        
    }
    
    int sumRange(int i, int j) {
        int answer=addtn[j];
        for(int k=0;k<i;k++)
        {   answer-=numscpy[k];
        }
         return answer;
    }
};

