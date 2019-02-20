#include<iostream>
using namespace std;

class Node{
	public:
        int data;
        Node* left;
        Node* right;
	    Node(int idata){
		data=idata;
        left=NULL;
        right=NULL;
    }
}*head=NULL;
	
Node* insertnewnode(Node* head,int idata){
	Node* temp=new Node(idata);
	if(head==NULL){
		head=temp;
	}
	else if(head->data> idata)
	head->left=insertnewnode(head->left,idata);
    else
    head->right=insertnewnode(head->right,idata);

    return head;
}

void traverse(Node* head){
    if(head==NULL)
    return;
    else{
        traverse(head->left);
        cout<<head->data;
        traverse(head->right);
    }
}    

int main(){
    
    int t;
    cin>>t;
    while(t--){
        int n,i,temp;
        cin>>n;
        for(i=0;i<n;i++){
            cin>>temp;
            head=insertnewnode(head,temp);
        }
    }

    traverse(head);

	return 0;
	}
