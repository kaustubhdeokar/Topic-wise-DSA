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

int length(Node* head){
    int count=0;
    while(head!=nullptr){
        head=head->list;
        count+=1;
    }
    return count;
}

    void insertn(Node* x,int pos){
        
        Node* temp=head;
        int i;
			
			if(pos==1)
			{
			x->list=head;
			head=x;
			print(head);
			}
			else
			{
				for(i=0;i<pos-2;i++)
				temp=temp->list;
				x->list=temp->list;
				temp->list=x;
				print(head);
			}
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
     for(i=0;i<n;i++)
    {
        int temp;
        cin>>temp;
        int pos;
        cin>>pos;
        Node* tempnode=new Node(temp);
        insertn(tempnode,pos);
        //print(head);
    }
    return 0;
}
