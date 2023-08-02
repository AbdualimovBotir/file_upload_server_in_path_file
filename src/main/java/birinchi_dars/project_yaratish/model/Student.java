package birinchi_dars.project_yaratish.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

    public Student() {
    }

    public Student(Long id, String name, String lastName, Integer age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    private Long id;
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    private Integer age;

    private Cource cource;

    public Cource getCource() {
        return cource;
    }

    public void setCource(Cource cource) {
        this.cource = cource;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name=name;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(){
        this.lastName=lastName;
    }
    public Integer getAge(){
        return age;
    }
    public void setAge(){
        this.age=age;
    }

    public void setLastName(String test_uchun) {
    }
}
