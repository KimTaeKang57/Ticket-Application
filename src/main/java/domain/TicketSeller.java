package domain;

/**
 * 매표소에서 초대장을 티켓으로 교환해 주거나 티켓을 판매하는 역할
 * 판매원은 자신이 일하는 매표소를 알아야 한다
 */
public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }
}
