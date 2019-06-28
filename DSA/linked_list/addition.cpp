#include <bits/stdc++.h> 
using namespace std; 
#define ull unsigned long long int
#define vu vector<ull>

class Node{
    public:
    int data;
    Node* next;
    Node(int idata){
        data=idata;
        next=NULL;
    }
};

Node* insert(Node* head,int data){
    Node* newnode=new Node(data);
    if(head==NULL)
    {    
        head=newnode;
        return head;
    }  
    Node* temp=head;
    while(temp->next!=NULL)
    temp=temp->next;
    temp->next=newnode;
    return head;
}

string print(Node* head1,Node* head2){
    string answer;
    int temp=0,carry=0;
    while(head1!=NULL && head2!=NULL)
    {
        temp=carry+head1->data+head2->data;
        if(temp>9)
        {
            answer+=to_string(temp%10);
            carry=1;
        }
        else
        {
        answer+=to_string(temp);
        carry=0;
        }
        head1=head1->next;
        head2=head2->next;
    }

    while(head1!=NULL){
        
        temp=carry+head1->data;
        if(temp>9){
            answer+=to_string(temp%10);
            carry=1;
            }
        else{
            answer+=to_string(temp);
            carry=0;
        }
        head1=head1->next;
    }
    while(head2!=NULL){
        
        temp=carry+head2->data;
        if(temp>9){
            answer+=to_string(temp%10);
            carry=1;
            }
        else{
            answer+=to_string(temp);
            carry=0;
        }
        head2=head2->next;
    }
    if(head1==NULL && head2==NULL && carry==1)
        answer+=to_string(1);

    return answer;

}


void print(Node* head){
    while(head!=NULL){
        cout<<head->data;
        head=head->next;
    }
}

Node* reversed(Node* head1){
    
     Node* prev=NULL;
    Node* curr=head1;
    Node* ahead=NULL;

    while(curr!=NULL){
        ahead=curr->next;
        curr->next=prev;
        prev=curr;
        curr=ahead;
    }
    head1=prev;
    return head1;
}



int main(){

    Node* head1=NULL;
    head1=insert(head1,2);
    head1=insert(head1,4);
    head1=insert(head1,3);
    Node* head2=NULL;
    head2=insert(head2,0);

    string answer=print(head1,head2);
    cout<<answer;
}

