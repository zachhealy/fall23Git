import numpy as np

'''
number 1
----------

def arrayMax(a, n):
    currentMax = a[0]
    
    for i in range(n - 1):
        if a[i] > currentMax:
            currentMax = a[i]
        n =+ 1
    return currentMax

n = 100
a = np.random.randint(0, 100, 100)

print(arrayMax(a, n))
'''

'''
number 2
---------

def avg(x, n):
    a = np.random.randint(0, 1, 100)
    for i in range (n - 1):
        s = x[0]
        for j in range(i):
            s = s + x[j]
        a[i] = s/(i + 1)
    return a


n = 100
x = np.random.randint(0, 100, 100)

a = avg(x, n)

print(a)

'''

'''
number 3
---------
'''

def avg2(x, n):
    a = np.random.randint(0, 1, 100)
    s = 0
    for i in range(n -1):
        s = s + x[i]
        a[i] = s/(i + 1)
    return a
    

n = 100
x = np.random.randint(0, 100, 100)

a = avg2(x, n)

print(a)



'''
number 4
----------

n = 100
i = 1
sum = 0

while i <= n:
    j = 1
    while j <= n:
        sum = sum + i
        j += 1
    i += 1

print(sum)
'''

'''
number 5
---------

n = 100
i = 1
sum = 0

while i <= n:
    i += 1
    sum += i
    
print(sum)

'''

'''
number 6
----------

def num6(a1, a2, n):
    for i in range(n):
        j = i
        while a1[i] != a2[j]:
            if j > a1.size:
                return False
            j += 1
        tmp = a2[j]
        a2[j] = a2[i]
        a2[i] = tmp
        
    return True


n = 100
a1 = np.random.randint(0, 100, n)
a2 = np.random.randint(0, 100, n)

print(num6(a1, a2, n))

'''

'''
number 7
-----------


def inversionCounter(a, n):
    count = 0
    for i in range(n-1):
        for j in range(n-1):
            j = i + 1
            if a[i] > a[j]:
                count += 1
    return count

n = 100
a = np.random.randint(0, 100, n)

print(inversionCounter(a, n))
'''
