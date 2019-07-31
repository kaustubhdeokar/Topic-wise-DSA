#include<bits/stdc++.h>
using namespace std;
#define min(x,y) ((x<y)?x:y);

void formation(int segtree[],int arr[],int low,int high,int pos){
	
	if(low==high)
	segtree[pos]=arr[low];
	else{
		int mid=(low+high)/2;
		formation(segtree,arr,low,mid,2*pos+1);
		formation(segtree,arr,mid+1,high,2*pos+2);
		segtree[pos]=min(segtree[2*pos+1],segtree[2*pos+2]);
	}
}

int rangeminquery(int segtree[],int qlow,int qhigh,int low,int high,int rootpos){
	
	if(qlow<=low && qhigh>=high)
	return segtree[rootpos];
	else if(qlow>high || qhigh<low)
	return 10000;
	else{
		int mid=(low+high)/2;
		return min(rangeminquery(segtree,qlow,qhigh,low,mid,rootpos*2+1),rangeminquery(segtree,qlow,qhigh,mid+1,high,rootpos*2+2));
		}
}
int main()
{
 
  int arrlen,segtreelen;
  cin>>arrlen;
  int *arr=new int[100];
  for(int i=0;i<arrlen;i++)
  cin>>arr[i];
  int *segtree;
  if((arrlen&(arrlen-1))==0)
    segtreelen=2*arrlen-1;
  else
    {
    segtreelen=ceil(log2(arrlen));
    segtreelen=pow(2,segtreelen);
    segtreelen=segtreelen*2-1;
    }
    segtree=new int[1000];
	formation(segtree,arr,0,arrlen-1,0);
	cout<<endl;
	cout<<"enter range query";
	cin>>qlow>>qhigh;
	cout<<rangeminquery(segtree,qlow,qhigh,0,arrlen-1,0);
}


