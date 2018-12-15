class Employee:
    def __init__(self,first,last):
        self.first=first
        self.last=last
        self.email=first+'.'+last
    def fullname(self):
        print('{} {}'.format(self.first,self.last))


emp1=Employee('k','d')
emp2=Employee('j','d')

emp1.fullname()

#instance variables constain unique
