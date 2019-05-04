#include<bits/stdc++.h>
using namespace std;

void swap(char *x,char *y){
    char temp;
    temp=*x;
    *x=*y;
    *y=temp;
}

void permute(char *a,int l,int r){
    int i;
    if(l==r)
    {
        cout<<a<<" ";    

    }
    else{
        for(i=l;i<=r;i++){
            swap(a+i,a+l);
            permute(a,l+1,r);
            swap(a+l,a+i);
        }
    }

}

int main(){
    char a[]="1234";
    int n=strlen(a);
    permute(a,0,n-1);

    return 0;
}

