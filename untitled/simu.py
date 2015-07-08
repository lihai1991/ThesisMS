__author__ = 'Hai'
import random
import math
var=1
step_number=10
x=0
y=0
a1=0
a2=0
b1=20
b2=0
c1=20
c2=20
d1=0
d2=20 #four corner ordinates
P_user=100
P_noise=1
def f(x,y):
    if x>a1 and x<b1 and y>a2 and y<d2:
        return 1
    else:
        return 0
def d(a,b,c,d):
    return math.sqrt((a-c)**2+(b-d)**2)
def rssi(d):
    return P_user/(d**2)+P_noise
for i in range(0,step_number):
    x=x+random.normalvariate(0,var)
    y=y+random.normalvariate(0,var)
    d1=d(x,y,a1,a2)
    d2=d(x,y,b1,b2)
    d3=d(x,y,c1,c2)
    d4=d(x,y,d1,d2)
    print x,y
    print f(x,y)
    print rssi(d1),rssi(d2),rssi(d3),rssi(d4)
    print "\n"
print "Hello World!"
print "This is a Python program."