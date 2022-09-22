package com.example.eunboard.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "Withdrawal")
@Entity
public class Withdrawal extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "withdrawal_id")
    private Long id;

    /** 비밀번호 */
    @Column(name = "password")
    private String password;

    /** 이메일 */
    @Column(name = "email")
    private String email;

    /** 계좌 번호 */
    @Column(name = "account_number")
    private String accountNumber;

    /** 입금 금액 */
    @Column(name = "money")
    private String money;

    /** 탈퇴 이유 */
    @Column(name = "content")
    private String content;
}
