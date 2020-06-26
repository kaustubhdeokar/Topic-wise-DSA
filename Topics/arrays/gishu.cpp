#include <iostream>
#include<bits/stdc++.h>
#include<set>
using namespace std;

int main()
{

    set<int>s;
    int temp,n;
    cin>>n;
    for(int j=0;j<n;j++){
        cin>>temp;
        s.insert(temp);
    }
    int q;
    set<int,greater<int>>::iterator ptr;
    cin>>q;
    int total=0;
    for(int i=0;i<q;i++){
        cin>>temp;
        auto it=s.lower_bound(temp);
        for(ptr=s.begin();ptr!=it;ptr++){
            total+=*ptr;
        }
        if(ptr!=s.end())
        total+=*ptr;
        cout<<*it*100<<" "<<total*100<<endl;
        total=0;
    }

    

	return 0;
}
