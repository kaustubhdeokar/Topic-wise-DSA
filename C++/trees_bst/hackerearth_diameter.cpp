#include<iostream>
#include<string.h>
#include<bits/stdc++.h>
#include<conio.h>
using namespace std;


class Node{
  public:
    int data;
    Node* left;
    Node* right;

    Node(int idata){
        data=idata;
        left=NULL;
        right=NULL;
    }
}*head=NULL,* tail=NULL;


void iterate(Node* head){
    if(head==NULL)
    return;
    else
    {
        iterate(head->left);
        cout<<head->data;
        iterate(head->right);
    }
}

void insert(Node* head,string s,int data,int len){
    Node* temp=new Node(data);
    int i;
    string corr="LR";
    for(i=0;i<len;i++)
    {
        if(strcmp(s[i],corr[0]))
        head=head->left;
        if(s[i]==(char)"R")
        head=head->right;
    }
    head=temp;
}

int main(){

    int head_val,temp,n,i;
    cin>>n>>head_val;
    char s;
    for(i=0;i<n-1;i++){
        gets(s);
        cin>>temp;
        insert(head,s,temp,s.size());
    }
    iterate(head);
}