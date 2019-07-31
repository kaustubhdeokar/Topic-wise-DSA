#include<iostream>
using namespace std;

int main(){
    int n=5;
    int mat[n][n];
    int s[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>mat[i][j];
        }
    }

    for(int i=0;i<n;i++){
    s[0][i]=mat[0][i];
    s[i][0]=mat[i][0];
    }
    int maxs=-1;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(mat[i][j]==0)
               s[i][j]=0;
            else
              s[i][j]=1+min(s[i-1][j],min(s[i][j-1],s[i-1][j-1]));
            if(s[i][j]>maxs)
                maxs=s[i][j];
        }
    }

    cout<<maxs;


}
