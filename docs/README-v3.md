# Ticket-Application
오브젝트 : 티켓 판매 애플리케이션

## 로버트 마틴 : 소프트웨어 모듈이 가져야 하는 세가지 목적
1. 모든 모듈은 제대로 실행돼야 함
2. 변경이 용이해야 함
3. 이해하기 쉬워야 함

## V3
더 개선할 사항이 있다. 분명 Audience 는 자율적인 존재이다. Audience 는 스스로 티켓을 구매하고
가방 안의 내용물을 직접 관리한다. 하지만 Bag 는 어떤가 ? Bag 는 이전의 Audience 와 같이
이끌려다니는 존재이다.

Bag 를 자율적인 존재로 바꿔보자. Bag 의 내부 상태에 접근하는 모든 로직을 Bag 안으로 캡슐화 하여
결합도를 낮추면 된다. Audience 의 buy 메서드를 Bag 의 hold 메서드로 추가하자. 이제 Bag 는
관련된 상태와 행위를 함께 가지는 응집도 높은 클래스가 됐다.

TicketSeller 역시 TicketOffice 의 자율권을 침해한다. 현재의 TicketSeller 는 TicketOffice
에 있는 Ticket 을 마음대로 꺼내서 자기 멋대로 Audience 에 판매하고 판매금액을 TicketOffice 에
넣어버린다.

TicketOffice 를 자율적인 존재로 바꿔보자. TicketOffice 의 내부 상태에 접근하는 모든 로직을
TicketOffice 안으로 캡슐화 하여 결합도를 낮추면 된다. TicketSeller 의 sellTo 메서드를 TicketOffice
의 sellTo 메서드로 추가하자. 이제 TicketOffice 는 관련된 상태와 행위를 함께 가지는 응집도 높은
클래스가 됐다.

그러나 이 변경은 만족스럽지 못하다. 그 이유는 TicketOffice 와 Audience 사이에 의존성이 추가됐기 때문이다.
변경 전에는 TicketOffice 가 Audience 에 대해 알지 못했다. 변경 후에는 TicketOffice 가 Audience 에게
직접 티켓을 판매하기 때문에 Audience 에 관해 알고 있어야 한다. 변경전에는 존재하지 않았던 의존성이
추가 된것이다.

현재로서는 Audience 에 대한 결합도와 TicketOffice 의 자율성 모두를 만족시키는 방법이 잘 떠오르지 않는다.
개발팀은 TicketOffice 의 자율성 보다는 Audience 에 대한 결합도를 낮추는 것이 더 중요하다는 결론을 냈다.

이 작은 예제를 통해 1. 어떤 기능을 설계하는 방법은 한가지 이상 2. 동일한 기능을 한 가지 이상의 방법으로 설계 가능
따라서 결국 설계는 트레이드 오프의 산물이다. 어떤 경우에도 모두 만족하는 설계를 만들 순 없다.

Theater 과 Bag, TicketOffice 는 실세계에서 자율적인 존재가 아니다. 소극장에 관람객이 입장하기 위해선
누군가가 소극장의 문을 열고 허가해주어야하고, 가방에서 돈을 꺼내는것은 관람객이지 가방이아니다. 비록 현실에서는
수동적인 존재라고 할 지다로 일단 객체지향의 세계에 들어오면 모든 것이 능동적이고 자율적인 존재가 된다.
이처럼 능동적이고 자율적인 존재로 소프트웨어 객체를 설계하는 원칙을 **의인화** 라고한다.
