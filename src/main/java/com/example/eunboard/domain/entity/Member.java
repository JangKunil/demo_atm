package com.example.eunboard.domain.entity;

import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
@Table(name = "member")
@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    /** 이름 */
    @Column(name = "member_name")
    private String memberName;

    /** 연락처 */
    @Column(name = "phone_number", length = 30)
    private String phoneNumber;

    /** 이메일 */
    @Column(name = "email")
    private String email;

    /** 비밀번호 */
    @Column(name = "password")
    private String password;

    /** 계좌 번호 */
    @Column(name = "account_number")
    private String accountNumber;

    /** 돈 */
    @Column(name = "money")
    private long money;

    /** 탈퇴여부 */
    @ColumnDefault("0")
    @Column(name = "is_removed", columnDefinition = "TINYINT", length = 1)
    private int isRemoved;

    /** 탈퇴일자 */
    @Column(name = "delete_date", length = 10)
    private Date deleteDate;


}
