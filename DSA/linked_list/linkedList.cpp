#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Node{
 public:
    int data;
    Node* next;
};

Node* head;

void insert(int idata){

    Node* last=head;
    Node* temp=new Node();
    temp->data=idata;
    temp->next=NULL;
    if(head==NULL)
    {
        head=temp;
        return;
    }
    else{
        while(last->next!=NULL)
            last=last->next;
        last->next=temp;
        return;
    }

}

void iterate(Node* head){

cout<<"iterating ";
    while(head!=nullptr)
    {
        cout<<head->data<<" ";
        head=head->next;
    }
cout<<"done"<<endl;
}

void deleted(int pos){
    int start=0;
    Node* temp=head,*prev;
    
    if(pos==0)
    {
      head=head->next;
        return ;
    }
    while(temp->next!=nullptr && pos!=start)
    {
        prev=temp;
        temp=temp->next;
        start+=1;
    }

    if(temp==NULL)
    cout<<"out of stock"<<endl;
    else
    {
        prev->next=temp->next;
        return;
    }
    

}

bool loop(){

//Floyd Cycle Algorithm
    int count=1;
    Node* slow=head;
    Node* fast=head;
    while(slow && fast && fast->next){
        slow=slow->next;
        fast=fast->next->next;
        if(slow==fast){
            cout<<"loop";
            slow=slow->next;
            while(slow!=fast){
                slow=slow->next;
                count+=1;
            }
            cout<<"count is:"<<count<<endl;
            return 1;
        }
    }
    return 0;
}

int main(){

    head=NULL;
    insert(1); 
    insert(2); 
    insert(3); 
    insert(4);
    insert(5); 
  
    head->next->next->next->next->next = head; 
    bool t=loop();
    cout<<t;
    return 0;
}