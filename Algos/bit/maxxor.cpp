#include<bits/stdc++.h>
using namespace std;
#define bits 31

int maxxor(int set[],int n){

    int index=0;
    for(int i=bits;i>=0;i--){
      int maxele=INT_MIN,maxind=index;
      for(int j=index;j<n;j++)
	  {
       	if((set[j]&(1<<i))!=0 && set[j]>maxele){
			maxele=set[j];
			maxind=j;
		}
	  }
      if(maxele==INT_MIN)
      continue;
      swap(set[index],set[maxind]);
      maxind=index;

      for(int j=0;j<n;j++)
      {
        if(j!=maxind && (set[j]&(1<<i))!=0)
        set[j]=set[j]^set[maxind];
      }
    index+=1;
    }

    int res=0;
    for(int i=0;i<n;i++)
    res^=set[i];
    return res;
}


int main()
{
  int set[]={2,4,5};
  int n=3;
  cout<<maxxor(set,n);
  return 0;
}


