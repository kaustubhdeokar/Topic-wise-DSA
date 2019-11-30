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

void postorder(Node* root){

    if(root==NULL)
    return;
    stack<Node*>s1;
    stack<Node*>s2;
    s1.push(root);
    while(!s1.empty()){
        Node* t=s1.top();
        s1.pop();
        if(t->left)
        s1.push(t->left);
        if(t->right)
        s1.push(t->right);
        s2.push(t);
    }
    while(!s2.empty()){
        cout<<s2.top()->data<<" ";
        s2.pop();
    }

}

int main(){
    Node * root = new Node(1); 
    root->left = new Node(2); 
    root->right = new Node(3); 
    root->left->left = new Node(4); 
    root->left->right = new Node(5); 
    root->right->left = new Node(6); 
    root->right->right = new Node(7);
    postorder(root); 

    return 0;
}