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

void spirallevelorder(Node* head){

    stack<Node*>s1;
    stack<Node*>s2;
    s1.push(head);
    while(!s1.empty() || !s2.empty()){
        while(!s1.empty()){
            Node* t=s1.top();
            if(t->left)
            s2.push(t->left);
            if(t->right)
            s2.push(t->right);
            cout<<t->data<<" ";
            s1.pop();
        }
        while(!s2.empty()){
            Node* t=s2.top();
            if(t->right)
            s1.push(t->right);
            if(t->left)
            s1.push(t->left);
            cout<<t->data<<" ";
            s2.pop();
        }
    }
}

int main(){
    int arr[]={10,16,5,-1,-3,6,11};
    Node obj(); 
    Node* head;
    int n=sizeof(arr)/sizeof(arr[0]);
    head=maketree(head,arr,0,n);    
    spirallevelorder(head);
    return 0;
}