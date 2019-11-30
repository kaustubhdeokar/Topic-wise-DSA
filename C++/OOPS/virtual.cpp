#include<iostream>
using namespace std;

class Base{
    public:
    virtual void Method(){
        cout<<"base method";
    }
};

class Derived:public Base{

    public:
    void Method(){
        cout<<"derived"<<endl;
    }
};

class TooDerived:public Base{
    public:
    void Method(){
        cout<<"too derived"<<endl;
    }

};

void call(Base &b){
    b.Method();
}

int main(){
    
    TooDerived t;
    call(t);
    //as the base class function is virtual then the property of 
    //polymorphism is seen as the method in the derived class is called.
    Derived d;
    call(d);

    //if the function is absent for example the function Method is absenrt from the Too
    //Derived classs then function in the base class is printed. 
    return 0;
}
