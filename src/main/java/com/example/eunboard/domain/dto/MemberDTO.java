package com.example.eunboard.domain.dto;

import com.example.eunboard.domain.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberDTO {

    @JsonIgnore
    private long id;

    /** 인증토큰 */
    @JsonIgnore
    private String token;

    /** 이름 */
    private String memberName;

    /** 연락처 */
    private String phoneNumber;

    /** 이메일 */
    private String email;

    /** 비밀번호 */
    private String password;

    /** 계좌 번호 */
    private String accountNumber;

    /** 돈 */
    private long money;

    public static Member toEntity(MemberDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Member.class);
    }

}
