package com.rrrong.blockservice.service.Repository;

import com.rrrong.blockservice.entity.Block;
import com.rrrong.blockservice.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BlockRepo extends JpaRepository<Block, Integer> {

    @Query("SELECT sb FROM serviceblock sb WHERE sb.start_date >=?1 AND sb.end_date <=?2")
    List<Block> findAllByStart_dateLessThanEqualAnAndEnd_dateGreaterThanEqual(@Param("start_date") Date Start_date, @Param("end_date") Date End_date);



    @Modifying
    @Query("update serviceblock sb set sb.start_date = ?1, sb.end_date = ?2 where sb.id = ?3")
    void updateServiceBlock(@Param("start_date") Date startDate, @Param("end_date") Date endDate, @Param("id") int id);

    @Modifying
    @Query("update serviceblock sb set sb.schedule.id = ?1 where sb.id = ?2")
    void linkScheduleToBlock(@Param("id") int scheduleId, @Param("id") int id);
}
