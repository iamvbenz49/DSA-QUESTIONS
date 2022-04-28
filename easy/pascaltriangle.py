list_lenght = int(input("llenght"))
lst = [[1],[1,1]]
index_use,index_work,lenght_of_work = 1,2,3

def insert_twice(mid,num):
    lst[index_work].insert(mid,num)
    lst[index_work].insert(mid,num)
for i in range(list_lenght-2):
    lst.append([1,1])

for i in range(3,list_lenght+1):
    index_of_add = 0
    mid = len(lst[index_work])//2
    while len(lst[index_work]) < lenght_of_work:
        print(lst)
        num = lst[index_use][index_of_add] + lst[index_use][index_of_add+1]
        if lst[index_use][index_of_add] == lst[index_use][index_of_add+1] :
            lst[index_work].insert(mid,num)
        else:
            insert_twice(mid,num)
        mid = len(lst[index_work])//2
        index_of_add+=1        
    lenght_of_work+=1
    index_use+=1
    index_work+=1
print(lst)