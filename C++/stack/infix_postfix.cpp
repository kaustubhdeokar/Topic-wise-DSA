#include <iostream>
#include<bits/stdc++.h>
#include<set>
using namespace std; 
  
int valueof(char i){
    if(i=='+' || i=='-')
    return 1;
    else if(i=='*' || i=='/')
    return 2;
    else if(i=='^')
    return 3;
    else if(i=='(' || i==')')
    return 0;
    else
    return -1;
}

int main() { 
  
  stack<char> mystack;
  string postfix,infix;
  cin>>infix;
  int answer;
    mystack.push('!');
  for(int i=0;i<infix.size();i++){

      char now=infix.at(i);
      if(now>='a' and now<='z')
     {
         postfix+=now;
     } 
      else if(now=='(')
      {
        mystack.push(now);
      }
      else if(now=='+' || now=='-' || now=='*' || now=='/' || now=='^')
      {
          
          if(mystack.empty()){
              mystack.push(now);
          }
          else{
              answer=valueof(now);
                cout<<"value of now:"<<now<<"is:"<<answer<<endl;
              if(answer>valueof(mystack.top()))
              {
                  mystack.push(now);
                  cout<<"pushed:"<<now<<endl;
              }
              else{
                  while(mystack.size()>0 && valueof(mystack.top())>=answer)
                  {
                      char out=mystack.top();
                      postfix+=out;
                      mystack.pop();
                  }
                  mystack.push(now);
                  cout<<"pushed"<<now<<endl;
              }
          }

      }
      else if(now==')'){
          while(mystack.top()!='('){
              char out=mystack.top();
              postfix+=out;
                mystack.pop();
          }
          mystack.pop();
      }

  }
  while(mystack.top()!='!'){
      char out=mystack.top();

      postfix+=out;
      mystack.pop();
  }
    cout<<postfix;
return 0;

} 
