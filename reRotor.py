s = list(map(int,input().split(",")))
out = [0]*len(s)

for i in range(len(s)):
    out[s[i]] = i

print(out)