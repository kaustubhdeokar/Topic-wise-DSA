//finding the maximum value of a function thorugh the tertiary sort//



#include<iostream>
using namespace std;

double func(double x)
{ 
return -1*1*x*x + 2*x +3; 
}


double ts(double start, double end)
{
    double l = start, r = end;

    for(int i=0; i<10; i++) {
      double l1 = (l*2+r)/3;
      double l2 = (l+2*r)/3;
      cout<<l1<<" "<<l2<<endl;
      if(func(l1) > func(l2)) r = l2; else l = l1;
      }

     double x = l;
    return func(x);
}

int main(){
	double ans=ts(0,4);
	cout<<"maximum value of a function is:"<<ans;
	return 0;
}
