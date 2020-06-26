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

Node* maketree(Node* head,int arr[],int i,int n){
    if(i<n){
        head=new Node(arr[i]);
        head->left=maketree(head->left,arr,i*2+1,n);
        head->right=maketree(head->right,arr,i*2+2,n);
    }
    return head;
}

void traverse(Node* head){
    if(head==NULL)
    return;
    else{
        cout<<head->data<<" ";
        traverse(head->left);
        traverse(head->right);
    }
}

void reverselevelorder(Node* head){

    queue<Node*>q;
    stack<Node*>st;
    q.push(head);
    while(!q.empty()){
        Node* t=q.front();
        q.pop();
        if(t->right)
        q.push(t->right);
        if(t->left)
        q.push(t->left);
        st.push(t);
    }
    while(!st.empty()){
        cout<<st.top()->data<<" ";
        st.pop();
    }
}

int main(){
    int arr[]={10,16,5,-1,-3,6,11};
    Node obj(); 
    Node* head;
    int n=sizeof(arr)/sizeof(arr[0]);
    head=maketree(head,arr,0,n);    
    reverselevelorder(head);
    return 0;
}