#include <bits/stdc++.h>
typedef long long int li;

using namespace std;

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int character_dict[26] = {0};
		string s;
		cin>>s;
		int len = s.length();
		int ans;
		int min_ans = INT_MAX;
		for(int n = 0; n<len; n++)
		{
			character_dict[s[n] - 'A']++;
		}
		sort(character_dict, character_dict+26, greater<int>());
		for(int counter = 1; counter<=26; counter++)
		{
			if(len % counter == 0)
			{
				ans = 0;
				int bound = len/counter;
				int extra = 0;
				for(int n = 0; n<counter; n++)
				{
                 //   cout<<"character_dict:"<<character_dict[n]<<endl;
					if(character_dict[n] + extra < bound)
					{
                   //     cout<<"entering if";
						extra = 0;
						ans += bound - character_dict[n] - extra;
                     //   cout<<"extra is:"<<extra<<endl;
                       // cout<<"ans is:"<<ans<<endl;
					}
					else
					{
                        //cout<<"entering else";
						extra -= bound - character_dict[n];
						//cout<<"extra is:"<<extra<<"";
                        if(extra < 0)
						{
							ans -= extra;
						}
                        //cout<<"ans is:"<<ans<<endl;
						extra = 0;
					}
				}
				//cout<<counter<<" "<<ans<<endl;
				min_ans = min(min_ans, ans);
			}
		}
		cout<</*s<<" "<<*/min_ans<<endl;
	}
	return 0;
}