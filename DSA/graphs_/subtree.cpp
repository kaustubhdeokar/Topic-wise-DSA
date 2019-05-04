#include<iostream>
#include<queue>
using namespace std;

struct node{
    int data;
    struct node* left;
    struct node* right;
};

struct node* newnode(int idata){
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=idata;
    temp->left=NULL;
    temp->right=NULL;
    return temp;
}

void printtree(struct node* a){
    if(a==NULL)
    return;
    else
    printtree(a->left);
    cout<<a->data<<" ";
    printtree(a->right);
}


int main(){
    int n,i;
    cin>>n;
    for(i=0;i<n;i++)
    
    return 0;
}