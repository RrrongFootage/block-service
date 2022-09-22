package com.rrrong.blockservice.controller;

import com.rrrong.blockservice.dto.BlockDto;
import com.rrrong.blockservice.dto.PlaceDto;
import com.rrrong.blockservice.dto.ScheduleDto;
import com.rrrong.blockservice.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("service-block")
public class BlockController {
    @Autowired
    private BlockService blockService;


    @GetMapping("/schedule/{id}")
    public ResponseEntity<ScheduleDto> getSchedule(@PathVariable("id") Integer id) {
        ScheduleDto schedule = blockService.getSchedule(id);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @GetMapping("/place/{id}")
    public ResponseEntity<PlaceDto> getPlace(@PathVariable("id") Integer id) {
        PlaceDto place = blockService.getPlace(id);
        return new ResponseEntity<>(place, HttpStatus.OK);
    }

    @GetMapping("/block/{id}")
    public ResponseEntity<BlockDto> getBlock(@PathVariable("id") Integer id) {
        BlockDto block = blockService.getBlock(id);
        return new ResponseEntity<>(block, HttpStatus.OK);
    }

    @PostMapping("/create-place")
    public ResponseEntity<PlaceDto> addPlace(@RequestBody PlaceDto placeDto) {
        PlaceDto newPlace = blockService.createPlace(placeDto);
        return new ResponseEntity<>(newPlace, HttpStatus.CREATED);
    }

    @PostMapping("/create-schedule")
    public ResponseEntity<ScheduleDto> addSchedule(@RequestBody ScheduleDto scheduleDto) {
        ScheduleDto newSchedule = blockService.createSchedule(scheduleDto);
        return new ResponseEntity<>(newSchedule, HttpStatus.CREATED);
    }

    @PostMapping("/create-service-block")
    public ResponseEntity<BlockDto> addServiceBlock(@RequestBody BlockDto blockDto) {
        BlockDto newServiceBlock = blockService.createServiceBlock(blockDto);
        return new ResponseEntity<>(newServiceBlock, HttpStatus.CREATED);
    }

    @GetMapping("/all/place")
    public ResponseEntity<List<PlaceDto>> getAllPlaces() {
        List<PlaceDto> placeDtoList = blockService.getAllPlaces();
        return new ResponseEntity<>(placeDtoList, HttpStatus.OK);
    }

    @PostMapping("/archive/place")
    public ResponseEntity archivePlace(@RequestBody PlaceDto placeDto) {
        blockService.archivePlace(placeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/archive/schedule")
    public ResponseEntity archiveSchedule(@RequestBody ScheduleDto scheduleDto) {
        blockService.archiveSchedule(scheduleDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/place")
    public ResponseEntity updatePlace(@RequestBody PlaceDto placeDto) {
        blockService.updatePlace(placeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/block")
    public ResponseEntity updateBlock(@RequestBody BlockDto blockDto) {
        blockService.updateServiceBlock(blockDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/serviceblock/schedules")
    public ResponseEntity<List<ScheduleDto>> getBlockSchedules(@RequestParam String startDate, @RequestParam String endDate) throws ParseException {
        List<ScheduleDto> scheduleDtoList = blockService.listBlockLinkedSchedulesByDate(startDate, endDate);

        return new ResponseEntity<>(scheduleDtoList, HttpStatus.OK);
    }

    @GetMapping("/serviceblocks")
    public ResponseEntity<List<BlockDto>> getServiceBlocksByRange(@RequestParam String startDate, @RequestParam String endDate) throws ParseException {
        List<BlockDto> blockDtoList = blockService.getServiceBlocksByRange(startDate, endDate);

        return new ResponseEntity<>(blockDtoList, HttpStatus.OK);
    }

    @PutMapping("/link/schedule/{id}")
    public ResponseEntity linkSchedule(@PathVariable int id, @RequestBody List<BlockDto> blockDtoList) {
        blockService.linkScheduleToBlock(id, blockDtoList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
