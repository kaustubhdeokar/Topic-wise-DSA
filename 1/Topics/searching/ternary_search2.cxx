//finding the minimum value of a function thorugh the tertiary sort//

#include<iostream>
using namespace std;
typedef long long int ll;

double func(double x)
{ 
return 2*x*x - 12*x +7; 
}

double ts(double start, double end)
{
    double l = start, r = end;
	double l1,l2;
    for(int i=start; i<=end; i++) {
      l1 = (l*2+r)/3;
      l2 = (l+2*r)/3;
	  if(func(l1) < func(l2)) 
	  r = l2; else l = l1;
      }

    return (l1+l2)/2;
}

int main(){
	ll answer;
	ll t;
	cin>>t;
	int ans=ts(1,10);
	while(t)
	{
	ll l,r;
	cin>>l>>r;
	if(l<=ans and r>=ans)
	{
		answer=-11;
		cout<<answer<<endl;
	}
	else if(l<3 and r<3){
		answer=2*r*r - 12*r +7;
		cout<<answer<<endl;
	}
	else if(l>3 and r>3){
		answer=2*l*l - 12*l +7;
		cout<<answer<<endl;
	}
	t-=1;
	}
	
	return 0;
}
