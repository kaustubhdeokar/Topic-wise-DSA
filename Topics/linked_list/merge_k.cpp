ListNode* insertNode(ListNode* head,int data){
        ListNode*  newnode=new ListNode(data);
        if(head==NULL)
            head=newnode;
        else{
            head->next=insertNode(head->next,data);
        }
        return head;
    }
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        ListNode* temp;
        vector<int>v;
        for(int i=0;i<lists.size();i++){
        temp=lists[i];
            while(temp!=NULL){
                v.push_back(temp->val);
                temp=temp->next;
            }
        }
        sort(v.begin(),v.begin()+v.size());
        ListNode* temp2=NULL;
        for(auto x:v){
            temp2=insertNode(temp2,x);
        }
        return temp2;
    }
