package com.devesh.abhang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "subMaster")
public class SubMaster {

        @Id
        private String subId;

        private String name;

        private String status;

        private String content;

        @CreatedDate
        private LocalDate createdDate;

        private String mainId;

}
