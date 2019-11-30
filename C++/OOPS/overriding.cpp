#include<iostream>
using namespace std;

class Base{
    public:
    void Method(){
        cout<<"base method";
    }
};

class Derived:public Base{

    public:
    void Method(){
        cout<<"derived"<<endl;
        Base::Method();
    }
};


int main(){

    Derived b;
//    b.Method(); //this will print the overridden methods.

    Base a;
//    a.Method(); //this will print the base class' method.

    //to print the base class by calling the derived class method we need to do the following 
    //thing/

//    b.Base::Method();

    //to call both we can do the following thing inside the derived class 
    /*
        Base::Method();
    */

     b.Method();

    return 0;
}
