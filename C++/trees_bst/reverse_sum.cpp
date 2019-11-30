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

void print(int *sum,Node* head){
    if(head==nullptr)
    return;
    else{
        print(sum,head->right);
        *sum+=head->data;
        head->data=*sum-head->data;
        print(sum,head->left);

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

void iterate(Node* head){
    if(head==nullptr)
    return;
    iterate(head->left);
    cout<<head->data<<" ";
    iterate(head->right);
}

void add(int arr[],int n){

    Node* head=nullptr;
    sort(arr,arr+n);

    binarysearch(head,arr,0,n-1);
    int sum=0;
    print(&sum,head);

    iterate(head);

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

