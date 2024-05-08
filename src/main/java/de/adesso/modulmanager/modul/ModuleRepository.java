package de.adesso.modulmanager.modul;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {

    Module findByModuleId(int moduleId);

 /*    @Modifying
    @Transactional
    @Query("UPDATE Module m SET m.description = :description WHERE m.moduleId = :moduleId")
    void updateModulebyModuleById(@Param("moduleId") Integer moduleId, @Param("description") String description); */
}
