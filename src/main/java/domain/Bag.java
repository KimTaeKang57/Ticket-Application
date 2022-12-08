package domain;

/**
 * 관람객이 소지품을 보관할 클래스
 * 초대장, 현금, 티켓
 *
 * 이벤트에 당첨 - 현금과 초대장
 * 이벤트에 당첨 x - 초대장이 없음
 * 따라서 인스턴스의 상태 -> 생성자 -> 현금+초대장 보관 중 or 현금만 보관
 */
public class Bag {
    private Long amount; // 현금
    private Invitation invitation; // 초대장
    private Ticket ticket; // 티켓

    // 현금만 보관 -> 이벤트 당첨 x
    public Bag(long amount) {
        this.invitation = null;
        this.amount = amount;
    }

    public Bag(Invitation invitation, Ticket ticket) {
        this.invitation = invitation;
        this.ticket = ticket;
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    // 초대받았는가 ?
    private boolean hasInvitation() {
        return invitation != null;
    }

    // 티켓을 가지고 있는가 ?
    public boolean hasTicket() {
        return ticket != null;
    }

    // 초대장을 티켓으로 교환
    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    // 현금을 증가시키거나 감소
    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
