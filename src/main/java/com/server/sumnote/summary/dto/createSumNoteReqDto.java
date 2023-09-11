package com.server.sumnote.summary.dto;

import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class createSumNoteReqDto {
    private User user;
    private Summary summary;
}
