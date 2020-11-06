package com.wall.dc_slot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wall.dc_slot.model.Dc_Slot;

@Repository
public interface Dc_SlotRepository extends JpaRepository<Dc_Slot, Integer> {

}
