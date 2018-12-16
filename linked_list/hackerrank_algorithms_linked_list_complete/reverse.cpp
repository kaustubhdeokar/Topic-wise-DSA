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
    ~Node(){
		cout<<"here";
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

void reverse(Node* head){
    Node* current;
        Node* prev=NULL;
        Node* next;
        
    Node *temp=head;
    if(head==NULL)
    return;
    else{
        current=temp;
        while(current!=NULL)
        {
            next=current->list;
            current->list=prev;
            prev=current;
            current=next;

        }
    
    }
    head=prev;
    print(head);
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


   
int main(){
    
    int n;
    cin>>n; 
    int i;
    for(i=0;i<n;i++)
    {
        int temp;
        cin>>temp;
        Node* tempnode=new Node(temp);
        insert(tempnode);
        //cout<<endl;
    }
    
    return 0;
}
