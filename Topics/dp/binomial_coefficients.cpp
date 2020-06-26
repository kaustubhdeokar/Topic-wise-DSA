//binomial coefficients

// here we derieve nCk=(n-1)C(k-1)+(n-1)Ck

#include<iostream>
using namespace std;

int main(){

    int c=5;
    int n=3;
    int answer[c+1][n+1];
    for(int i=0;i<c;i++)
    answer[0][i]=1;
    for(int i=0;i<n;i++)
    answer[i][0]=1;

    for(int i=1;i<=c;i++){
        for(int j=1;j<=n;j++){
            if(i==0|| j==0 || i==j)
                answer[i][j]=1;
            else
                answer[i][j]=answer[i-1][j-1]+answer[i-1][j];
        }
    }

    cout<<answer[c][n];

}