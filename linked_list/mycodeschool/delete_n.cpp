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

   
   void deletenode(int n){
	   int i;
	   Node* temp=head;
	   if(n==1){
		   head=temp->list;
		   free(temp);
		   return;
		}
	   for(i=0;i<n-2;i++)
	   temp=temp->list;
	   
	   Node* temp2=temp->list;
	   cout<<"------------------"<<endl;
	   temp->list=temp2->list;
	   print(head);
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
    deletenode(2);
    return 0;
}
