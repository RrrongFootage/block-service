package com.rrrong.blockservice.service.Repository;

import com.rrrong.blockservice.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepo extends JpaRepository<Place, Integer> {

    @Modifying
    @Query("update place p set p.label = ?1, p.latitude = ?2, p.longitude = ?3 where p.id = ?4")
    void updatePlace(@Param("label") String label, @Param("latitude") double latitude, @Param("longitude") double longitude, @Param("id") int id);

    @Modifying
    @Query("update place p set p.archived_date = current_timestamp where p.id =?1")
    void archivePlace(@Param("id") int id);
}
