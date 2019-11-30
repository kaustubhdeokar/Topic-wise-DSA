#include<iostream>
using namespace std;

int knapsack(int value[],int weight[],int W,int n){

    int K[n+1][W+1];
for(int i=0;i<=n;i++){
    for(int j=0;j<=W;j++){
    
        if(i==0||j==0)
            K[i][j]=0;

        else if(weight[i-1]<=j)
            K[i][j]=max(K[i-1][j],value[i-1]+K[i-1][j-weight[i-1]]);
        
        else
            K[i][j]=K[i-1][j];
                
    }

    }
    return K[n][W];
}


int main(){

    int value[]={60,100,120};
    int weight[]={10,20,30};
    int Weight=50;

    int n=3;

    cout<< knapsack(value,weight,Weight,n);


}