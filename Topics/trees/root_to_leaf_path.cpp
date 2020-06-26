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

bool roottoleafsum(Node* root,int sum,vector<int>&answer){
    if(root==NULL){
        return false;
    }

    if(root->left==NULL && root->right==NULL){
        if(root->data==sum){
            answer.push_back(root->data);
            return true;
        }
        else 
            return false;
    }
    
    if(roottoleafsum(root->left,sum-(root->data),answer))
    {
        answer.push_back(root->data);
        return true;
    }
    if(roottoleafsum(root->right,sum-(root->data),answer))
    {
        answer.push_back(root->data);
        return true;
    }
    return false;   
}

int main(){
    int arr[]={10,16,5,-1,-3,6,11};
    Node obj(); 
    Node* head;
    int n=sizeof(arr)/sizeof(arr[0]);
    head=maketree(head,arr,0,n);    
    //traverse(head);
    vector<int>answer;
    cout<<roottoleafsum(head,26,answer)<<endl;
    for(auto x:answer)
    cout<<x<<" ";
    return 0;
}