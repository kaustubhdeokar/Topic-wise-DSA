#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Node{
    public:
    int data;
    Node* next;    
};

void push(Node**head,int idata){
	Node* newnode=new Node();
	newnode->data=idata;
	newnode->next=nullptr;
	Node* temp=*head;
	if(*head==NULL)
	{
		*head=newnode;
		return;
	}
	while(temp->next!=nullptr){
		temp=temp->next;
	}
	temp->next=newnode;
	return;
}

void iterate(Node** head){
cout<<"iterating"<<endl;
    Node* temp=*head;
    while(temp!=NULL)
    {
        cout<<temp->data<<endl;
        temp=temp->next;
    }
    cout<<endl;
}

void deletefirst(Node** head){
    *head=(*head)->next;
    return;
}

void intersection(Node** head1,Node** head2){
    Node* result=new Node();
    unordered_set<int>s;
    if(*head1==nullptr || *head2==nullptr)
    return;
    Node* temp1=*head1;
    while(temp1!=nullptr){
    s.insert(temp1->data);
    temp1=temp1->next;
    }
    Node* temp2=*head2;
    while(temp2!=NULL){
        if(s.find(temp2->data)!=s.end())
        push(&result,temp2->data);
        temp2=temp2->next;  
    }
    deletefirst(&result);
    iterate(&result);
}

void reverse(Node** head){

    //current 
    //prev
    //ahead
    Node* current=*head;
    Node* ahead=nullptr;
    Node* prev=nullptr;

    while(current!=nullptr){

        ahead=current->next;
        current->next=prev;
        prev=current;
        current=ahead;
        
    }
    *head=prev;    
}

void deletelast(Node** head){
    Node* temp=*head;
    Node* tempnext;
    while(temp!=nullptr){
        tempnext=temp->next;
        if(tempnext->next==NULL)
        {
        temp->next=NULL;
        return;
        }
        temp=temp->next;
    }
}

int main(){

  Node* a = new Node();
  Node* b = new Node();
  
  push(&a, 6); 
  push(&a, 5); 
  push(&a, 4); 
  push(&a, 3); 
  push(&a, 2); 
  push(&a, 1); 

reverse(&a);
iterate(&a);
deletelast(&a);
iterate(&a);


/*
  push(&b, 8); 
  push(&b, 6); 
  push(&b, 4); 
  push(&b, 2);
  deletefirst(&a);
  deletefirst(&b);

    iterate(&a);
    iterate(&b);

intersection(&a,&b);
*/
    return 0;
}

