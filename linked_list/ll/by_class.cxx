#include<iostream>
using namespace std;

class node{
	
	public:
		int data;
		node* next,*head,*tail;
	
		node(){
			head=NULL;
			tail=NULL;
		}
	void createnode(int data){
		node* temp=new node();
		temp->data=data;
		temp->next=NULL;
		if(head==NULL){
			head=temp;
			tail=temp;
			temp=NULL;
		}
		else{
			tail->next=temp;
			tail=temp;
		}
		
	}
	void display(){
		node* temp=new node;
		temp=head;
		while(temp!=NULL)
		{
			cout<<temp->data;
			temp=temp->next;
		}
	}
	
	void reverse(node* head){
		
		while(head!=tail){
			cout<<head->data;
			head=head->next;
	}
	cout<<head->data;
	}
};

int main(){
	int i,temp;
	node* obj=new node();
	for(i=0;i<3;i++)
	{
		cin>>temp;
		obj->createnode(temp);
	}
	obj->reverse(obj->head);
	return 0;
}
