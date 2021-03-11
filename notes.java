//// string to char
for(i...) charAt(i);


//// char to int
// because the value is read as ASCII code
// in ASCII, numbers starts at 48, and '0' is exactly 48!
int a;
char b ='5';
a = b-'0';


//// use of ^
(boolean)
if( true ^ true ) return false;
if (false ^ true) return true;
if (true ^ false) return false;
if(false ^ false) return true;
(int)
int a=3;
int b=4;
// 3 = 0011   4 = 0100
// a = 0011^0100 = 0111 a=7
a^=b;
// b = 4 ^ 7, do the same
b^=a;


//// use of ? : 
int a=0,b=1,max;
// the two ways work the same
if (a > b) {
      max = a;
    }
    else {
      max = b;
    }

//if a>b is true, max=b; else, max=a;
max=    (a>b)   ?a    :b;
    

