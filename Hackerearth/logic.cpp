#include<iostream>
#include<time.h>
#include<bits/stdc++.h>
#include<typeinfo>
using namespace std;

class Node{
    public:
    int data;
    Node* left;
    Node* right;
    Node(int idata){
        this->data=idata;
        this->left=nullptr;
        this->right=nullptr;
    }
};

Node* push(Node** head,int idata){
    Node* newnode=new Node(idata);
    
    if(*head==nullptr)
    *head=newnode;

    else if((*head)->data>idata)
    (*head)->left=push(head,idata);

    else
    (*head)->right=push(head,idata);

    return *head;
}

void iterate(Node* head){
    if(head==nullptr)
    return;
    iterate(head->left);
    cout<<head->data;
    iterate(head->right);

}
int main(){

    Node* head=nullptr;

    int n,temp;
    cin>>n;
    while(n--){
        cin>>temp;
        push(&head,temp);
    }

    iterate(head);
}

