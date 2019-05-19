//permutations pallindrome.
#include<iostream>
#include<bits/stdc++.h>
#include<algorithm>
#include<cmath>
using namespace std;

class Node{
    public:
    int data;
    Node* next;
    Node(int data){
        this->data=data;
        this->next=nullptr;
    }
};

void push(Node** head,int data){

    Node* newnode=new Node(data);
    Node* temp=*head;
    if(*head==nullptr)
    {
        *head=newnode;
         return;
    }
    while(temp->next!=nullptr)
    temp=temp->next;

    temp->next=newnode;

}

void print(Node* head){
    
    Node* temp=head;
    while(temp!=nullptr)
    {
        cout<<temp->data<<" ";
        temp=temp->next;
    }
    cout<<endl;
}

int len(Node* head){
    int count=0;
    Node* temp=head;
    while(temp!=nullptr)
    {
        temp=temp->next;
        count+=1;
    }
    return count;
}


void removeduplicates(Node* head){

    Node* temp1=head;
    Node* temp2=head;

    while(temp1!=nullptr){
        temp2=temp1->next;
        while(temp2!=nullptr){
            if(temp1->data==temp2->data)
            cout<<"yes"<<temp1->data<<" "<<temp2->data<<endl;
            temp2=temp2->next;
        }
        temp1=temp1->next;
    }

}

void kthfromlast(Node* head){

    int count=len(head);
    int mid=count/2;
    int i=1;
    Node* temp=head;
    Node* prev=head;

    while(i<count)
    {
        prev=temp;
        temp=temp->next;
        i++;
    }
    prev->next=temp->next;
    print(head);

}



int main(){

    Node* head=nullptr;
    push(&head, 1); 
    push(&head, 2); 
    push(&head, 3); 
    push(&head, 4);                                     
    push(&head, 5);   
    push(&head, 6); 
    //print(head);
    //removeduplicates(head);
    kthfromlast(head);
    swap(head);
    return 0;
}
