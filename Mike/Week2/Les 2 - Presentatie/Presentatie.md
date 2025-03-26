```java
class ClassOne(){
    private int jeKanHierNietBij; //wel goed
    public int jeKanHierWelBij; //niet goed
    
    public ClassOne(int jeKanHierNietBij, int jeKanHierWelBij){
        jeKanHierNietBij = 1;
        jeKanHierWelBij = 2;
    }
}
```

```java
class classTwo(){
    private ClassOne classOne;
    
    public classTwo(ClassOne classOne){
        this.classOne = classOne;
        classOne.jeKanHierWelBij = 3;  //niet de bedoeling want dit hoeft helemaal niet
    }
}
```
