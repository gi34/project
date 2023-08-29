
class Record
{

    private String name;
    private String disease,advice;
    private int age,ID;

    public String getName(){
        return name;
    }
    public void setName(String newName){
        name=newName;
    }
    public void setID(int newID){
        ID=newID;
    }
    public int getID(){
        return ID;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int newAge){
        age=newAge;
    }
    public void setDisease(String newDisease){
        disease=newDisease;
    }
    public String getDisease(){
        return disease;
    }
    public void setAdvice(String newAdvice){
        advice=newAdvice;
    }
    public String getAdvice(){
        return advice;
    }
    public Record(String newName,int newID,int newAge,String newDisease,String newAdvice){
        disease=newDisease;
        name=newName;
        age=newAge;
        ID=newID;
        advice=newAdvice;
    }
}

