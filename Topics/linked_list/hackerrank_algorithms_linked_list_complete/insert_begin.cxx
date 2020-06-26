#include<iostream>
using namespace std;

class Node{
    public:
        int data;
        Node* list;
    Node(int data){
        this->data=data;
        this->list=nullptr;
    }
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
            x->list=head;
            head=x;
        }
        print(head);
        cout<<endl;
    }

int main(){
    
    int n;
    cin>>n; 
    int i;
    for(i=0;i<n;i++)
    {
        int temp;
        cin>>temp;
        Node* tempnode=new Node(temp);
        insertbegin(tempnode);
    }
    return 0;
}
