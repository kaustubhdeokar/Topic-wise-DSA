#include<iostream>
using namespace std;
class node{

	public:
		int data;
		node* next=nullptr;
		
	node(int data){
		this->data=data;
		this->next=nullptr;
	}		
	node(){
		this->data=0;
		this->next=nullptr;
	}
};

class nodelist{
	public:
		node* head=nullptr;
		node* tail=nullptr;
		void createlist(int data){
			node* temp=new node(data);
			if(head==nullptr){
				head=temp;
				tail=temp;
			}
			else
			{
				tail->next=temp;
				tail=tail->next;
			}
		}
	
	void iterate(node* head){
		while(head!=nullptr)
		{
			cout<<head->data;
			head=head->next;
		}
	}
	
	void reverse(node* head){
		node* nextnode=head->next;
		node* attach=new node();
		while(head->next!=nullptr)
		{
			
			
			
			
};	

int main(){
	nodelist* obj1=new nodelist();
	
	int i=0,temp;
	for(i=0;i<5;i++)
	{
		cin>>temp;
		obj1->createlist(temp);
	}
	obj1->iterate(obj1->head);
	return 0;
}
