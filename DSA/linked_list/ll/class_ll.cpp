#include <iostream>
using namespace std;

class Node{
      
    public: 
     char letter;  
       Node *next, *prev; 
};

class SLL{
      
 private:
         Node *head, *tail;
 
 public:
        
        SLL(){               
        head = NULL;
        tail = NULL;
        }
        void printAll();
        void insertToFront(char item);
        void deleteFront();
        void insertToBack(char item);
        void deleteBack();   
        void deleteKthNodeFromBack(int k);
        void reverse();        
        void deleteDuplicate();
        void shiftKNodes(int k);
        void insertNewNode(char item);
};


     void SLL::printAll(){
     
     Node *p;
     p = head;
     while(p->next!=NULL){
     
     cout << p << " ";
     p = p->next;
     } 
     
} 

     void SLL::insertNewNode(char item){
          Node* temp;
          
          temp = new Node;
          temp->letter = item;
          temp->next = head;
          head = temp;
          
          
          }

int main(){
    
    SLL list;
    list.insertNewNode('C');
    list.insertNewNode('B');
    list.insertNewNode('A');
    
    
    
    
    system("pause");
    
    return 0;
    
    
}