#include<iostream>
using namespace std;
class node{

	public:
		int data;
		node* next=NULL;
		node* head=NULL;
		node* tail=NULL;
		
	void createnode(int data){
		node* temp=new node();
		temp->data=data;
		temp->next=NULL;
		if(head==NULL)
		{
		head=temp;
		tail=temp;
		}
		else
		{
			tail->next=temp;
			tail=temp;
		}
	}
	void iterate(node* head){
		
		while(head!=NULL)
		{
			cout<<head->data;
			head=head->next;
		}
	}
	
	void print(node* head){
		while(head!=nullptr)
		{
			cout<<head->data;
			head=head->next;
		}
	}
};	

int main(){
	node* obj1=new node();
	node* obj2,obj3;
	int i=0,temp;
	for(i=0;i<5;i++)
	{
		cin>>temp;
		obj1->createnode(temp);
	}
	obj1->print(obj1->head);
	return 0;
}
