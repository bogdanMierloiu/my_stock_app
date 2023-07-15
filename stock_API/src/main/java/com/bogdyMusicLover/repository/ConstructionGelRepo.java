package com.bogdyMusicLover.repository;

import com.bogdyMusicLover.entity.ConstructionGel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConstructionGelRepo extends JpaRepository<ConstructionGel, Long> {


    @Query("SELECT g FROM ConstructionGel g WHERE g.isAvailable = true")
    public List<ConstructionGel> getConstructionGelsAvailable();
}
