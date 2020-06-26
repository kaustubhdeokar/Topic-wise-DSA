#include<iostream>
using namespace std;

class Node{
    public:
        int data;
        Node* list;
};

Node* head=NULL;

void print(Node* head){

    Node* temp=head;
    while(temp!=nullptr)
    {
        cout<<temp->data;
        temp=temp->list;
    }

}


void  insert(Node* x){
    Node* temp=head;
    if(head==NULL)
    head=x;
    else
    {
        while(temp->list!=NULL)
        temp=temp->list;
        temp->list=x;
    }
    print(head);
    cout<<endl;
}

    void insertbegin(Node* x){

        if(head==NULL)
        head=x;
        else
        {
            x->list=head->list;
            head=x;
        }
        print(head);
    }

int main(){
    Node* a=new Node();
    Node* b=new Node();
    Node* c=new Node();
    a->data=1;
    a->list=NULL;
    head=a;
    //cout<<head->data;
    b->data=2;
    b->list=NULL;
    insertbegin(b);
    c->data=3;
    c->list=NULL;
    insertbegin(c);
    return 0;
}
