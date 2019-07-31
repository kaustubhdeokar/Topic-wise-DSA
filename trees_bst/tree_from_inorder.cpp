#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Node{
    public:
    char data;
    Node* left;
    Node* right;
    Node(int idata){
        this->data=idata;
        this->right=nullptr;
        this->left=nullptr;
    }
};

Node* place(Node* head,int idata){
    
    Node* newnode=new Node(idata);
    Node* temp=head;
    if(head==nullptr)
    head=newnode;

    else if(temp->data > idata)
     temp->left=place(temp->left,idata);
    
    else 
     temp->right=place(temp->right,idata);

    return head;
}

void iterate(Node* temp){

    if(temp==nullptr)
    return;
    else{
        cout<<temp->data<<" ";
        iterate(temp->left);
        iterate(temp->right);
    }
}

void func(char arr[],int start,int end,Node* &head){
    if(start>end)
    return;
    int mid=(start+end)/2;
        head=new Node(arr[mid]);
        func(arr,start,mid-1,head->left);
        func(arr,mid+1,end,head->right);

}

int main(){

    Node* head=nullptr;
    char arr[7]={'d','b','e','a','f','c','g'};
    func(arr,0,6,head);
    iterate(head);
}
