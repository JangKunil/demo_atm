package com.example.eunboard.domain.dto;

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
public class WithdrawalDTO {

    @JsonIgnore
    private long id;

    /** 비밀번호 */
    private String password;

    /** 계좌 번호 */
    private String accountNumber;

    /** 입금 금액 */
    private String money;

    /** 탈퇴 이유 */
    private String content;


    public static Member toEntity(WithdrawalDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Member.class);
    }

}
