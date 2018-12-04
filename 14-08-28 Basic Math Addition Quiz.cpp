/*
 *basic math addition quiz.
 *28 august 2014 ce.
 ***
 *not a decent program
 *i'm just practising c++
 */

#include <iostream>
#include <stdlib.h>
#include <ctime>

using namespace std;

int mTest(int x, int y, int pts);

int main()
{
    srand(time(0));
    int pts = 0;
    int total;
    cout << "How many questions would you like?" << endl;
    cin >> total;
    cout << "Have fun! ^_^" << endl;
    for(int p=0;p<total;p++)
        pts = mTest((rand()%100), (rand()%100), pts);
    cout << "\n" << pts << " right answer(s) out of " << total << " questions.";
    if(pts == total)
        cout << " Congratulations." << endl;
    else
        cout << endl;
}

int mTest(int x, int y, int pts){
    cout << x << " + " << y << " = ";
    int z;
    cin >> z;
    int tot = x + y;
    int in = pts;
    if(z==tot){
        cout << "+Correct" << endl;
        in++;
    }else
        cout << "xWrong. Answer is " << tot << endl;
    return in;
}
