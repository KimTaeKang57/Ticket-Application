# Ticket-Application
오브젝트 : 티켓 판매 애플리케이션

## 로버트 마틴 : 소프트웨어 모듈이 가져야 하는 세가지 목적
1. 모든 모듈은 제대로 실행돼야 함
2. 변경이 용이해야 함
3. 이해하기 쉬워야 함

## V2
코드를 이해하기 어려웠던 이유는 Theater 가 관람색의 가방과 판매원의 매표소에 직접 접근하기 때문이다.
이는 관람객과 판매원이 직접 일을 처리해야 한다는 우리의 직관을 벗어난다.
Theater 가 관람객의 가방과 판매원의 매표소에 직접 접근한다는 것은 Theater 가 Audience 와
TicketSeller 와 결합된다는 것을 의미한다. 따라서, **관람객과 판매원을 자율적은 존재**로 만들면 되는것이다.

1. 자율성을 높이자  
Theater 가 Audience 와 TicketSeller 뿐만 아니라 Audience 소유의 Bag 와 
TicketSeller 가 근무하는 TicketOffice 까지 접근할 수 있기 때문에 설계를 변경하기 어렵다.
이 설계를 변경함으로서 자율적인 존재가 되도록 해야한다.

- Theater 의 enter 메소드에서 TicketOffice 에 접근하는 모든 코드를 TicketSeller 내부로 숨긴다.
결과 적으로 TicketOffice 에 대한 접근은 오직 TicketSeller 안에만 존재하게 된다. 따라서 TicketSeller 는
tickerOffice 에서 티켓을 꺼내거나 판매 요금을 적립하는 일을 스스로 수행할 수 밖에 없다.

이처럼 개념적이나 물리적으로 객체 내부의 세부적인 사항을 감추는 것을 **캡슐화** 라고 한다.
캡슐화의 목적은 변경하기 쉬운 객체를 만드는 것이다. 캡슐화를 통해 객체 내부로의 접근을 제한하면
객체와 객체 사이의 결합도를 낮출 수 있기 때문에 설계를 좀 더 쉽게 변경할 수 있다.

- TicketSeller 는 Audience 의 getBag 메서드를 호출해서 Audience 내부의 Bag 인스턴스에 직접 접근한다.
Bag 인스턴스에 접근하는 객체가 Theater 에서 TicketSeller 로 바뀌었을 뿐 Audience 는 
여전히 자유롭지 않다. Bag 에 접근하는 모든 로직을 Audience 내부로 감추기 위해 buy 메서드를 추가하고 Ticket 
TicketSeller 의 sellTo 메서드에서 getBag 메서드에 접근하는 부분을 buy 로 옮기자. 이렇게 되면 TicketSeller
와 Audience 의 결합도가 낮아졌다.


캡슐화로 코드를 개선한 이후 Audience 와 TicketSeller 가 내부 구현을 외부에 노출하지 않고
자신의 문제를 스스로 책임지고 해결한다는 것이다. 자율적인 존재가 된 것이다.

