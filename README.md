# 🙋🏻‍♂️SpringBootPrc Study log

## 📕Spring Java Bean VS Pojo VS Spring Bean

Java Bean

1) Have public default(no argument) constructros;
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

## 📕Bean initialize

    @ComponentScan을 당한 모든 Component(Bean)즉시 intialize가된다.

@Lazy를 사용하게되면 @ComponentScan 범위내에 있어도 Component(Bean)즉시 intialize가 되지 않는다.
호출이 되는 시점에 initailize가된다
`

    그렇다면 @Lazy는 필요할만한 요소인가?

일반적인 상황에서 필요하지 않으며 복잡하고 길어, 시작시 intialize에 무리가 될경우 따로 빼서` 사용할수도 있긴하다.
다만, 컴파일할때 initialize를 하지 않다보니 에러가 런타임시 발생하여 서비스 실행에 문제점을 야기 할수있어 권장되진않는다.

## 📕Bean Scope
    스프링은 기본적으로 모든 bean을 singleton으로 생성하여 관리한다.
    구체적으로는 애플리케이션 구동 시 JVM 안에서 스프링이 bean마다 하나의 객체를 생성하는 것을 의미한다.
    그래서 우리는 스프링을 통해서 bean을 제공받으면 언제나 주입받은 bean은 동일한 객체라는 가정하에서 개발을 한다

    https://gmlwjd9405.github.io/2018/11/10/spring-beans.html

    @Component @Scope(value="singleton")  
    @Component @Scope(value="prototype")  
    @Component @Scope(value="request")  
    @Component @Scope(value="session")  
    @Component @Scope(value="application")  

1) Singleton Scope
   Spring의 기본 범위.
   하나의 Bean 인스턴스만 생성되어 전체 애플리케이션 컨텍스트에서 공유됩니다.
   Bean은 애플리케이션 컨텍스트가 초기화될 때 생성되고 컨텍스트가 파기될 때까지 메모리에 남아 있습니다.
   이 범위는 애플리케이션의 여러 부분에서 안전하게 공유할 수 있는 Stateless Bean 및 Bean에 적합합니다.

2) Prototype Scope
   컨테이너에서 요청될 때마다 Bean의 새 인스턴스가 생성됩니다.
   각 인스턴스는 다른 인스턴스와 독립적이며 자체 상태를 갖습니다.
   이 범위는 Stateful Bean 또는 서로 격리되어야 하는 Bean에 적합합니다.

3) Request Scope
   웹 애플리케이션의 각 HTTP 요청에 대해 Bean의 새 인스턴스가 생성됩니다.
   해당 빈은 현재 요청한 범위 내에서만 사용 가능합니다.
   이 범위는 요청별 데이터를 보유하는 Bean에 사용됩니다.

4) Session Scope
   웹 애플리케이션의 각 사용자 세션에 대해 Bean의 새 인스턴스가 생성됩니다.
   Bean은 사용자 세션이 지속되는 동안 사용할 수 있습니다.
   사용자별 데이터를 저장하는 데 유용합니다.

5) Application Scope
   전체 웹 애플리케이션 컨텍스트에 대해 Bean의 단일 인스턴스가 생성됩니다.
   Bean은 모든 세션과 요청에서 공유됩니다.
   전역 설정 또는 공유 리소스에 적합합니다.

6) WebSocket Scope:
   스프링 5.0에서 도입되었습니다.
   요청 범위와 유사하지만 WebSocket 기반 애플리케이션을 위해 특별히 설계되었습니다.
   각 WebSocket 세션마다 Bean의 새 인스턴스가 생성됩니다.

## 📕Bean 생명주기 다루기

1) @PostConstruct   
   Bean intialize 할 때 작동할 메소드에 적용하면 작동됢

2) @PreDestroy  
   Bean Destroy 할 때 작동할 메소드에 적용하면 작동됢

* 참고 링크
* https://ttl-blog.tistory.com/99

## 📕Spring Anotation 정리

1) @Configuration
    1) 설정파일을 만들기위한 어노테이션,
    2) Bean을 등록하기위한 어노테이션,
    3) Bean을 등록할때 싱글톤을 유지 하게 해주는 어노테이션
2) @Bean
    1) 메소드가 Spring 컨테이너에 의해 관리되어야 하는 것임을 Spring 에게 알려준다 (즉 빈 등록의 역할)
3) @Component
    1) 직접 개발한 클래스를 빈으로 편리하게 등록하고자 하는 경우에는 @Component 어노테이션을 활용
4) @Controller
    1) 클래스가 Spring MVC 컨트롤러임을 나타내는 데 사용되는 어노테이션
5) @Service
    1) 클래스가 비즈니스 구성 요소임을 나타내는 데 사용되는 어노테이션
6) @Repository
    1) 클래스가 DAO(데이터 액세스 개체) 또는 저장소 구성 요소임을 나타내는 데 사용되는 어노테이션


        요약: @Configuration+ @Bean 조합으로 Bean을 등록해라, 직접개발한 클래스를 Bean으로 등록할때는 @Component를 써라, 
        왠만하면 목적에 맞게 @Controller, @Service, @Repository를 사용해서 해당 클래스의 역할을 구체화 해라