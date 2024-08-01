package com.student.pojo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    public Integer row;
    public Integer list;
    @JsonProperty("reading_room_id")
    public Integer readingRoomId;
}
