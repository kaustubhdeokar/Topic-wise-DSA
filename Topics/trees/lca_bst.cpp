#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Node{
    public:    
    int data;
    Node* left;
    Node* right;
    Node(){}
    Node(int x){
        data=x;
        left=NULL;
        right=NULL;
    }
};


void traverse(Node* head){
    if(head==NULL)
    return;
    else{
        cout<<head->data<<" ";
        traverse(head->left);
        traverse(head->right);
    }
}

Node* insertNode(Node* head,int idata){

    Node* newnode=new Node(idata);

    if(head==NULL)
        head=newnode;
    else if(head->data>idata)
        head->left=insertNode(head->left,idata);
    else
        head->right=insertNode(head->right,idata);
    
    return head;
}

int lca(Node* head,int l,int r){
    if(head->data>max(l,r)){
        lca(head->left,l,r);
    }
    else if(head->data<min(l,r)){
        lca(head->right,l,r);
    }
    else{
    cout<<head->data<<" ";
    }
}

int main(){
    int arr[]={10,16,5,-1,-3,6,11};
    Node* head=NULL;
    int n=sizeof(arr)/sizeof(arr[0]);
    for(int i=0;i<n;i++){
        head=insertNode(head,arr[i]);
    }
    int ans=lca(head,-1,-3);
    cout<<ans;
    return 0;
}