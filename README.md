# 🙋🏻‍♂️SpringBootPrc Study log


## 📕Spring Java Bean VS Pojo VS Spring Bean

Java Bean
1) Have public  default(no argument) constructros;
2) Allow access to their property using getter and setter;
3) Implement java.io.Serializable

Pojo
1) No constraints
2) Any Java Object is a Pojo

Spring Bean
1) Spring use IOC container(Bean Factory or Applcaiton Context) to manage these Object;



## 📕How to matching Bean(in Multi Case)

1) @Primary
2) @Qualifier


## 📕Spring Dependency injection Types

1) Constructor-based(생성자 주입방식)
2) Setter-based(수정자 주입방식)
3) Field (필드주입방식)