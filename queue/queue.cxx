#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <stack>
#include <queue>
using namespace std;

void showstack(stack<int>s){
    cout<<"IN showstack"<<endl;
    while(!s.empty())
    {
    cout<<s.top()<<" ";
    s.pop();
    }
    cout<<endl;
}

class MyQueue {
  
    public:
        stack<int> a,b;   
        void push(int x) {
            a.push(x);
    //        showstack(a);
        }

        void pop() {
            a.pop();
            cout<<"stack a:"<<endl;
            showstack(a);
        }

        int front() {
            while(!a.empty()){
                b.push(a.top());
                a.pop();
            }
            int r=b.top();
            while(!b.empty()){
                a.push(b.top());
                b.pop();
            }
            return r;
        }
};

int main() {
    MyQueue q1;
    int q, type, x;
    cin >> q;
    
    for(int i = 0; i < q; i++) {
        cin >> type;
        if(type == 1) {
            cin >> x;
            q1.push(x);
        }
        else if(type == 2) {
            q1.pop();
        }
        else cout << q1.front() << endl;
    }
    return 0;
}

