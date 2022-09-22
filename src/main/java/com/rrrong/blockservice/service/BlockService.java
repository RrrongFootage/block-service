package com.rrrong.blockservice.service;

import com.rrrong.blockservice.dto.BlockDto;
import com.rrrong.blockservice.dto.PlaceDto;
import com.rrrong.blockservice.dto.ScheduleDto;
import com.rrrong.blockservice.entity.Block;
import com.rrrong.blockservice.entity.Place;
import com.rrrong.blockservice.entity.Schedule;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface BlockService {
    PlaceDto getPlace(Integer id);

    ScheduleDto getSchedule(Integer id);

    BlockDto getBlock(Integer id);

    PlaceDto createPlace(PlaceDto placeDto);

    ScheduleDto createSchedule(ScheduleDto scheduleDto);

    BlockDto createServiceBlock(BlockDto blockDto);

    List<PlaceDto> getAllPlaces();

    List<ScheduleDto> listBlockLinkedSchedulesByDate(String startDate, String endDate) throws ParseException;

    void updatePlace(PlaceDto placeDto);

    void archivePlace(PlaceDto placeDto);

    void archiveSchedule(ScheduleDto scheduleDto);

    List<BlockDto> getServiceBlocksByRange(String startDate,String endDate) throws ParseException;

    void updateServiceBlock(BlockDto blockDto);

    void linkScheduleToBlock(int scheduleId, List<BlockDto> serviceBlocks);
}
