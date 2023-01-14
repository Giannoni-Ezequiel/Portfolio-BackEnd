package com.miaplicacion.primerproyecto.Repository;

import com.miaplicacion.primerproyecto.Entity.HyS;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HySRepository extends JpaRepository<HyS, Long>
{
    List<HyS> findAll();
    HyS save(HyS hys);
    void deleteHySById(Long id);
    HyS findHySById(Long id);
}
