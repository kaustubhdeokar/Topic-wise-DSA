#include<iostream>
#include<queue>
using namespace std;

struct node{
    int data;
    struct node* left;
    struct node* right;
};

struct node* newnode(int idata){
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=idata;
    temp->left=NULL;
    temp->right=NULL;
    return temp;
}

void printtree(struct node* a){
    if(a==NULL)
    return;
    else
    printtree(a->left);
    cout<<a->data<<" ";
    printtree(a->right);
}

void levelorder(struct node* a){
    queue<struct node*> q;
    q.push(a);
    int len=0;
    while(!(q.empty()))
    {
        struct node* temp=q.front();
        q.pop();
        cout<<temp->data<<"  ";
        if(temp->left!=NULL)
        q.push(temp->left);
        if(temp->right!=NULL)
        q.push(temp->right);
        if(len<q.size())
        len=q.size();
        
    }
    cout<<endl<<"the length is:"<<len<<endl;
}

int main(){
    struct node* a=newnode(10);
    struct node* b=newnode(5);
    a->left=b;
    struct node* c=newnode(12);
    a->right=c;
    b->left=newnode(1);
    b->right=newnode(4);
    c->left=newnode(15);
    c->right=newnode(20);
    printtree(a);
    cout<<endl;
    levelorder(a);
    return 0;
}