package com.rrrong.blockservice.service.Impl;

import com.rrrong.blockservice.dto.BlockDto;
import com.rrrong.blockservice.dto.PlaceDto;
import com.rrrong.blockservice.dto.ScheduleDto;
import com.rrrong.blockservice.entity.Block;
import com.rrrong.blockservice.entity.Place;
import com.rrrong.blockservice.entity.Schedule;
import com.rrrong.blockservice.exception.NoPlaceFoundException;
import com.rrrong.blockservice.exception.NoScheduleFoundException;
import com.rrrong.blockservice.exception.NoServiceBlockFoundException;
import com.rrrong.blockservice.service.BlockService;
import com.rrrong.blockservice.service.Repository.BlockRepo;
import com.rrrong.blockservice.service.Repository.PlaceRepo;
import com.rrrong.blockservice.service.Repository.ScheduleRepo;
import com.rrrong.blockservice.util.UtilConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    PlaceRepo placeRepo;
    @Autowired
    ScheduleRepo scheduleRepo;
    @Autowired
    BlockRepo blockRepo;


    @Override
    public PlaceDto createPlace(PlaceDto placeDto) {
        Place place = placeRepo.save(UtilConverter.mapPlace(placeDto));
        return UtilConverter.mapPlaceDto(place);
    }

    @Override
    public ScheduleDto createSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = scheduleRepo.save(UtilConverter.mapSchedule(scheduleDto));
        return UtilConverter.mapScheduleDto(schedule);
    }

    @Override
    public BlockDto createServiceBlock(BlockDto blockDto) {
        Block block = blockRepo.save(UtilConverter.mapBlock(blockDto));
        return UtilConverter.mapBlockDto(block);
    }




    @Override
    public List<ScheduleDto> listBlockLinkedSchedulesByDate(String startDate, String endDate) {
        List<ScheduleDto> scheduleDtoList = new ArrayList<>();
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

        List<Block> blockList = blockRepo.findAll();

        for (Block block : blockList) {
            try {
                if (block.getSchedule() != null && sdformat.parse(block.getStart_date().toString()).after(sdformat.parse(startDate)) && sdformat.parse(block.getEnd_date().toString()).before(sdformat.parse(endDate))) {
                    scheduleDtoList.add(UtilConverter.mapScheduleDto(block.getSchedule()));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return scheduleDtoList;
    }

    @Transactional
    @Override
    public void updatePlace(PlaceDto placeDto) {
        placeRepo.updatePlace(placeDto.getLabel(), placeDto.getLatitude(), placeDto.getLongitude(), placeDto.getId());
    }

    @Transactional
    @Override
    public void archivePlace(PlaceDto placeDto) {
        placeRepo.archivePlace(placeDto.getId());
    }

    @Transactional
    @Override
    public void archiveSchedule(ScheduleDto scheduleDto) {
        scheduleRepo.archiveSchedule(scheduleDto.getId());
    }

    @Override
    public List<BlockDto> getServiceBlocksByRange(String startDate, String endDate) throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

            return UtilConverter.getServiceBlockDtoList(blockRepo.findAllByStart_dateLessThanEqualAnAndEnd_dateGreaterThanEqual(sdformat.parse(startDate), sdformat.parse(endDate)));
    }

    @Override
    @Transactional
    public void updateServiceBlock(BlockDto blockDto) {
        blockRepo.updateServiceBlock(blockDto.getStart_date(), blockDto.getEnd_date(), blockDto.getId());
    }

    @Override
    @Transactional
    public void linkScheduleToBlock(int scheduleId, List<BlockDto> serviceBlocks) {
        for (BlockDto blockDto : serviceBlocks) {
            blockRepo.linkScheduleToBlock(scheduleId, blockDto.getId());
        }
    }

    @Override
    public List<PlaceDto> getAllPlaces() {
        List<Place> place = placeRepo.findAll();
        if (place.size() > 0) {
            return UtilConverter.getAllPlaces(place);
        }
        return new ArrayList<>();
    }

    @Override
    public PlaceDto getPlace(Integer id) {
        Place place = placeRepo.findById(id)
                .orElseThrow(() -> new NoPlaceFoundException("The Place is not found for:" + " ID= " + id));
        return UtilConverter.mapPlaceDto(place);
    }

    @Override
    public ScheduleDto getSchedule(Integer id) {
        Schedule schedule = scheduleRepo.findById(id)
                .orElseThrow(() -> new NoScheduleFoundException("The Schedule is not found for:" + " ID= " + id));
        return UtilConverter.mapScheduleDto(schedule);
    }

    @Override
    public BlockDto getBlock(Integer id) {
        Block block = blockRepo.findById(id)
                .orElseThrow(() -> new NoServiceBlockFoundException("The Service Block is not found for:" + " ID= " + id));
        return UtilConverter.mapBlockDto(block);
    }

}
