#include<iostream>
#include<queue>
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

void levelorder(Node* head,int n){
    queue<Node*>q;
    q.push(head);
    int con=1;
    while(!q.empty()){
        Node* temp=q.front();
        if(temp->left!=NULL)
        q.push(temp->left);
        if(temp->right!=NULL)
        q.push(temp->right);
        if(con==2)
        {
        cout<<temp->data;
        break;
        }
        if(temp->data==n)
        {
        con=2;
        }
        q.pop();
    }
}

int main(){
    
    int t;
    cin>>t;
    int n,i,temp;
    while(t--){
        cin>>n;
        for(i=0;i<n;i++){
            cin>>temp;
            head=insertnewnode(head,temp);
        }
    }

    //traverse(head);
    cout<<"enter the node";
    cin>>n;
    levelorder(head,n);
	return 0;
	}
