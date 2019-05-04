#include <iostream>
#include<map>
#include <vector>
#include <algorithm>
using namespace std;
class bag
{
	char name[30];
	int num_Of_Items;
	float item_Wt[20];
	float item_Count[20];	
	public:
	void get();
	//print only name of bag
	void print();
	//Compute weight from details given
	float compute();
};

void bag::get(){
    cin>>name>>num_Of_Items;
    for(int i=0;i<num_Of_Items;i++){
        cin>>item_Wt[i]>>item_Count[i];
    }

}

void bag::print(){
    cout<<name<<"\n";
}

float bag::compute(){
    float total=0;
    for(int i=0;i < num_Of_Items;i++)  
    total+=item_Count[i]*item_Wt[i];  
    return(total);  
}

bool wayToSort(int i, int j);

class solar
{
	map<float,bag> m1;
	vector<float> v;
	int num_Bags;
	public:
	//get details of bags and insert into map and vector
	// In map, key - weight and value - details of bag
	// In vector, weight of bags
	void get();
	//void sort_Vec();
	//print name of bags in sorted order
	//void print_In_Order();
};

void solar::get(){

    bag b;
    cin>>num_Bags;
    for(int i=0;i<num_Bags;i++){
        b.get();
        m1.insert(pair<float,bag> (b.compute,b));
        v.push_back(b.compute());
    }


}

int main()
{
	solar s;
	s.get();
	//s.sort_Vec();
	//s.print_In_Order();
}
