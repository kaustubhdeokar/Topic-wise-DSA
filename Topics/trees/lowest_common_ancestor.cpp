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

Node* maketree(Node* head,int arr[],int i,int high){
    if(i<high){
        head=new Node(arr[i]);
        head->left=maketree(head->left,arr,i*2+1,high);
        head->right=maketree(head->right,arr,2*i+2,high);
    }
    return head;
}

bool pathfornode(Node* head,int nodevalue,vector<int>&q){
    if(!head)
        return false;
    q.push_back(head->data);
    if(head->data==nodevalue)
        return true;
    if(pathfornode(head->left,nodevalue,q)||pathfornode(head->right,nodevalue,q))
        return true;
    q.pop_back();
    return false;
}

int main(){
    int arr[]={10,16,5,-1,-3,6,11};
    Node* head=NULL;
    int n=sizeof(arr)/sizeof(arr[0]);
    head=maketree(head,arr,0,n);
    vector<int>q;
    vector<int>q2;
    pathfornode(head,-1,q);
    pathfornode(head,-3,q2);
    for(auto x:q){
        cout<<x<<" ";
    }
    return 0;
}