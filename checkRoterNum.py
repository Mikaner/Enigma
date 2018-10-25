a = list(map(int,input().split(',')))

for i in range(len(a)):
    if(a[i] != a.index(i)):
        print("Error")
        break
else:
    print("success")