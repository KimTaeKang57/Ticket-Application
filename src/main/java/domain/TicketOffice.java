package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 관람객이 소극장에 입장하기 위해선 매표소에서 초대장을 티켓으로 교환하거나 구매해야 함
 *
 * 매표소 -> 판매할 티켓과 티켓의 판매 금액이 있다.
 */
public class TicketOffice {
    private Long amount; // 판매 금액
    private List<Ticket> tickets = new ArrayList<>(); // 판매하거나 교환해 줄 티켓의 목록

    public TicketOffice(Long amount, List<Ticket> tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }

    public Ticket getTicket(){
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
