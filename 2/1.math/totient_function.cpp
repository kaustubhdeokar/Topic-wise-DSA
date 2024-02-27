#include <iostream>
#include <cmath>
#include <list>

// Euler's Totient function is a function that is related to getting the number of numbers
// that are coprime to a certain number that are less than or equal to it

using namespace std;

list<int> generatePrimes(int limit)
{
    bool arr[limit] = {false};
    for (int i = 2; i < sqrt(limit); i++)
    {
        for (int j = i * 2; j < limit; j += i)
        {
            arr[j] = true;
        }
    }

    list<int> mylist;

    for (int i = 2; i < limit; i++)
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
            ans *= (1 - (1 / (element * 1.0)));
        }
    }
    cout << "Total number of numbers whose form coprimes with max_prime number are :" << ans << endl;
}