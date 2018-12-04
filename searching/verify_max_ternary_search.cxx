
#include<iostream>
using namespace std;

double func(double x)
{ 
return 2*x*x - 12*x +7; 
}

double ts(double start, double end)
{
    double l = start, r = end;

    for(int i=start; i<=end; i++) {
      double l1 = (l*2+r)/3;
      double l2 = (l+2*r)/3;
      if(func(l1) < func(l2)) r = l2; else l = l1;
      }

     double x = l;
    return func(x);
}

int main(){
	int t;
	cin>>t;
	while(t)
	{
	int l,r;
	cin>>l>>r;
	double ans=ts(l,r);
	cout<<ans<<endl;
	t-=1;
	}
	return 0;
}
