package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;

@Entity
@NamedNativeQuery(name = "SpecialDto", query = """
            select id, filename, directory_id as directoryId, length_file as lengthFile, sumLengthFile, qtyFileInDir
            from (
            	select f.*,
            	  sum(f.length_file) over(partition by d.id) as sumLengthFile,
            	  count(f.*) over(partition by d.id) as qtyFileInDir
            	from public.file f inner join public.directory d on d.id = f.directory_id
            ) as res
            order by res.sumLengthFile desc
            """, resultSetMapping = "SpecialDtoMapping")
@SqlResultSetMapping(name = "SpecialDtoMapping",
        classes = {
                @ConstructorResult(
                        columns = {
                                @ColumnResult(name = "id", type = long.class),
                                @ColumnResult(name = "filename"),
                                @ColumnResult(name = "directoryId", type = long.class),
                                @ColumnResult(name = "lengthFile", type = long.class),
                                @ColumnResult(name = "sumLengthFile", type = long.class),
                                @ColumnResult(name = "qtyFileInDir", type = long.class),
                        },
                        targetClass = SpecialDto.class
                )}
)
public class File {
    @Id
    private Long id;
    @Column
    private String filename;
}
