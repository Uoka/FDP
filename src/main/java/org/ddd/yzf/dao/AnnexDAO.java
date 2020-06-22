package org.ddd.yzf.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ddd.yzf.entity.Annex;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AnnexDAO {

    int addAnnex(Annex annex);

    int delAnnexById(@Param("uid") Long uid);

    int delAnnexByKey(@Param("fieldId") Long fieldId,
                      @Param("tableName") String tableName);

    int updateAnnex(Annex annex);

    Annex getAnnexById(@Param("uid") Long uid);

    Annex getAnnexByKey(@Param("fieldId") Long fieldId,
                        @Param("tableName") String tableName);

}
