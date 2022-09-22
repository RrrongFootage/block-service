package com.rrrong.blockservice.util;

import com.rrrong.blockservice.dto.BlockDto;
import com.rrrong.blockservice.dto.PlaceDto;
import com.rrrong.blockservice.dto.ScheduleDto;
import com.rrrong.blockservice.entity.Block;
import com.rrrong.blockservice.entity.Place;
import com.rrrong.blockservice.entity.Schedule;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UtilConverter {
    public static ScheduleDto mapScheduleDto(Schedule schedule) {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setId(schedule.getId());
        scheduleDto.setKey(schedule.getKey());
        scheduleDto.setCreated_date(schedule.getCreated_date());
        scheduleDto.setArchived_date(schedule.getArchived_date());
        return scheduleDto;
    }

    public static PlaceDto mapPlaceDto(Place place) {
        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(place.getId());
        placeDto.setLabel(place.getLabel());
        placeDto.setLatitude(place.getLatitude());
        placeDto.setLongitude(place.getLongitude());
        placeDto.setCreated_date(place.getCreated_date());
        placeDto.setUpdated_date(place.getUpdated_date());
        placeDto.setArchived_date(place.getArchived_date());
        return placeDto;
    }

    public static BlockDto mapBlockDto(Block block) {
        BlockDto blockDto = new BlockDto();
        blockDto.setId(block.getId());
        blockDto.setKey(block.getKey());
        blockDto.setCreated_date(block.getCreated_date());
        blockDto.setArchived_date(block.getArchived_date());
        blockDto.setUpdated_date(block.getUpdated_date());
        blockDto.setPlace(mapPlaceDto(block.getPlace()));
        if(block.getSchedule() != null) {
            blockDto.setSchedule(mapScheduleDto(block.getSchedule()));
        }
        blockDto.setStart_date(block.getStart_date());
        blockDto.setEnd_date(block.getEnd_date());
        return blockDto;
    }

    public static Place mapPlace(PlaceDto placeDTO) {
        Place place = new Place();
        place.setId(placeDTO.getId());
        place.setLabel(placeDTO.getLabel());
        place.setCreated_date(placeDTO.getCreated_date());
        place.setUpdated_date(placeDTO.getUpdated_date());
        place.setArchived_date(placeDTO.getArchived_date());
        place.setLatitude(placeDTO.getLatitude());
        place.setLongitude(placeDTO.getLongitude());

        return place;
    }

    public static List<PlaceDto> getAllPlaces(List<Place> places) {
        List<PlaceDto> placeDtoList = new ArrayList<>();
        places.forEach(r -> {
            placeDtoList.add(mapPlaceDto(r));
        });
        return placeDtoList;
    }

    public static List<BlockDto> getServiceBlockDtoList(List<Block> blocks) {
        List<BlockDto> blockDtoList = new ArrayList<>();
        blocks.forEach(r -> {
            blockDtoList.add(mapBlockDto(r));
        });
        return blockDtoList;
    }

    public static Schedule mapSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setId(scheduleDto.getId());
        schedule.setKey(scheduleDto.getKey());
        schedule.setCreated_date(scheduleDto.getCreated_date());
        schedule.setArchived_date(scheduleDto.getArchived_date());
        return schedule;
    }

    public static Block mapBlock(BlockDto blockDto) {
        Block block = new Block();
        block.setId(blockDto.getId());
        block.setKey(blockDto.getKey());
        block.setCreated_date(blockDto.getCreated_date());
        block.setArchived_date(blockDto.getArchived_date());
        block.setUpdated_date(blockDto.getUpdated_date());
        block.setPlace(mapPlace(blockDto.getPlace()));
        if(blockDto.getSchedule()!=null) {
            block.setSchedule(mapSchedule(blockDto.getSchedule()));
        }
        block.setStart_date(blockDto.getStart_date());
        block.setEnd_date(blockDto.getEnd_date());
        return block;
    }

}
