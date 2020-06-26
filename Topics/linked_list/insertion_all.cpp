#include<iostream>
using namespace std;

class Node{
    public:
    int data;
    Node* next;
}*head;

void insertlast(int idata){
    Node* temp=new Node();
    temp->data=idata;
    temp->next=nullptr;
    Node* last=head;
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

void insertfirst(int data){
    Node* temp=new Node();
    temp->data=data;
    temp->next=head;
    head=temp;
    return;
}

void insertn(int idata,int pos){
    Node* temp=new Node();
    temp->data=idata;
    temp->next=NULL;
    Node* nextptr=head;
    Node* prevptr=head;
    int temppos=0;
    while(nextptr->next!=nullptr){
        if(temppos==pos)
        break;
        prevptr=nextptr;
        nextptr=nextptr->next;
        temppos+=1;
        
    }
    temp->next=nextptr;
    prevptr->next=temp;
    return;

}

void iterate(Node* head)
{
    cout<<"iteration"<<endl;
    while(head!=nullptr)
    {
        cout<<head->data;
        head=head->next;
    }
    cout<<endl;
}

int main(){

    head=nullptr;
    insertlast(2);
    insertlast(1);
    insertlast(3);
    iterate(head);
    insertfirst(4);
    insertfirst(5);
    iterate(head);
    insertn(6,4);
    iterate(head);
    return 0;
}
