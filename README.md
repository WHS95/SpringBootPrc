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


## 📕Bean initialize
    @ComponentScan을 당한 모든 Component(Bean)즉시 intialize가된다.

@Lazy를 사용하게되면  @ComponentScan 범위내에 있어도 Component(Bean)즉시 intialize가 되지 않는다.
호출이 되는 시점에 initailize가된다
`

    그렇다면 @Lazy는 필요할만한 요소인가?
일반적인 상황에서 필요하지 않으며 복잡하고 길어, 시작시 intialize에 무리가 될경우 따로 빼서` 사용할수도 있긴하다.
다만, 컴파일할때 initialize를 하지 않다보니 에러가 런타임시 발생하여 서비스 실행에 문제점을 야기 할수있어 권장되진않는다.

## 📕Bean Scope

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
