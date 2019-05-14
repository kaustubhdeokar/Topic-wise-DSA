#include<iostream>
#include<bits/stdc++.h>
using namespace std;


class Node{
   public:
    int data;
    Node* left;
    Node* right;
    Node(int data){
        this->data=data;
        this->left=nullptr;
        this->right=nullptr;
    }
};

Node* push(Node* head,int idata){
    
    Node* newnode=new Node(idata);
    if(head==nullptr)
    head=newnode;
    else if(head->data>idata)
    head->left=push(head->left,idata);
    else
    head->right=push(head->right,idata);
    
    return head;
}

void iterate(Node* head){
    if(head==nullptr)
    return;
    else{
        cout<<head->data;
        iterate(head->left);
        iterate(head->right);
    }
}

Node* inorder(Node* head){
    int data=head->data;
    while(head->left!=nullptr)
    {
        data=head->data;
        head=head->left;
    }
    return new Node(data);
}

Node* deletelast(Node* head,int idata){

    if(head==nullptr)
    return head;

    if (head->data > idata){
        cout<<"in the left"<<endl;
        head->left=deletelast(head->left,idata);
    }
    else if(head->data < idata){
        cout<<"int the right"<<endl;
        head->right=deletelast(head->right,idata);
    }
    else{

        if(head->left==nullptr && head->right==nullptr)
        {
            cout<<"both are null";
            head=nullptr;
            return head;
        }
        else if(head->left==nullptr || head->right==nullptr){
            cout<<"one of them is null"<<endl;
            
                if(head->left){
                    head->data=head->left->data;
                    head->left=nullptr;
                }
                else{
                    head->data=head->right->data;
                    head->right=nullptr;
                    }
            return head;
        }
        else{
            Node* temp=inorder(head->right);
            cout<<"element is:"<<temp->data;
            head->data=temp->data;
            head->right=deletelast(head->right,temp->data);
            return head;
            }
    }


}


int main(){

    Node* head=nullptr;
    head=push(head,5);
    head=push(head,2);
    head=push(head,6);
    head=push(head,1);
    head=push(head,7);
    iterate(head);
    cout<<endl;
    head=deletelast(head,5);
    iterate(head);    
    return 0;
}
