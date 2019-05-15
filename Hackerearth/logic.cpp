#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Node{
    public:
    int data;
    Node* left;
    Node* right;

    Node(int data){
        this->data=data;
        this->left=left;
        this->right=right;
    }
};
// 5 2 7 3 9
Node* push(Node* head,Node* newnode){
    if(head==nullptr)
    head=newnode;

    else if (head->data> newnode->data)
    head->left=push(head->left,newnode);
    
    else 

    head->right=push(head->right,newnode);

    return head;

}

void iterate(Node* head){
    if(head==nullptr)
    return;
    else{
        iterate(head->left);
        cout<<head->data;
        iterate(head->right);
    }
}

int levelorder(Node* head){
    queue<Node*>q;
    q.push(head);
    Node* temp;
    while(!q.empty()){
        temp=q.front();
        if(temp->left!=nullptr)
        q.push(temp->left);
        if(temp->right!=nullptr)
        q.push(temp->right);
        cout<<temp->data;
        q.pop();
    }
    int data=temp->data;
    return data;
}

void deletenode(Node* head,Node* lastnode){

    queue<Node*>q;
    q.push(head);
    Node* temp;
    cout<<"enter the node to delete";
    int data;
    cin>>data;
    while(!q.empty()){
        temp=q.front();
        if(temp->data==data){
            temp->data=lastnode->data;
        }
        if(temp==lastnode)
        {
            temp=nullptr;
            delete(lastnode);
        }
        if(temp->left)
        q.push(temp->left);
        if(temp->right)
        q.push(temp->right);
        q.pop();
    }   

}

int main(){
    Node* head=nullptr;
    int data;
    for(int i=0;i<5;i++)
    {
        cin>>data;
        Node* newnode=new Node(data);
        head=push(head,newnode);
    }
    data=levelorder(head);
    cout<<"data"<<data<<endl;
    Node* lastnode=new Node(data);
    deletenode(head,lastnode);
    data=levelorder(head);
    return 0;
}



