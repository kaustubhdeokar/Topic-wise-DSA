#include <iostream>
#include <cmath>
#include <list>

using namespace std;

list<int> generatePrimes(int max_prime)
{
    bool arr[max_prime] = {false};
    for (int i = 2; i < sqrt(max_prime); i++)
    {
        for (int j = i * 2; j < max_prime; j += i)
        {
            arr[j] = true;
        }
    }

    list<int> mylist;

    for (int i = 2; i < max_prime; i++)
    {
        if (arr[i] == false)
        {
            mylist.push_back(i);
        }
    }
    return mylist;
}

int main()
{
    int max_prime;
    cout << "Enter prime limit" << endl;
    cin >> max_prime;
    list<int> primes = generatePrimes(max_prime);
    int ans = max_prime;
    for (auto &element : primes)
    {
        if (max_prime % element == 0)
        {
            ans*= (1 - (1 / (element*1.0)));
            
        }
    }

    cout << ans << endl;
}