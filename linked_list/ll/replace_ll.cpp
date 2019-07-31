#include<iostream>
#include<queue>
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

class Tree{

    public:

        void levelorder(Node* head){
            
          queue<Node*> q;
          q.push(head);
          
          while(!q.empty()){
            Node* temp=q.front();
            if(temp->left!=nullptr)
            q.push(temp->left);
            if(temp->right!=nullptr)
            q.push(temp->right);
            cout<<temp->data;
            q.pop();
          
          }

        }
};

int main(){

    Node* a=new Node(1);
    Node* b=new Node(2);
    Node* c=new Node(3);
    a->left=b;
    a->right=c;
    Tree* obj=new Tree();
    obj->levelorder(a);

}

