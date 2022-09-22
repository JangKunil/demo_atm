package com.example.eunboard.domain.dto;

import com.example.eunboard.domain.entity.Deposit;
import com.example.eunboard.domain.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DepositDTO {

    @JsonIgnore
    private long id;

    /** 비밀번호 */
    private String password;

    /** 계좌 번호 */
    private String accountNumber;

    /** 입금 금액 */
    private long money;

    /** 탈퇴 이유 */
    private String content;


    public static Deposit toEntity(DepositDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Deposit.class);
    }

}
