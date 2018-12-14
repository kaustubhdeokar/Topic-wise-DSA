#include<iostream>
using namespace std;

class node{

    public:

    int data;
    node* next;

    node(int data){
        this->data=data;
        this->next=nullptr;
    }
    
};

class nodelist{
    
    public:
    node* head,tail;

    nodelist(){
        node* head=nullptr;
        node* tail=nullptr;
        }
    void createlist(int data){
        node* temp=new node(data);
    if(head==nullptr){
        head->next=temp;
        tail=temp;
    }
    else{
        tail->next=temp;
        tail=tail->next;
    }

    }
};

int main(){
    return 0;
}