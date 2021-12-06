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


int main(){

    Node* head=nullptr;
    push(&head, 20); 
    push(&head, 11); 
    push(&head, 13); 
    push(&head, 11);                                     
    push(&head, 13);   
    push(&head, 11); 
    print(head);
    removeduplicates(head);
    return 0;
}
