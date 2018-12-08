#include<iostream>
using namespace std;

struct node{
    int data;
    struct node* next;
};

struct node* newnode(int idata){
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=idata;
    temp->next=NULL;
    return temp->next;
}

void print(struct node* head){
    while(head!=NULL)
    {
        cout<<head->data;
        head=head->next;
    }
}

int main(){
    int i;
    struct node* head;
    struct node* p=head;
    int arr[5]={1,2,3,4,5};
    for(i=0;i<5;i++)
    {
        head->data=arr[i];
        head=head->next;
    }
    while(p!=NULL)
    {
        cout<<p->data;
        p=p->next;
    }
    return 0;
}