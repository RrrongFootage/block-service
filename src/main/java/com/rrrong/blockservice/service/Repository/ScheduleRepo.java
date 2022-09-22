package com.rrrong.blockservice.service.Repository;

import com.rrrong.blockservice.dto.ScheduleDto;
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
public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {

@Modifying
@Query("update schedule s set s.archived_date = current_timestamp where s.id =?1")
void archiveSchedule(@Param("id") int id);
}
