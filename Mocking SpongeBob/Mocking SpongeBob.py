'''
Created on Aug 12, 2017
'''

if __name__ == '__main__':
    pass

def ind_next_letter(sentence, pos):
    for i in range(pos, len(sentence)):
        c=sentence[i]
        if c>='a' and c<='z' or c>='A' and c<='Z':
            return i
    return -1

loop=int(input(""))
for i in range(loop):
    string=input('')
    pos=0
    ind=ind_next_letter(string,pos)
    upper=False
    while ind!=-1:
        temp=string[:ind]
        if upper:
            temp+=string[ind].upper()
        else:
            temp+=string[ind].lower()
        upper = not upper
        temp+=string[ind+1:]
        string=temp
        ind=ind_next_letter(string,ind+1)
    print(string)