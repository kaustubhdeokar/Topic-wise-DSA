#include<iostream>
using namespace std;

class One{

    public:
        virtual void show()=0;
        //this is a pure virtual function .
        //classes have one or more pure virtual function are called as abstract class.
};

class Two:public One{
    public:
    void show(){
        cout<<"show in two";
    }
};

class Three:public Two{
    public:
    void show(){
        cout<<"kjdfn";
    }
};

int main(){
Two t;
t.show();
    return 0;
}
