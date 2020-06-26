#include<iostream>
#include<bits/stdc++.h>
using namespace std;


class Node{
    public:
    int data;
    Node* right,*left;
    Node(int data){
        this->data=data;
        this->left=nullptr;
        this->right=nullptr;
    }
};

Node* push(Node* head,int idata){

    Node* newnode=new  Node(idata);
    if(head==nullptr)
    head=newnode;

    else if(head->data>idata)
    head->left=push(head->left,idata);

    else 
    head->right=push(head->right,idata);

    return head;
}

void print(Node* head){
    if(head==nullptr)
    return;
    else{
        print(head->left);
        cout<<head->data<<" ";
        print(head->right);
    }
}


void binarysearch(Node* &head,int arr[],int start,int end){

    if(start>end){
    return;
    }

    int mid=(start+end)/2;
    head=new Node(arr[mid]);

    binarysearch(head->left,arr,start,mid-1);
    binarysearch(head->right,arr,mid+1,end);

}

void add(int arr[],int n){

    Node* head=nullptr;
    sort(arr,arr+n);

    binarysearch(head,arr,0,n-1);
    print(head);
}

int main(){

    Node* head=nullptr;
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++)
        cin>>arr[i];
    add(arr,n);
    return 0;
}

