package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SpecialDto {
    private Long id;
    private String filename;
    private Long lengthFile;
    private Long directoryId;
    private Long sumLengthFile;
    private Long qtyFileInDir;
}
