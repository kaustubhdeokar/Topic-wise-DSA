#include<iostream>
using namespace std;

int knapsack(int value[],int weight[],int Weight,int n){

    if(n==0||Weight==0)
    return 0;

    if(weight[n-1]>Weight)
    return knapsack(value,weight,Weight,n-1);

    else
        return max(value[n-1]+knapsack(value,weight,Weight-weight[n-1],n-1),
            knapsack(value,weight,Weight,n-1));

}

int main(){

    int value[]={60,100,120};
    int weight[]={10,20,30};
    int Weight=50;

    int n=3;

    int ans=knapsack(value,weight,Weight,n);

    cout<<ans<<endl;
}